package com.transaction.model.trasnaction.model.enums.converter;

import com.transaction.model.trasnaction.model.enums.AccountStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class AccountStatusConverter implements AttributeConverter<AccountStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AccountStatus value) {
        return value != null ? value.getValue() : null;
    }

    @Override
    public AccountStatus convertToEntityAttribute(Integer value) {
        return value != null ? AccountStatus.ofValue(value) : null;
    }
}
