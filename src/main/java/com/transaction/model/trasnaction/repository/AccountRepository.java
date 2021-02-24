package com.transaction.model.trasnaction.repository;

import com.transaction.model.trasnaction.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
