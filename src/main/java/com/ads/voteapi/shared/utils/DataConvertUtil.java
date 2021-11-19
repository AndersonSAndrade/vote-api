package com.ads.voteapi.shared.utils;

import com.ads.voteapi.services.impl.SessionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Slf4j
public class DataConvertUtil {
    private static final Logger LOG = LoggerFactory.getLogger(SessionServiceImpl.class);

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

    /**
     * Converting and formatting date to display on front
     * @param date
     * @param format
     * @return boolean
     * @author Anderson S. Andrade
     */
    public static String convertToDateFormat(Instant date, String format){
        try {
            Date newDate = Date.from(date);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(newDate);
        }catch (Exception e){
            LOG.info("ERROR FORMATTING DATE.");
        }
        return null;
    }

}
