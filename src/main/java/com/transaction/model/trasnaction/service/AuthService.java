package com.transaction.model.trasnaction.service;

import com.transaction.model.trasnaction.dto.request.UserLoginDto;
import com.transaction.model.trasnaction.dto.response.UserResponseDto;

public interface AuthService {

    UserResponseDto login(final UserLoginDto loginDto);

}
