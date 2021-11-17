package com.ads.voteapi.configuration;

import com.ads.voteapi.domain.mapper.ScheduleMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ScheduleMapper scheduleMapper(){
        return new ScheduleMapper();
    }


}
