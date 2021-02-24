package com.transaction.model.trasnaction.model.enums.converter;

import com.transaction.model.trasnaction.model.enums.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;


@Convert
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserStatus value) {
        return value != null ? value.getValue() : null;
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer value) {
        return value != null ? UserStatus.ofValue(value) : null;
    }
}
