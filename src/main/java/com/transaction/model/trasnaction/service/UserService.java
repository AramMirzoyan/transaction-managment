package com.transaction.model.trasnaction.service;

import com.transaction.model.trasnaction.dto.request.UserRequestDto;
import com.transaction.model.trasnaction.dto.response.UserResponseDto;
import com.transaction.model.trasnaction.model.User;

import java.util.List;


public interface UserService {

    User save(final UserRequestDto userDto);


}
