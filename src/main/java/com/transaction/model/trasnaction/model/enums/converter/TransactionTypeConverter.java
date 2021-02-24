package com.transaction.model.trasnaction.model.enums.converter;

import com.transaction.model.trasnaction.model.enums.TransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class TransactionTypeConverter implements AttributeConverter<TransactionType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TransactionType value) {
        return value != null ? value.getValue() : null;
    }

    @Override
    public TransactionType convertToEntityAttribute(Integer value) {
        return value != null ? TransactionType.ofValue(value) : null;
    }
}
