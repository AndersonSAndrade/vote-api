package com.ads.voteapi.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@Getter
@AllArgsConstructor
public class ActionEvent<T> {
    private final int typeEvent;
    private final T model;
}
