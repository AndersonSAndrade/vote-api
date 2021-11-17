package com.ads.voteapi.shared.validations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String msgUser;
    private String msgDev;
    private String path;
    private List<Object> error;

    public CustomError(String msgUser, String msgDev) {
        this.msgUser = msgUser;
        this.msgDev = msgDev;
    }
}
