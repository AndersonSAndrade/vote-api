package com.ads.voteapi.api.events;

import com.ads.voteapi.common.event.ActionEvent;
import com.ads.voteapi.common.param.MessageResourceEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@Slf4j
@Component
public class MessageEventListener {
    private static final Logger LOG = LoggerFactory.getLogger(MessageEventListener.class);

    @EventListener(condition = "#event.typeEvent eq T(com.ads.voteapi.common.type.EventsType).SENDING_MESSAGE_DELETE.getId()")
    public ResponseEntity<MessageResourceEvent> handleSendMailForCreatadUser(ActionEvent<Object> event){
        LOG.info("RESOURCE SUCCESSFULLY DELETED");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResourceEvent("Resource Successfully Deleted"));
    }


}
