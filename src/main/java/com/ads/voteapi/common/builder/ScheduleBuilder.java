package com.ads.voteapi.common.builder;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
public class ScheduleBuilder {

    /**
     * Build the object of {@link ScheduleDTO}
     * @return ScheduleDTO
     * @author Anderson S. Andrade
     */
    public static ScheduleDTO buildeScheduleDTOModel(){
        ScheduleDTO model = new ScheduleDTO();
        model.setName("Java e melhor que PHP?");
        model.setDescription("Diga Sim para Java e Não para Não PHP");
        return model;
    }

    /**
     * Build a list of {@link ScheduleDTO}
     * @return List<ScheduleDTO>
     * @author Anderson S. Andrade
     */
    public static List<ScheduleDTO> buildScheduleDtoModelList(){
        List<ScheduleDTO> dtoList = new ArrayList<>();
        dtoList.add(buildeScheduleDTOModel());
        return dtoList;
    }

    /**
     * Build the object of {@link Schedule}
     * @return Schedule
     * @author Anderson S. Andrade
     */
    public static Schedule buildeScheduleModel(){
        Schedule schedule = new Schedule();
        schedule.setName("Schedule Named");
        schedule.setDescription("Schedule Description test");
        return schedule;
    }

    /**
     * Build a list of {@link Schedule}
     * @return List<Schedule>
     * @author Anderson S. Andrade
     */
    public static List<Schedule> buildScheduleModelList(){
        List<Schedule> dtoList = new ArrayList<>();
        dtoList.add(buildeScheduleModel());
        return dtoList;
    }

    /**
     * Build the object of {@link ScheduleDTO}
     * @return ScheduleDTO
     * @author Anderson S. Andrade
     */
    public static ScheduleDTO buildeScheduleForId(){
        ScheduleDTO model = new ScheduleDTO();
        model.setId(1L);
        model.setName("Java e melhor que PHP?");
        model.setDescription("Diga Sim para Java e Não para Não PHP");
        return model;
    }

}
