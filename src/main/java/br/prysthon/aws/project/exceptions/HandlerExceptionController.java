package br.prysthon.aws.project.exceptions;

import br.prysthon.aws.project.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Collections;

@ControllerAdvice
public class HandlerExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(HandlerExceptionController.class);

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Response<String>> notFoundException(NotFoundException e) {
        this.log(e);
        Response<String> response = new Response<>();
        response.setStatus(e.getStatus());
        response.setErros(Collections.singletonList(e.getMessage()));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler({ ApiExceptions.class })
    public ResponseEntity<Response<String>> apiException(ApiExceptions e) {
        this.log(e);
        Response<String> response = new Response<>();
        response.setStatus(e.getStatus());
        response.setErros(Collections.singletonList(e.getMessage()));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Response<String>> someOtherException(Exception e) {
        this.log(e);
        Response<String> response = new Response<>();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setErros(Arrays.asList(e.getMessage()));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    private void log(Exception e) {
        logger.info("Exception: " + e.getClass().getName() + " : " + e.getMessage());
        logger.debug(e.getLocalizedMessage());
    }
}
