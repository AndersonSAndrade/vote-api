package com.ads.voteapi.services.impl;

import com.ads.voteapi.common.ResultPresenter;
import com.ads.voteapi.common.type.SessionType;
import com.ads.voteapi.common.type.ValidCpfType;
import com.ads.voteapi.common.type.VoteType;
import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.domain.dto.VoteDTO;
import com.ads.voteapi.domain.entity.ResultVote;
import com.ads.voteapi.domain.entity.Schedule;
import com.ads.voteapi.domain.entity.Session;
import com.ads.voteapi.domain.entity.Vote;
import com.ads.voteapi.domain.mapper.SessionMapper;
import com.ads.voteapi.domain.mapper.VoteMapper;
import com.ads.voteapi.domain.repositories.ResultVoteRepository;
import com.ads.voteapi.domain.repositories.ScheduleRepository;
import com.ads.voteapi.domain.repositories.SessionRepository;
import com.ads.voteapi.domain.repositories.VoteRepository;
import com.ads.voteapi.services.integration.IntegrationService;
import com.ads.voteapi.services.interfaces.VoteService;
import com.ads.voteapi.shared.validations.SessionException;
import com.ads.voteapi.shared.validations.VoteException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VoteServiceImpl implements VoteService {
    private static final Logger LOG = LoggerFactory.getLogger(VoteServiceImpl.class);
    private static final String SESSION_NOT_FOUND = "Session not found or does not exist.";
    private static final String VOTE_NOT_FOUND = "Votes not found or does not exist.";
    private static final String SCHEDULE_NOT_FOUND = "Staff not found or don't exist.";


    private final VoteRepository voteRepository;
    private final SessionRepository sessionRepository;
    private final ScheduleRepository scheduleRepository;
    private final ResultVoteRepository resultVoteRepository;
    private final VoteMapper voteMapper;
    private final SessionMapper sessionMapper;
    private final IntegrationService integrationService;

    @Override
    public List<VoteDTO> findAll() {
        LOG.info("LISTING VOTE");
        return voteRepository.findAll()
                .stream()
                .map(voteMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VoteDTO findById(Long id) {
        LOG.info("LISTING VOTE");
        return voteRepository.findById(id)
                .map(voteMapper::entityToDto)
                .orElseThrow(() -> new IllegalArgumentException(VOTE_NOT_FOUND));
    }

    @Override
    public ResultPresenter voting(VoteDTO dto) {
        LOG.info("STARTING VOTING");
        ResultPresenter presenter = new ResultPresenter();
        SessionDTO sessionDTO = sessionRepository.findById(dto.getSession().getId())
                .map(sessionMapper::entityToDto)
                .orElseThrow(() -> new IllegalArgumentException(SESSION_NOT_FOUND));

        validationVote(dto, sessionDTO);

        VoteDTO voteDTO = savedVote(dto, sessionDTO);
        ResultVote resultVote = votings(sessionDTO, voteDTO);
        converteToPresenter(presenter, sessionDTO, resultVote);

        return presenter;
    }

    /**
     * Converting data to present after voting
     * @param presenter
     * @param sessionDTO
     * @param resultVote
     * @author Anderson S. Andrade
     */
    private void converteToPresenter(ResultPresenter presenter, SessionDTO sessionDTO, ResultVote resultVote) {
        presenter.setSchedule(sessionDTO.getSchedule());
        presenter.setStartSession(sessionDTO.getStartSession());
        presenter.setEndSession(sessionDTO.getEndSession());
        presenter.setStatus(sessionDTO.getStatus());
        presenter.setId(resultVote.getId());

        int yes = 0;
        int no = 0;

        Session session = sessionRepository.findByIdAndAndScheduleId(resultVote.getSessionId().getId(), resultVote.getScheduleId().getId());
        if(session != null){
            yes = session.getVotes().stream()
                    .filter(f -> VoteType.YES.getId().equals(f.getVoting().getId()))
                    .collect(Collectors.toList()).size();

            no = session.getVotes().stream()
                    .filter(f -> VoteType.NO.getId().equals(f.getVoting().getId()))
                    .collect(Collectors.toList()).size();
            presenter.setQntVoteYes(yes);
            presenter.setQntVoteNo(no);
            presenter.setTotalVotes(session.getVotes().size());
        }
    }

    /**
     * Evaluating votes with exceptions
     * @param dto
     * @param sessionDTO
     * @author Anderson S. Andrade
     */
    private void validationVote(VoteDTO dto, SessionDTO sessionDTO) {

        if(dto.getAssociate() != null){
           String valid = integrationService.validCpfType(dto.getAssociate());
           if(ValidCpfType.UNABLE_TO_VOTE.getValue().equals(valid)){
               throw new VoteException("The CPF informed is not able to vote. STATUS: ".concat(valid));
           }
        }

        if(SessionType.CLOSED.getId().equals(sessionDTO.getStatus())){
            throw new SessionException("Session closed, inform an open session for voting.");
        }

        Vote validVote = voteRepository.findBySessionIdAndAssociate(sessionDTO.getId(), dto.getAssociate());
        if(validVote != null){
            throw new SessionException("The member informed has already made his vote, please insert a new associate.");
        }
    }

    /**
     * Persisting vote in the database
     * @param dto
     * @param sessionDTO
     * @return VoteDTO
     * @author Anderson S. Andrade
     */
    private VoteDTO savedVote(VoteDTO dto, SessionDTO sessionDTO) {
        VoteDTO votodto = new VoteDTO();
        votodto.setVoting(dto.getVoting());
        votodto.setSession(sessionDTO);
        votodto.setAssociate(dto.getAssociate());

        Vote newVote = voteRepository.save(voteMapper.dtoToEntity(votodto));
        return voteMapper.entityToDto(newVote);
    }

    /**
     * Validating vote and adding to relationship
     * @param sessionDTO
     * @param voteDTO
     * @author Anderson S. Andrade
     */
    private ResultVote votings(SessionDTO sessionDTO, VoteDTO voteDTO){
        ResultVote dto = new ResultVote();
        if(sessionDTO != null){
            Schedule schedule = scheduleRepository.findById(sessionDTO.getSchedule().getId()).orElseThrow(() ->
                            new IllegalArgumentException(SCHEDULE_NOT_FOUND));
            dto.setScheduleId(schedule);
            dto.setSessionId(sessionMapper.dtoToEntity(sessionDTO));
        }
        dto.setVote(voteMapper.dtoToEntity(voteDTO));
        dto.setVoting(voteDTO.getVoting().getId());


       ResultVote result = resultVoteRepository.save(dto);
       if(result == null){
           throw  new VoteException("Error persisting data");
       }
       return result;
    }
}
