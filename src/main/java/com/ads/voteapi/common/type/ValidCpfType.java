package com.ads.voteapi.common.type;

/**
 * @author : andersons.andrade
 * @since : 18/11/21, quinta-feira
 **/
public enum ValidCpfType {

    ABLE_TO_VOTE("ABLE_TO_VOTE"),
    UNABLE_TO_VOTE("UNABLE_TO_VOTE");

    private final String id;

    ValidCpfType(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return id;
    }
}
