package com.ads.voteapi.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Getter
@AllArgsConstructor
public enum SessionType {

    CLOSED(0),
    OPEN(1);

    private final Integer id;
}
