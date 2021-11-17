package com.ads.voteapi.domain.mapper;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.entity.Schedule;
import org.modelmapper.ModelMapper;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
public class ScheduleMapper {
    private final ModelMapper modelMapper;

    public ScheduleMapper() {
        modelMapper = new ModelMapper();
    }

    /**
     * Converted Schedule para ScheduleDTO
     * @param entity
     * @return ScheduleDTO
     * @author Anderson S. Andrade
     */
    public ScheduleDTO entityToDto(Schedule entity) {
        return modelMapper.map(entity, ScheduleDTO.class);
    }

    /**
     * Converted ScheduleDTO para Schedule
     * @param dto
     * @return ScheduleDTO
     * @author Anderson S. Andrade
     */
    public Schedule dtoToEntity(ScheduleDTO dto) {
        return modelMapper.map(dto, Schedule.class);
    }
}
