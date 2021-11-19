package com.ads.voteapi.services;

import com.ads.voteapi.common.builder.ScheduleBuilder;
import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.services.interfaces.ScheduleService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class ScheduleServiceImplTest {

    @Mock
    private ScheduleService scheduleService;

    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void save(){
        try {
            ScheduleDTO dto = new ScheduleDTO();
            Mockito.when(scheduleService.save(Mockito.any(dto.getClass()))).thenReturn(new ScheduleDTO());
            ScheduleDTO modelDto = scheduleService.save(dto);
            Assertions.assertThat(modelDto).isNotNull();
        } catch (Exception e){
            Assert.fail("Method ScheduelService Save error: " + e.getMessage());
        }
    }

    @Test
    public void findAll(){
       try {
           Mockito.when(scheduleService.findAll()).thenReturn(ScheduleBuilder.buildScheduleDtoModelList());
           scheduleService.findAll();
       } catch (Exception e){
           Assert.fail("Method ScheduelService findAll error: " + e.getMessage());
       }
    }

    @Test
    public void findById(){
        try{
            Mockito.when(scheduleService.findById(Mockito.anyLong())).thenReturn(new ScheduleDTO());
            ScheduleDTO model = scheduleService.findById(1L);
            Assertions.assertThat(model).isNotNull();
        } catch (Exception e){
            Assert.fail("Method ScheduelService findAll error: " + e.getMessage());
        }
    }

}
