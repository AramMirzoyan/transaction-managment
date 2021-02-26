package com.transaction.model.trasnaction.dto.request;

import com.transaction.model.trasnaction.dto.AbstractTransactionDto;
import com.transaction.model.trasnaction.model.Account;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.model.enums.TransactionStatus;
import com.transaction.model.trasnaction.model.enums.TransactionType;

import java.time.LocalDate;

public class TransactionRequestDto  extends AbstractTransactionDto {

    public TransactionRequestDto() {
    }

    public TransactionRequestDto( String type, String userId, String accountId, int balance) {
        super(type, userId, accountId, balance);
    }

}
