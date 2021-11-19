package com.ads.voteapi.services.integration;

import com.ads.voteapi.common.param.ValidCpfParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Service
public class IntegrationService {

    /**
     * Valuing CPF Via external api https://user-info.herokuapp.com/users/
     * @param cpf
     * @return
     * @author Anderson S. Andrade
     */
    public String validCpfType(String cpf){
        RestTemplate restTemplate = new RestTemplate();
        String result = "";
        if (!Objects.requireNonNull(cpf).isEmpty()) {
            String url = "https://user-info.herokuapp.com/users/".concat(cpf);
            ValidCpfParam type = restTemplate.getForObject(url, ValidCpfParam.class);
            assert type != null;
            result = type.getStatus();
        }
        return result;
    }

}
