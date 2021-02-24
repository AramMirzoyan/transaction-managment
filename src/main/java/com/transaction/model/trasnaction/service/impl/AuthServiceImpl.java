package com.transaction.model.trasnaction.service.impl;

import com.transaction.model.trasnaction.dto.request.UserLoginDto;
import com.transaction.model.trasnaction.dto.response.UserResponseDto;
import com.transaction.model.trasnaction.exceptions.exceptionsType.impl.UserErrorCode;
import com.transaction.model.trasnaction.exceptions.impl.UserException;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.repository.UserRepository;
import com.transaction.model.trasnaction.service.AuthService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService {


    private UserRepository repository;
    private MapperFacade mapper;
    private BCryptPasswordEncoder encoder;


    @Autowired
    public AuthServiceImpl(UserRepository repository, MapperFacade mapper, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public UserResponseDto login(UserLoginDto loginDto) {
        final User user = repository.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new UserException(UserErrorCode.USER_NOT_FOUND);
        }
        if (!encoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UserException(UserErrorCode.USER_NOT_FOUND);
        }
        if (!user.getUserStatus().getName().equalsIgnoreCase("active")) {
            throw new UserException(UserErrorCode.USER_PROFILE_NOT_ACTIVE);
        }
        return mapper.map(user, UserResponseDto.class);
    }
}
