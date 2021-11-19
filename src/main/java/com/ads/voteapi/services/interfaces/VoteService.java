package com.ads.voteapi.services.interfaces;

import com.ads.voteapi.common.presenter.ResultPresenter;
import com.ads.voteapi.domain.dto.VoteDTO;

import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public interface VoteService {

    List<VoteDTO> findAll();
    VoteDTO findById(Long id);
    ResultPresenter voting(VoteDTO dto);

}
