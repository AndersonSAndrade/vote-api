package com.ads.voteapi.api.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : andersons.andrade
 * @since : 16/11/21, terça-feira
 **/
@Getter
public class ResourceCreatingEvent extends ApplicationEvent{

    private HttpServletResponse response;
    private Long id;

    public ResourceCreatingEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
