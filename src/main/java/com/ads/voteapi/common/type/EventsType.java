package com.ads.voteapi.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@Getter
@AllArgsConstructor
public enum EventsType {
    SENDING_MESSAGE_DELETE(0);

    private final Integer id;
}
