package com.ads.voteapi.configuration;

import com.ads.voteapi.domain.mapper.ResultVoteMapper;
import com.ads.voteapi.domain.mapper.ScheduleMapper;
import com.ads.voteapi.domain.mapper.SessionMapper;
import com.ads.voteapi.domain.mapper.VoteMapper;
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

    @Bean
    public SessionMapper sessionMapper(){
        return new SessionMapper();
    }

    @Bean
    public VoteMapper voteMapper(){
        return new VoteMapper();
    }

    @Bean
    public ResultVoteMapper resultVoteMapper(){
        return new ResultVoteMapper();
    }

}
