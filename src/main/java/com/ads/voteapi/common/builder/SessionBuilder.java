package com.ads.voteapi.common.builder;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.dto.SessionDTO;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
public class SessionBuilder {

    /**
     * Build a list of {@link SessionDTO}
     * @return List<SessionDTO>
     * @author Anderson S. Andrade
     */
    public static List<SessionDTO> buildSessionDtoModelList(){
        List<SessionDTO> dtoList = new ArrayList<>();
        dtoList.add(buildeSessionDTOModel());
        return dtoList;
    }

    /**
     * Build the object of {@link SessionDTO}
     * @return SessionDTO
     * @author Anderson S. Andrade
     */
    public static SessionDTO buildeSessionDTOModel(){
        SessionDTO model = new SessionDTO();
        model.setStartSession(Instant.now());
        model.setEndSession(Instant.now().plus(10, ChronoUnit.MINUTES));
        model.setSchedule(ScheduleBuilder.buildeScheduleForId());
        model.setStatus(1);
        return model;
    }

    /**
     * Build the object of {@link SessionDTO}
     * @return SessionDTO
     * @author Anderson S. Andrade
     */
    public static SessionDTO buildeSessionOpen(){
        SessionDTO model = new SessionDTO();
        model.setSchedule(ScheduleBuilder.buildeScheduleForId());
        return model;
    }

    /**
     * Build the object of {@link SessionDTO}
     * @return SessionDTO
     * @author Anderson S. Andrade
     */
    public static SessionDTO buildeSessionId(){
        SessionDTO model = new SessionDTO();
        model.setId(1L);
        model.setSchedule(ScheduleBuilder.buildeScheduleForId());
        return model;
    }

}
