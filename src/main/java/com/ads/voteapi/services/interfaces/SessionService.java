package com.ads.voteapi.services.interfaces;

import com.ads.voteapi.domain.dto.SessionDTO;

import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public interface SessionService {

    List<SessionDTO> findAll();
    SessionDTO findById(Long id);
    SessionDTO openingSession(SessionDTO dto);
    List<SessionDTO> closedSessions();

}
