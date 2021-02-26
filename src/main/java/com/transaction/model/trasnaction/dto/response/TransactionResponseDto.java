package com.transaction.model.trasnaction.dto.response;

import com.transaction.model.trasnaction.dto.AbstractTransactionDto;
import com.transaction.model.trasnaction.model.Account;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.model.enums.TransactionStatus;
import com.transaction.model.trasnaction.model.enums.TransactionType;

import java.time.LocalDate;

public class TransactionResponseDto extends AbstractTransactionDto {

    private String uid;

    public TransactionResponseDto(String uid) {
        this.uid = uid;
    }

    public TransactionResponseDto( String type, String userId, String accountId, int balance, String uid) {
        super(type, userId, accountId, balance);
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
