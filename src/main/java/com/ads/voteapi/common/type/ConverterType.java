package com.ads.voteapi.common.type;

import java.text.SimpleDateFormat;

/**
 * @author : andersons.andrade
 * @since : 18/11/21, quinta-feira
 **/
public enum ConverterType {

    DAY_MONTH_YEAR(new SimpleDateFormat("dd/MM/yyyy")),
    YEAR_MONTH_DAY(new SimpleDateFormat("yyyy/MM/dd"));

    private final SimpleDateFormat id;

    ConverterType(SimpleDateFormat id){
        this.id = id;
    }

    public SimpleDateFormat getId() {
        return id;
    }

    public SimpleDateFormat getValue() {
        return id;
    }
}
