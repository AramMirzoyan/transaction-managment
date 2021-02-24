package com.transaction.model.trasnaction.dto.response;

import com.transaction.model.trasnaction.model.Account;
import com.transaction.model.trasnaction.model.enums.AccountStatus;

public class AccountResponseDto {

    private UserResponseDto dto;
    private String id;
    private String accountNumber;
    private AccountStatus accountStatus;

    public AccountResponseDto() {
    }

    public AccountResponseDto(UserResponseDto dto, String id, String accountNumber, AccountStatus accountStatus) {
        this.dto = dto;
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public UserResponseDto getDto() {
        return dto;
    }

    public void setDto(UserResponseDto dto) {
        this.dto = dto;
    }


}
