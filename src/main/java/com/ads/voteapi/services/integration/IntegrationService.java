package com.ads.voteapi.services.integration;

import com.ads.voteapi.common.param.ValidCpfParam;
import com.ads.voteapi.shared.validations.VoteException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Objects;

/**
 * Service responsible for validating the CPF via user-info api
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Slf4j
@Service
public class IntegrationService {
    private static final Logger LOG = LoggerFactory.getLogger(IntegrationService.class);
    private static final String CPF_INVALID_NOT_EXSISTS = "Invalid CPF or does not exist.";
    /**
     * Valuing CPF Via external api https://user-info.herokuapp.com/users/
     * @param cpf
     * @return String
     * @author Anderson S. Andrade
     */
    public String validCpfType(String cpf){
        RestTemplate restTemplate = new RestTemplate();
        String result = "";
        try {
            if (!Objects.requireNonNull(cpf).isEmpty()) {
                String url = "https://user-info.herokuapp.com/users/".concat(cpf);
                ValidCpfParam type = restTemplate.getForObject(url, ValidCpfParam.class);
                assert type != null;
                result = type.getStatus();
            }
        }catch (Exception ex){
            LOG.error("ERROR PERFORMING THE API REQUEST - {}", new Date());
            throw new VoteException(CPF_INVALID_NOT_EXSISTS);
        }
        return result;
    }

}
