package com.transaction.model.trasnaction.exceptions.impl;

import com.transaction.model.trasnaction.dto.response.ErrorResponse;
import com.transaction.model.trasnaction.exceptions.ServiceException;
import com.transaction.model.trasnaction.exceptions.exceptionsType.ErrorCode;

import java.util.List;

public class UserException extends ServiceException {

    public UserException() {
    }

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UserException(ErrorCode errorCode, List<ErrorResponse> errorResponses) {
        super(errorCode, errorResponses);

    }
}
