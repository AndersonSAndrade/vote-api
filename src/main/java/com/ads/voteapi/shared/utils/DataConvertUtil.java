package com.ads.voteapi.shared.utils;

import java.util.Date;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public class DataConvertUtil {

    public static final String DATA_FMT_USA = "yyyy-MM-dd";

    /**
     * Checking if the date is greater than today's date
     * @param date1
     * @param date2
     * @return boolean
     * @author Anderson S. Andrade
     */
    public static boolean isBefore(Date date1, Date date2){
        return date1.before(date2);
    }

    /**
     * Checking if the date is less than today's date
     * @param date1
     * @param date2
     * @return boolean
     * @author Anderson S. Andrade
     */
    public static boolean isAfter(Date date1, Date date2){
        return date1.after(date2);
    }

}
