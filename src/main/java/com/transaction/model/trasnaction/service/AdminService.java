package com.transaction.model.trasnaction.service;

import com.transaction.model.trasnaction.dto.request.AdminRequestDto;
import com.transaction.model.trasnaction.dto.response.AccountResponseDto;

public interface AdminService {

    void roleUpdate(String id, String role, final AdminRequestDto login);

    void activateUser(final String id, final AdminRequestDto dto);

    AccountResponseDto createAccount(final String userId, final AdminRequestDto dto);

    void activateAccount(final String userId, final String accountId, final AdminRequestDto dto);


}
