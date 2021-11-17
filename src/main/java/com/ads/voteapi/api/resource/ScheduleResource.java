package com.ads.voteapi.api.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@RestController
@RequestMapping("/v1/schedule")
public class ScheduleResource {

    @GetMapping
    public String getAll(){
        return "Bem Vindo ao Deploy";
    }

}
