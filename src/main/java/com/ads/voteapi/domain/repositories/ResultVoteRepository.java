package com.ads.voteapi.domain.repositories;

import com.ads.voteapi.domain.entity.ResultVote;
import com.ads.voteapi.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public interface ResultVoteRepository extends JpaRepository<ResultVote, Long> {

}
