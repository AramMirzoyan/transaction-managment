package com.transaction.model.trasnaction.exceptions.exceptionsType.impl;

import com.transaction.model.trasnaction.exceptions.exceptionsType.ErrorCode;
import org.springframework.http.HttpStatus;

public enum UserErrorCode implements ErrorCode {
    AUTH_INVALID_CREDENTIALS(HttpStatus.BAD_REQUEST, ""),
    USERNAME_INVALID_CREDENTIALS(HttpStatus.CONFLICT, "Email already exist"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    EDIT_USER_ROLE(HttpStatus.CONFLICT, "User cannot have same role"),
    USER_ROLE_TYPE(HttpStatus.CONFLICT, "You are user, Yo can not change user type, that can do only Admin"),
    USER_PROFILE_NOT_ACTIVE(HttpStatus.LOCKED, "user profile dont active"),
    USER_PROFILE_IS_ACTIVATED(HttpStatus.OK, "user is activated");





    private HttpStatus status;
    private String message;


    UserErrorCode(final HttpStatus status, final String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
