package com.transaction.model.trasnaction.repository;

import com.transaction.model.trasnaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
