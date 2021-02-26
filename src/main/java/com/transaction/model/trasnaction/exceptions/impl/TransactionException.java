package com.transaction.model.trasnaction.exceptions.impl;

import com.transaction.model.trasnaction.dto.response.ErrorResponse;
import com.transaction.model.trasnaction.exceptions.ServiceException;
import com.transaction.model.trasnaction.exceptions.exceptionsType.ErrorCode;

import java.util.List;

public class TransactionException extends ServiceException {

    public TransactionException() {
    }

    public TransactionException(ErrorCode errorCode) {
        super(errorCode);
    }

    public TransactionException(ErrorCode errorCode, List<ErrorResponse> errorResponses) {
        super(errorCode, errorResponses);
    }
}
