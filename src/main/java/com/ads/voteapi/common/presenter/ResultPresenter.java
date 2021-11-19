package com.ads.voteapi.common.presenter;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import lombok.Data;

/**
 * @author : Anderson S.Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Data
public class ResultPresenter {
    private Long id;
    private Integer status;
    private String startSession;
    private String endSession;
    private ScheduleDTO schedule;
    private Integer qntVoteYes;
    private Integer qntVoteNo;
    private Integer totalVotes;
}
