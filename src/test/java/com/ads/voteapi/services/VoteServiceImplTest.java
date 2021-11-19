package com.ads.voteapi.services;

import com.ads.voteapi.common.ResultPresenter;
import com.ads.voteapi.common.builder.VoteBuilder;
import com.ads.voteapi.domain.dto.VoteDTO;
import com.ads.voteapi.domain.repositories.ScheduleRepository;
import com.ads.voteapi.services.interfaces.VoteService;
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
 * @since : 18/11/21, quinta-feira
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class VoteServiceImplTest {

    @Mock
    private VoteService voteService;

    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll(){
        try {
            Mockito.when(voteService.findAll()).thenReturn(VoteBuilder.buildVoteDtoModelList());
            voteService.findAll();
        } catch (Exception e){
            Assert.fail("Method VoteService findAll error: " + e.getMessage());
        }
    }

    @Test
    public void findById(){
        try{
            Mockito.when(voteService.findById(Mockito.anyLong())).thenReturn(VoteBuilder.buildeVoteDTOModel());
            VoteDTO model = voteService.findById(1L);
            Assertions.assertThat(model).isNotNull();
        } catch (Exception e){
            Assert.fail("Method VoteService findAll error: " + e.getMessage());
        }
    }

    @Test
    public void voting(){
        try {
            VoteDTO dto = new VoteDTO();
            Mockito.when(voteService.voting(Mockito.any(dto.getClass()))).thenReturn(VoteBuilder.buildeResultPresenterModel());
            ResultPresenter presenter = voteService.voting(dto);
            Assertions.assertThat(presenter).isNotNull();
        } catch (Exception e){
            Assert.fail("Method VoteService Save error: " + e.getMessage());
        }
    }


}
