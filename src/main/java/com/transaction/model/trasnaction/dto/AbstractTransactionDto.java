package com.transaction.model.trasnaction.dto;

import com.transaction.model.trasnaction.model.Account;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.model.enums.TransactionStatus;
import com.transaction.model.trasnaction.model.enums.TransactionType;
import com.transaction.model.trasnaction.model.enums.converter.LocalDatePersistenceConverter;
import com.transaction.model.trasnaction.model.enums.converter.TransactionStatusConverter;
import com.transaction.model.trasnaction.model.enums.converter.TransactionTypeConverter;

import javax.persistence.Convert;
import java.time.LocalDate;

public abstract class AbstractTransactionDto {
;

    private String type;
    private String userId;
    private String accountId;
    private int balance;

    public AbstractTransactionDto() {
    }

    public AbstractTransactionDto(String type, String userId, String accountId, int balance) {

        this.type = type;
        this.userId = userId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
