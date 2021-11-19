package com.ads.voteapi.domain.repositories;

import com.ads.voteapi.domain.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Modifying
    @Transactional
    @Query(" update Session s set s.status=:status where s.id=:id ")
    void hasClosedSession(@Param("id") Long id, @Param("status") Integer status);

    Session findByIdAndAndScheduleId(Long id, Long scheduleId);

}
