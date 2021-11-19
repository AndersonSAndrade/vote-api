package com.ads.voteapi.jobs;

import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.domain.mapper.SessionMapper;
import com.ads.voteapi.services.interfaces.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Job responsible for closing expired session
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Async
@Component
@Slf4j
@EnableScheduling
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SessionJob implements Runnable{
    private static final Logger LOG = LoggerFactory.getLogger(SessionJob.class);
    private static final Integer RESCHEDULE_DELAY = 1;

    private ScheduledExecutorService scheduledExecutor;

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    @PostConstruct
    public void init(){
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        reschedule(RESCHEDULE_DELAY);
    }

    @Override
    public void run() {
        LOG.info("\n#JOB -> START IN {}", new Date());
           try {

               List<SessionDTO> listSessions = sessionService.closedSessions();
               if(!listSessions.isEmpty())  LOG.info("\n#JOB -> VERIFIED SESSIONS {}", listSessions.size());

           }catch (Exception ex){
               LOG.info("\n#JOB -> CLOSING SESSION FOR ENDED TIME - rescheduling in {}", ex.getMessage());
           }
        reschedule(RESCHEDULE_DELAY);
        LOG.info("\n#JOB -> END IN {}", new Date());
    }



    private void reschedule(Integer delay) {
        try {
            LOG.info("\n#JOB -> CLOSING SESSION FOR ENDED TIME - START IN {}", new Date());
            scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

            if(delay == null){
                delay = 1;
            }

            scheduledExecutor.schedule(this, delay, TimeUnit.MINUTES);
            scheduledExecutor.shutdown();
            LOG.info("\n#JOB -> CLOSING SESSION FOR ENDED TIME - rescheduling in {}", new Date());
        }catch (Exception ex){
            LOG.error("ERROR AT CLOSING SESSION FOR ENDED TIME -> rescheduling ", ex);
        }
    }
}
