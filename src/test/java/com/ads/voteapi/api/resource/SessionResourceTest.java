package com.ads.voteapi.api.resource;

import com.ads.voteapi.common.builder.SessionBuilder;
import com.ads.voteapi.common.builder.VoteBuilder;
import com.ads.voteapi.common.param.OpenSessionParam;
import com.ads.voteapi.domain.dto.VoteDTO;
import com.ads.voteapi.services.interfaces.SessionService;
import com.ads.voteapi.services.interfaces.VoteService;
import com.ads.voteapi.shared.utils.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(value = SessionResource.class)
public class SessionResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SessionService sessionService;

    @MockBean
    private VoteService voteService;


    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Teste the method {@link SessionResource#openingSession(OpenSessionParam, HttpServletResponse)}
     * @author Anderson S. Andrade
     */
    @Test
    public void openingSession() {
       try {
           Mockito.when(sessionService.openingSession(Mockito.any(OpenSessionParam.class))).thenReturn(SessionBuilder.buildeSessionDTOModel());
           Mockito.when(voteService.voting(Mockito.any(VoteDTO.class))).thenReturn(VoteBuilder.buildeResultPresenterModel());
           MvcResult mvcResult = getMvc()
                   .perform(MockMvcRequestBuilders.post("/v1/session/opening")
                           .content(JsonUtil.toJson(SessionBuilder.buildeSessionOpen()))
                           .contentType(MediaType.APPLICATION_JSON))
                   .andExpect(MockMvcResultMatchers.status().isCreated())
                   .andReturn();

           MockHttpServletResponse response = mvcResult.getResponse();
           Assertions.assertThat(response).isNotNull();
           Assertions.assertThat(response.getStatus()).isEqualTo(201);
       }catch (Exception ex){
           Assert.fail("Method error: " + ex.getMessage());
       }
    }

    /**
     * Teste the method {@link SessionResource#findById(Long)}
     * @throws Exception
     * @author Anderson S. Andrade
     */
    @Test
    public void findById() throws Exception {
        try {
            Mockito.when(sessionService.findById(1L)).thenReturn(SessionBuilder.buildeSessionDTOModel());
            MvcResult mvcResult = getMvc()
                    .perform(MockMvcRequestBuilders.get("/v1/session/1")
                            .param("id", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            Assertions.assertThat(response).isNotNull();
            Assertions.assertThat(response.getStatus()).isEqualTo(200);
        }catch (Exception ex){
            Assert.fail("Method error: " + ex.getMessage());
        }
    }

    /**
     * Teste the method {@link SessionResource#findAll()}
     * @throws Exception
     * @author Anderson S. Andrade
     */
    @Test
    public void findAll() throws Exception {
        try {
            Mockito.when(sessionService.findAll()).thenReturn(SessionBuilder.buildSessionDtoModelList());
            MvcResult mvcResult = getMvc()
                    .perform(MockMvcRequestBuilders.get("/v1/session")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            Assertions.assertThat(response).isNotNull();
            Assertions.assertThat(response.getStatus()).isEqualTo(200);
        }catch (Exception ex){
            Assert.fail("Method error: " + ex.getMessage());
        }
    }


    /**
     * Teste the method {@link SessionResource#voting(VoteDTO)}
     * @throws Exception
     * @author Anderson S. Andrade
     */
    @Test
    public void voting() throws Exception {
        try {
            Mockito.when(voteService.voting(Mockito.any(VoteDTO.class))).thenReturn(VoteBuilder.buildeResultPresenterModel());
            MvcResult mvcResult = getMvc()
                    .perform(MockMvcRequestBuilders.post("/v1/session/voting")
                            .content(JsonUtil.toJson(VoteBuilder.buildeVoteParam()))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            Assertions.assertThat(response).isNotNull();
            Assertions.assertThat(response.getStatus()).isEqualTo(201);
        }catch (Exception ex){
            Assert.fail("Method error: " + ex.getMessage());
        }
    }

    public MockMvc getMvc(){
        return mvc;
    }

    public String toJson(Object obj){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }

}
