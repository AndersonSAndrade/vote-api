package com.ads.voteapi.domain.dto;

import com.ads.voteapi.common.type.VoteType;
import lombok.Data;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/

@Data
public class VoteDTO {

    private Long id;
    private VoteType voting;
    private String associate;
    private SessionDTO session;
}
