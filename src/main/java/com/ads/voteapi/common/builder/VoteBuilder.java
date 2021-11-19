package com.ads.voteapi.common.builder;

import com.ads.voteapi.common.presenter.ResultPresenter;
import com.ads.voteapi.common.type.ConverterType;
import com.ads.voteapi.common.type.VoteType;
import com.ads.voteapi.domain.dto.VoteDTO;
import com.ads.voteapi.shared.utils.DataConvertUtil;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
public class VoteBuilder {


    /**
     * Build a list of {@link VoteDTO}
     * @return List<VoteDTO>
     * @author Anderson S. Andrade
     */
    public static List<VoteDTO> buildVoteDtoModelList(){
        List<VoteDTO> dtoList = new ArrayList<>();
        dtoList.add(buildeVoteDTOModel());
        return dtoList;
    }

    /**
     * Build the object of {@link VoteDTO}
     * @return VoteDTO
     * @author Anderson S. Andrade
     */
    public static VoteDTO buildeVoteDTOModel(){
        VoteDTO model = new VoteDTO();
        model.setId(1L);
        model.setVoting(VoteType.YES);
        model.setSession(SessionBuilder.buildeSessionDTOModel());
        model.setAssociate("15349052004");
        return model;
    }

    /**
     * Build the object of {@link VoteDTO}
     * @return VoteDTO
     * @author Anderson S. Andrade
     */
    public static VoteDTO buildeVoteParam(){
        VoteDTO model = new VoteDTO();
        model.setVoting(VoteType.YES);
        model.setSession(SessionBuilder.buildeSessionId());
        model.setAssociate("15349052004");
        return model;
    }


    /**
     * Build the object of {@link ResultPresenter}
     * @return ResultPresenter
     * @author Anderson S. Andrade
     */
    public static ResultPresenter buildeResultPresenterModel(){
        ResultPresenter model = new ResultPresenter();
        model.setId(1L);
        model.setSchedule(ScheduleBuilder.buildeScheduleDTOModel());
        model.setStatus(1);
        model.setStartSession(DataConvertUtil.convertToDateFormat(Instant.now(), ConverterType.DAY_MONTH_YEAR.getId()));
        model.setEndSession(DataConvertUtil.convertToDateFormat(Instant.now().plus(1, ChronoUnit.MINUTES), ConverterType.DAY_MONTH_YEAR.getId()));
        model.setQntVoteYes(2);
        model.setQntVoteNo(1);
        model.setTotalVotes(3);
        return model;
    }

}
