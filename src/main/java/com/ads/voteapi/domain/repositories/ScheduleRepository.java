package com.ads.voteapi.domain.repositories;

import com.ads.voteapi.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
