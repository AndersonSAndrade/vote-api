package com.ads.voteapi.domain.repositories;

import com.ads.voteapi.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Vote findBySessionIdAndAssociate(Long sessionId, String associateId);

}
