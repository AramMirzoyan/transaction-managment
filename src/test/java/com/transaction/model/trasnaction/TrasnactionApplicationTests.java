package com.transaction.model.trasnaction;

import com.transaction.model.trasnaction.dto.request.UserRequestDto;
import com.transaction.model.trasnaction.model.User;
import com.transaction.model.trasnaction.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.MethodOrderer.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(PowerMockRunner.class)
class TrasnactionApplicationTests {

    @Mock
    private UserRequestDto user;
    @Autowired
    private UserService service;
    @Mock
    private User users;

    @BeforeEach
     void setUp() {
        user= new UserRequestDto("Test","Test","Test","Test");
    }

    @Test
    void save() {
        when(service.save(user)).thenReturn(users);
        Assertions.assertThatObject(service.save(user));
    }



}
