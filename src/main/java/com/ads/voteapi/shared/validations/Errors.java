package com.ads.voteapi.shared.validations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : andersons.andrade
 * @since : 17/11/21, quarta-feira
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errors {
    private String title;
    private String field;
    private String message;
}
