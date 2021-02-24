package com.transaction.model.trasnaction.service.impl;

import com.transaction.model.trasnaction.dto.request.UserRequestDto;
import com.transaction.model.trasnaction.exceptions.exceptionsType.impl.UserErrorCode;
import com.transaction.model.trasnaction.exceptions.impl.UserException;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.model.enums.UserStatus;
import com.transaction.model.trasnaction.model.enums.UserType;
import com.transaction.model.trasnaction.repository.UserRepository;
import com.transaction.model.trasnaction.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperFacade mapper;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MapperFacade mapper, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public User save(final UserRequestDto userDto) {
        if (userRepository.existsUserByUsername(userDto.getUsername())) {
            throw new UserException(UserErrorCode.USERNAME_INVALID_CREDENTIALS);
        }
        final User user = mapper.map(userDto, User.class);
        user.setUserType(UserType.USER);
        user.setUserStatus(UserStatus.INACTIVE);
        user.setPassword(encoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }


}
