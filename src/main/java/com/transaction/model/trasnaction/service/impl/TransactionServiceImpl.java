package com.transaction.model.trasnaction.service.impl;

import com.transaction.model.trasnaction.dto.request.TransactionRequestDto;
import com.transaction.model.trasnaction.dto.response.TransactionResponseDto;
import com.transaction.model.trasnaction.exceptions.exceptionsType.impl.TransactionErrorCode;
import com.transaction.model.trasnaction.exceptions.exceptionsType.impl.UserErrorCode;
import com.transaction.model.trasnaction.exceptions.impl.TransactionException;
import com.transaction.model.trasnaction.exceptions.impl.UserException;
import com.transaction.model.trasnaction.model.Account;
import com.transaction.model.trasnaction.model.Transaction;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.model.enums.TransactionStatus;
import com.transaction.model.trasnaction.model.enums.TransactionType;
import com.transaction.model.trasnaction.repository.AccountRepository;
import com.transaction.model.trasnaction.repository.TransactionRepository;
import com.transaction.model.trasnaction.repository.UserRepository;
import com.transaction.model.trasnaction.service.TransactionService;
import com.transaction.model.trasnaction.utils.StatusConverter;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final MapperFacade mapper;
    private final TransactionRepository repository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(MapperFacade mapper, TransactionRepository repository, UserRepository userRepository, AccountRepository accountRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TransactionResponseDto> getAll() {
        List<Transaction> transactions = repository.findAll();
        return mapper.mapAsList(transactions, TransactionResponseDto.class);
    }

    @Override
    public void canceledTransaction(final TransactionRequestDto cancel) {

    }

    @Override
    public void createTransaction(final TransactionRequestDto transaction) {
        if (transaction.getBalance() < 0) {
            throw new TransactionException(TransactionErrorCode.NOT_RIGHT_BALANCE);
        }
        final User user = userRepository.findById(transaction.getUserId()).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        Optional<Account> account = user.getAccounts().
                stream().
                filter(accounts -> accounts.getId().equals(transaction.getAccountId()))
                .findAny();
        if (account.isPresent()) {
            final Transaction trans = new Transaction();
            trans.setAccount(account.get());
            trans.setUser(user);
            trans.setStatus(TransactionStatus.PENDING);
            trans.setCreatDate(LocalDate.now());
            if (StatusConverter.statusConverter(transaction.getType()).equals(TransactionType.DEPOSIT.getName())) {
                trans.setBalance(transaction.getBalance());
                account.get().setBalance(account.get().getBalance() + transaction.getBalance());
                trans.setType(TransactionType.DEPOSIT);
            } else {
                if (account.get().getBalance() < transaction.getBalance()) {
                    throw new TransactionException(TransactionErrorCode.NOT_ENOUGH_MONEY);
                }
                trans.setBalance(transaction.getBalance());
                account.get().setBalance(account.get().getBalance() - transaction.getBalance());
                trans.setType(TransactionType.WITHDRAWAL);
            }
            repository.save(trans);
        }
    }
}
