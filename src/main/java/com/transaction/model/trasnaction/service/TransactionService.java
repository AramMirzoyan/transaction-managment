package com.transaction.model.trasnaction.service;

import com.transaction.model.trasnaction.dto.request.TransactionRequestDto;
import com.transaction.model.trasnaction.dto.response.TransactionResponseDto;
import com.transaction.model.trasnaction.model.Transaction;

import java.util.List;

public interface TransactionService {


    List<TransactionResponseDto> getAll();
    void canceledTransaction(final TransactionRequestDto cancel);
    void createTransaction(final TransactionRequestDto transaction);



}
