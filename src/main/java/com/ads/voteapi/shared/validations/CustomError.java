package com.ads.voteapi.shared.validations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 17/11/21, quarta-feira
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

    private Instant timestamp;
    private HttpStatus status;
    private String message;
    private String details;
    private List<Errors> errors;
    private String path;

    public CustomError(HttpStatus status, String message, String details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public CustomError(HttpStatus status, String message, List<Errors> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

}
