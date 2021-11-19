package com.ads.voteapi.domain.repositories;

import com.ads.voteapi.domain.entity.ResultVote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public interface ResultVoteRepository extends JpaRepository<ResultVote, Long> {

}
