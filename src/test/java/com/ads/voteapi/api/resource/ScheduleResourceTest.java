package com.ads.voteapi.api.resource;

import com.ads.voteapi.common.builder.ScheduleBuilder;
import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.domain.repositories.ScheduleRepository;
import com.ads.voteapi.services.interfaces.ScheduleService;
import com.ads.voteapi.shared.utils.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
@WebMvcTest(value = ScheduleResource.class)
public class ScheduleResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ScheduleService scheduleService;


    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Teste the method {@link ScheduleResource#save(ScheduleDTO, HttpServletResponse)}
     * @throws Exception
     * @author Anderson S. Andrade
     */
    @Test
    public void save() throws Exception {
       try {
           Mockito.when(scheduleService.save(Mockito.any())).thenReturn(ScheduleBuilder.buildeScheduleDTOModel());
           MvcResult mvcResult = getMvc()
                   .perform(MockMvcRequestBuilders.post("/v1/schedule/save")
                           .content(JsonUtil.toJson(ScheduleBuilder.buildeScheduleDTOModel()))
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
     * Teste the method {@link ScheduleResource#findById(Long)}
     * @throws Exception
     * @author Anderson S. Andrade
     */
    @Test
    public void findById() throws Exception {
        try {
            Mockito.when(scheduleService.findById(1L)).thenReturn(ScheduleBuilder.buildeScheduleDTOModel());
            MvcResult mvcResult = getMvc()
                    .perform(MockMvcRequestBuilders.get("/v1/schedule/1")
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
     * Teste the method {@link ScheduleResource#findAll()}
     * @throws Exception
     * @author Anderson S. Andrade
     */
    @Test
    public void findAll() throws Exception {
        try {
            Mockito.when(scheduleService.findAll()).thenReturn(ScheduleBuilder.buildScheduleDtoModelList());
            MvcResult mvcResult = getMvc()
                    .perform(MockMvcRequestBuilders.get("/v1/schedule")
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
