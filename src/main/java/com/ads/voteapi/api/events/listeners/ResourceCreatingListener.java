package com.ads.voteapi.api.events.listeners;

import com.ads.voteapi.api.events.ResourceCreatingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@Component
public class ResourceCreatingListener implements ApplicationListener<ResourceCreatingEvent> {
    @Override
    public void onApplicationEvent(ResourceCreatingEvent event) {
        HttpServletResponse response = event.getResponse();
        Integer id = Integer.parseInt(event.getId().toString());
        getAddHeaderLocation(response, id);
    }

    private void getAddHeaderLocation(HttpServletResponse response, Integer id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
