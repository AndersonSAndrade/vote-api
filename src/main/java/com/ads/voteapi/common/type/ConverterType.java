package com.ads.voteapi.common.type;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public enum ConverterType {

    DAY_MONTH_YEAR("dd/MM/yyyy"),
    DAY_MONTH_YEAR_TIME("dd/MM/yyyy HH:mm"),
    YEAR_MONTH_DAY("yyyy/MM/dd");

    private final String id;

    ConverterType(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return id;
    }
}
