package com.transaction.model.trasnaction.model.enums.converter;

import com.transaction.model.trasnaction.model.enums.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserType value) {
        return value!=null ? value.getValue() : null;
    }

    @Override
    public UserType convertToEntityAttribute(Integer value) {
        return value!=null ?UserType.ofValue(value) : null;
    }
}
