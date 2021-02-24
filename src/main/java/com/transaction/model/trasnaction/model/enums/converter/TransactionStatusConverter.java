package com.transaction.model.trasnaction.model.enums.converter;

import com.transaction.model.trasnaction.model.enums.TransactionStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class TransactionStatusConverter implements AttributeConverter<TransactionStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TransactionStatus value) {
        return value != null ? value.getValue() : null;
    }

    @Override
    public TransactionStatus convertToEntityAttribute(Integer value) {
        return value != null ? TransactionStatus.ofValue(value) : null;
    }
}
