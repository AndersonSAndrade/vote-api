package com.ads.voteapi.domain.dto;

import lombok.Data;

import java.time.Instant;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/

@Data
public class SessionDTO {
    private Long id;
    private Integer status;
    private Instant startSession;
    private Instant endSession;
    private ScheduleDTO schedule;
}
