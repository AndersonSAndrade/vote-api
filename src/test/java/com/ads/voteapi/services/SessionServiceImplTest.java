package com.ads.voteapi.services;

import com.ads.voteapi.common.builder.SessionBuilder;
import com.ads.voteapi.common.param.OpenSessionParam;
import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.services.interfaces.SessionService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class SessionServiceImplTest {


    @Mock
    private SessionService sessionService;

    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll(){
        try {
            Mockito.when(sessionService.findAll()).thenReturn(SessionBuilder.buildSessionDtoModelList());
            sessionService.findAll();
        } catch (Exception e){
            Assert.fail("Method SessionService findAll error: " + e.getMessage());
        }
    }

    @Test
    public void findById(){
        try{
            Mockito.when(sessionService.findById(Mockito.anyLong())).thenReturn(SessionBuilder.buildeSessionDTOModel());
            SessionDTO model = sessionService.findById(1L);
            Assertions.assertThat(model).isNotNull();
        } catch (Exception e){
            Assert.fail("Method SessionService findAll error: " + e.getMessage());
        }
    }

    @Test
    public void openingSession(){
        try {
            OpenSessionParam param = new OpenSessionParam();
            Mockito.when(sessionService.openingSession(Mockito.any(OpenSessionParam.class))).thenReturn(SessionBuilder.buildeSessionDTOModel());
            SessionDTO modelDto = sessionService.openingSession(param);
            Assertions.assertThat(modelDto).isNotNull();
        } catch (Exception e){
            Assert.fail("Method SessionService Save error: " + e.getMessage());
        }
    }

    @Test
    public void closedSessions(){
        try {
            List<SessionDTO> list = sessionService.closedSessions();
            Assertions.assertThat(list).isEmpty();
        } catch (Exception e){
            Assert.fail("Method SessionService Save error: " + e.getMessage());
        }
    }

}
