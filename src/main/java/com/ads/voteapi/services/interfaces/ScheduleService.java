package com.ads.voteapi.services.interfaces;

import com.ads.voteapi.domain.dto.ScheduleDTO;

import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
public interface ScheduleService {

    List<ScheduleDTO> findAll();
    ScheduleDTO findById(Long id) throws Exception;
    ScheduleDTO save(ScheduleDTO dto);
    ScheduleDTO updated(ScheduleDTO dto);
    void delete(Long id);

}
