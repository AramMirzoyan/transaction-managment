package com.transaction.model.trasnaction.exceptions.exceptionsType.impl;

import com.transaction.model.trasnaction.exceptions.exceptionsType.ErrorCode;
import org.springframework.http.HttpStatus;

public enum TransactionErrorCode implements ErrorCode {
    NOT_ENOUGH_MONEY(HttpStatus.BAD_REQUEST,"the amount is not enough"),
    NOT_RIGHT_BALANCE(HttpStatus.PERMANENT_REDIRECT,"Balance can not be 0 and negative");


    private HttpStatus status;
    private String message;

    TransactionErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
