package com.ads.voteapi.shared.validations;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Throwing exception for ResourceExceptionHandler
 * @author : andersons.andrade
 * @since : 17/11/21, quarta-feira
 **/
@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ResourceExceptionHandler.class);

    /**
     * Throwing exception for ResourceException
     * @param e
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<CustomError> entityNotFound(ResourceException e, HttpServletRequest request){
        LOG.error("ResourceException: {}", e.getMessage());
        CustomError customError = new CustomError();
        customError.setMsgDev(ExceptionUtils.getStackTrace(e));
        customError.setMsgUser(e.getMessage());
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND.value());
        customError.setPath(request.getServletPath());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

    /**
     * Throwing exception for IllegalArgumentException
     * @param e
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomError> illegalArgumentExceptionHandle(IllegalArgumentException e, HttpServletRequest request){
        LOG.error("IllegalArgumentException: {}", e.getMessage());
        CustomError customError = new CustomError();
        customError.setMsgDev(ExceptionUtils.getStackTrace(e));
        customError.setMsgUser(e.getMessage());
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND.value());
        customError.setPath(request.getServletPath());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

}
