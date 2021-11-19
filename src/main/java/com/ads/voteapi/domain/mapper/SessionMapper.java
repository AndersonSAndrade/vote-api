package com.ads.voteapi.domain.mapper;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.domain.entity.Schedule;
import com.ads.voteapi.domain.entity.Session;
import org.modelmapper.ModelMapper;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
public class SessionMapper {
    private final ModelMapper modelMapper;

    public SessionMapper() {
        modelMapper = new ModelMapper();
    }

    /**
     * Converted Session para SessionDTO
     * @param entity
     * @return SessionDTO
     * @author Anderson S. Andrade
     */
    public SessionDTO entityToDto(Session entity) {
        return modelMapper.map(entity, SessionDTO.class);
    }

    /**
     * Converted SessionDTO para Session
     * @param dto
     * @return SessionDTO
     * @author Anderson S. Andrade
     */
    public Session dtoToEntity(SessionDTO dto) {
        return modelMapper.map(dto, Session.class);
    }
}
