package com.ads.voteapi.shared.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public class JsonUtil {


    /**
     * Convert object to json
     * @param obj
     * @return String
     * @author Anderson S. Andrade
     */
    public static String toJson(Object obj){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }

}
