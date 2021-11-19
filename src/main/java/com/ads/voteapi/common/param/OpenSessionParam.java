package com.ads.voteapi.common.param;

import lombok.Data;

/**
 * @author : andersons.andrade
 * @since : 19/11/21, sexta-feira
 **/
@Data
public class OpenSessionParam {
    private Long idSchedule;
    private Integer timeCloseSession;
}
