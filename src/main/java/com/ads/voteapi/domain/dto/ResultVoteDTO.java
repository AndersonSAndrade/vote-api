package com.ads.voteapi.domain.dto;

import com.ads.voteapi.domain.entity.Schedule;
import com.ads.voteapi.domain.entity.Session;
import com.ads.voteapi.domain.entity.Vote;
import lombok.Data;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Data
public class ResultVoteDTO {

    private Long id;
    private Vote vote;
    private Schedule scheduleId;
    private Session sessionId;
    private Integer yes;
    private Integer no;
}

