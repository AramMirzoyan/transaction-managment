package com.transaction.model.trasnaction.interceptor;

import com.transaction.model.trasnaction.dto.response.ErrorResponse;
import com.transaction.model.trasnaction.exceptions.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepionAdvice {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleFields(ServiceException e) {
        if (e.getErrorResponses() != null) {
            return new ResponseEntity<>(e.getErrorResponses(), e.getStatus());
        } else {
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage());
            response.setFields(e.getStatus().name());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }
}
