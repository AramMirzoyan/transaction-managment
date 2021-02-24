package com.transaction.model.trasnaction.service.impl;

import com.transaction.model.trasnaction.dto.request.AdminRequestDto;
import com.transaction.model.trasnaction.dto.response.AccountResponseDto;
import com.transaction.model.trasnaction.dto.response.UserResponseDto;
import com.transaction.model.trasnaction.exceptions.exceptionsType.impl.UserErrorCode;
import com.transaction.model.trasnaction.exceptions.impl.UserException;
import com.transaction.model.trasnaction.model.Account;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.model.enums.AccountStatus;
import com.transaction.model.trasnaction.model.enums.UserStatus;
import com.transaction.model.trasnaction.model.enums.UserType;
import com.transaction.model.trasnaction.repository.AccountRepository;
import com.transaction.model.trasnaction.repository.UserRepository;
import com.transaction.model.trasnaction.service.AdminService;
import com.transaction.model.trasnaction.utils.AccountGenerator;
import com.transaction.model.trasnaction.utils.RoleConverter;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RoleConverter converter;
    private final AccountRepository accountRepository;
    private final MapperFacade mapper;


    @Autowired
    public AdminServiceImpl(UserRepository userRepository, RoleConverter converter, AccountRepository accountRepository, MapperFacade mapper) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void roleUpdate(String id, String role, final AdminRequestDto login) {
        isAdmin(login);
        final User user = userRepository.findById(id).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        if (UserStatus.INACTIVE.equals(user.getUserStatus())) {
            throw new UserException(UserErrorCode.USER_PROFILE_IS_ACTIVATED);
        }
        final UserType userType = UserType.ofName(converter.roleConverter(role));
        if (user.getUserType().equals(userType)) {
            throw new UserException(UserErrorCode.EDIT_USER_ROLE);
        }
        user.setUserType(UserType.ofName(converter.roleConverter(role)));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void activateUser(String id, final AdminRequestDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        if (!UserStatus.INACTIVE.equals(user.getUserStatus())) {
            throw new UserException(UserErrorCode.USER_PROFILE_IS_ACTIVATED);
        }
        user.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public AccountResponseDto createAccount(final String userId, final AdminRequestDto dto) {
        final User user = userRepository.findById(userId).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        isAdmin(dto);
        final Account account = new Account();
        account.setAccountNumber(AccountGenerator.generateRandomAccount(16));
        account.setUser(user);
        account.setAccountStatus(AccountStatus.LOCK);
        account.setBalance(0);
        Account responseAccount = accountRepository.save(account);
        final UserResponseDto dto1 = mapper.map(user, UserResponseDto.class);
        final AccountResponseDto accountResponseDto =
                new AccountResponseDto(dto1, responseAccount.getId(), responseAccount.getAccountNumber(), responseAccount.getAccountStatus());
        return accountResponseDto;
    }

    @Override
    @Transactional
    public void activateAccount(final String userId, final String accountId, AdminRequestDto dto) {
        isAdmin(dto);
        final User user = userRepository.findById(userId).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        Optional<Account> account = user.getAccounts().
                stream().
                filter(accounts -> accounts.getId().equals(accountId))
                .findAny();
        if (account.isPresent()) {
            Account ac = account.get();
            ac.setAccountStatus(AccountStatus.ACTIVE);
            accountRepository.save(ac);
        }
    }


    private void isAdmin(final AdminRequestDto dto) {
        final User admin = userRepository.findById(dto.getUserId()).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        if (admin.getUserType().equals(UserType.USER)) {
            throw new UserException(UserErrorCode.USER_ROLE_TYPE);
        }
    }
}
