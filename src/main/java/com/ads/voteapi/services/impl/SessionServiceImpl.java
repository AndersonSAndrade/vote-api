package com.ads.voteapi.services.impl;

import com.ads.voteapi.common.type.SessionType;
import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.domain.entity.Session;
import com.ads.voteapi.domain.mapper.ScheduleMapper;
import com.ads.voteapi.domain.mapper.SessionMapper;
import com.ads.voteapi.domain.repositories.ScheduleRepository;
import com.ads.voteapi.domain.repositories.SessionRepository;
import com.ads.voteapi.services.interfaces.SessionService;
import com.ads.voteapi.shared.utils.DataConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SessionServiceImpl implements SessionService {
    private static final Logger LOG = LoggerFactory.getLogger(SessionServiceImpl.class);
    private static final String SESSION_NOT_FOUND = "Session not found or does not exist.";

    private final SessionRepository sessionRepository;
    private final ScheduleRepository scheduleRepository;
    private final SessionMapper sessionMapper;
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<SessionDTO> findAll() {
        LOG.info("LISTING SESSION");
        return sessionRepository.findAll()
                .stream()
                .map(sessionMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SessionDTO findById(Long id) {
        LOG.info("FIND SESSION BY ID");
        return sessionRepository.findById(id)
                .map(sessionMapper::entityToDto)
                .orElseThrow(() -> new IllegalArgumentException(SESSION_NOT_FOUND));
    }

    @Override
    @Transactional
    public SessionDTO openingSession(SessionDTO dto) {
        LOG.info("OPENING SESSION");
        Session session = new Session();
        if(dto != null){
            ScheduleDTO scheduleDTO = scheduleRepository.findById(dto.getSchedule().getId())
                    .map(scheduleMapper::entityToDto)
                    .orElseThrow(() -> new IllegalArgumentException(SESSION_NOT_FOUND));
            dto.setSchedule(scheduleDTO);

            session = sessionMapper.dtoToEntity(dto);
            session.setStatus(SessionType.OPEN.getId());
        }

        return sessionMapper.entityToDto(sessionRepository.save(session));
    }

    @Override
    public List<SessionDTO> closedSessions() {
        List<SessionDTO> listSessions = sessionRepository.findAll()
                .stream()
                .filter(f -> SessionType.OPEN.getId().equals(f.getStatus()))
                .map(sessionMapper::entityToDto)
                .collect(Collectors.toList());

        if(!listSessions.isEmpty()){
            listSessions.forEach(session -> {
                Date convertDate = Date.from(session.getEndSession());
                if(DataConvertUtil.isBefore(convertDate, new Date())){
                    sessionRepository.hasClosedSession(session.getId(), 0);
                }
            });
        }
        return listSessions;
    }
}
