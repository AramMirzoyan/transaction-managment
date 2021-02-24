package com.transaction.model.trasnaction.conteoller;

import com.transaction.model.trasnaction.dto.request.UserLoginDto;
import com.transaction.model.trasnaction.dto.request.UserRequestDto;
import com.transaction.model.trasnaction.dto.response.SuccessResponse;
import com.transaction.model.trasnaction.dto.response.UserResponseDto;
import com.transaction.model.trasnaction.service.AuthService;
import com.transaction.model.trasnaction.service.UserService;
import com.transaction.model.trasnaction.validator.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, path = "/api/user")
public class UserController {

    private final UserService service;
    private final FieldValidator validator;
    private final AuthService authService;

    @Autowired
    public UserController(UserService service, FieldValidator validator, AuthService authService) {
        this.service = service;
        this.validator = validator;
        this.authService = authService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<SuccessResponse> save(@RequestBody @Valid final UserRequestDto dto, final BindingResult result) {
        validator.validateBodyFields(result);
        service.save(dto);
        return ResponseEntity.ok(new SuccessResponse(true));
    }
    @PostMapping(path = "/login")
    public ResponseEntity<SuccessResponse<UserResponseDto>> login(@RequestBody @Valid final UserLoginDto dto,@RequestBody final BindingResult result) {
        validator.validateBodyFields(result);
        final UserResponseDto login = authService.login(dto);
        return ResponseEntity.ok(new SuccessResponse<>(true, login));
    }


}
