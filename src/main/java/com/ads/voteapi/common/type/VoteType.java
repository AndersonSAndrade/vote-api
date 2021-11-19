package com.ads.voteapi.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@Getter
@AllArgsConstructor
public enum VoteType {

    DEFAULT(0),
    NO(1),
    YES(2);

    private final Integer id;
}
