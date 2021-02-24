package com.transaction.model.trasnaction.exceptions.exceptionsType;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String getMessage();

    HttpStatus getStatus();

}
