package com.ads.voteapi.shared.validations;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Throwing exception for ResourceExceptionHandler
 * @author : andersons.andrade
 * @since : 17/11/21, quarta-feira
 **/
@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ResourceExceptionHandler.class);

    private static final String VIOLATION_REQUIRED_FIELD = "Violation of Required Fields.";

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
        customError.setDetails(ExceptionUtils.getStackTrace(e));
        customError.setMessage(e.getMessage());
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

    /**
     * Throwing exception for ResourceException
     * @param e
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    @ExceptionHandler(SessionException.class)
    public ResponseEntity<CustomError> entityNotFound(SessionException e, HttpServletRequest request){
        LOG.error("SessionException: {}", e.getMessage());
        CustomError customError = new CustomError();
        customError.setDetails(ExceptionUtils.getStackTrace(e));
        customError.setMessage(e.getMessage());
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }


    /**
     * Throwing exception for ResourceException
     * @param e
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    @ExceptionHandler(VoteException.class)
    public ResponseEntity<CustomError> entityNotFound(VoteException e, HttpServletRequest request){
        LOG.error("VoteException: {}", e.getMessage());
        CustomError customError = new CustomError();
        customError.setDetails(ExceptionUtils.getStackTrace(e));
        customError.setMessage(e.getMessage());
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

    /**
     * Throwing exception for ResourceException
     * @param e
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<CustomError> entityNotFound(VoteException e, HttpClientErrorException request){
        LOG.error("HttpClientErrorException: {}", e.getMessage());
        CustomError customError = new CustomError();
        customError.setDetails(ExceptionUtils.getStackTrace(e));
        customError.setMessage("The CPF is invalid.");
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND);
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
        CustomError customError = new CustomError();
        customError.setDetails(ExceptionUtils.getStackTrace(e));
        customError.setMessage(e.getMessage());
        customError.setTimestamp(Instant.now());
        customError.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

    /**
     * Throwing exception for ConstraintViolationException
     * @param ex
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomError> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request){
        CustomError validError = getCustomError(ex, request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validError);
    }

    /**
     * Converting exception to errors - ConstraintViolationException
     * @param ex
     * @param request
     * @return CustomError
     * @author Anderson S. Andrade
     */
    private CustomError getCustomError(ConstraintViolationException ex, HttpServletRequest request) {
        List<Errors> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(error -> errors.add(new Errors("Field Error", error.getPropertyPath().toString(), error.getMessage())));
        CustomError validError = new CustomError();
        validError.setErrors(errors);
        validError.setMessage(VIOLATION_REQUIRED_FIELD);
        validError.setTimestamp(Instant.now());
        validError.setStatus(HttpStatus.BAD_REQUEST);
        validError.setDetails(ex.getMessage());
        validError.setPath(request.getServletPath());
        return validError;
    }

}
