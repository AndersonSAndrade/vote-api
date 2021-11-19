package com.ads.voteapi.services.impl;


import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.entity.Schedule;
import com.ads.voteapi.domain.mapper.ScheduleMapper;
import com.ads.voteapi.domain.repositories.ScheduleRepository;
import com.ads.voteapi.services.interfaces.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScheduleServiceImpl implements ScheduleService {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    private static final String RESOURCE_NOT_FOUND = "Staff not found or don't exist.";

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDTO> findAll() {
        LOG.info("LISTING ALL SCHEDULES");
        return scheduleRepository.findAll()
                .stream()
                .map(scheduleMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO findById(Long id) {
        LOG.info("Resource is not exists.");
        return scheduleRepository.findById(id)
                .map(scheduleMapper::entityToDto)
                .orElseThrow(() ->
                        new IllegalArgumentException(RESOURCE_NOT_FOUND));
    }

    @Override
    public ScheduleDTO save(ScheduleDTO dto) {
        Schedule schedule = scheduleMapper.dtoToEntity(dto);
        return scheduleMapper.entityToDto(scheduleRepository.save(schedule));
    }

    @Override
    public ScheduleDTO updated(ScheduleDTO dto) {
        Schedule schedule = scheduleRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException(RESOURCE_NOT_FOUND));
        schedule.setName(dto.getName());
        schedule.setDescription(dto.getDescription());
        return scheduleMapper.entityToDto(scheduleRepository.save(schedule));
    }

    @Override
    public void delete(Long id) {
        ScheduleDTO scheduleDTO = scheduleRepository.findById(id)
                .map(scheduleMapper::entityToDto)
                .orElseThrow(() -> new IllegalArgumentException(RESOURCE_NOT_FOUND));
        scheduleRepository.deleteById(scheduleDTO.getId());
    }


}
