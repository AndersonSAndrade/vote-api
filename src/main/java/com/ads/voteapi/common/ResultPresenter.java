package com.ads.voteapi.common;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import lombok.Data;

import java.time.Instant;

/**
 * @author : Anderson S.Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Data
public class ResultPresenter {
    private Long id;
    private Integer status;
    private Instant startSession;
    private Instant endSession;
    private ScheduleDTO schedule;
    private Integer qntVoteYes;
    private Integer qntVoteNo;
    private Integer totalVotes;
}
