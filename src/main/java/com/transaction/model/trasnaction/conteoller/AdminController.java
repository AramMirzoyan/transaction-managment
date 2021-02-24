package com.transaction.model.trasnaction.conteoller;

import com.transaction.model.trasnaction.dto.request.AdminRequestDto;
import com.transaction.model.trasnaction.dto.response.AccountResponseDto;
import com.transaction.model.trasnaction.dto.response.SuccessResponse;
import com.transaction.model.trasnaction.service.AdminService;
import com.transaction.model.trasnaction.validator.FieldValidator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final FieldValidator validator;

    public AdminController(AdminService adminService, FieldValidator validator) {
        this.adminService = adminService;
        this.validator = validator;
    }

    @PutMapping(path = "/activate/user/{id}")
    public ResponseEntity<SuccessResponse> activateUser(@PathVariable(name = "id") final String id, @RequestBody @Valid final AdminRequestDto dto, final BindingResult result) {
        validator.validateBodyFields(result);
        adminService.activateUser(id, dto);
        return ResponseEntity.ok(new SuccessResponse(true, "User was activate"));
    }

    @PutMapping(value = "/update/role/{id}/{role}")
    @ResponseBody
    public ResponseEntity<SuccessResponse> updateUserRole(@RequestBody @Valid final AdminRequestDto dto, final BindingResult result, @PathVariable(name = "id") String id, @PathVariable(name = "role") String role) {
        validator.validateBodyFields(result);
        adminService.roleUpdate(id, role, dto);
        return ResponseEntity.ok(new SuccessResponse(true));
    }

    @PostMapping(value = "/create/account/{id}")
    public ResponseEntity<SuccessResponse<AccountResponseDto>> createAccount(@PathVariable(name = "id") String id, @RequestBody @Valid final AdminRequestDto dto) {
        AccountResponseDto account = adminService.createAccount(id, dto);
        return ResponseEntity.ok(new SuccessResponse<>(true, account));
    }

    @PostMapping(value = "activate/account/{userId}/{accountId}")
    public ResponseEntity<SuccessResponse> activateAccount(@PathVariable(name = "userId") final String userId,
                                                           @PathVariable(name = "accountId") final String accountId,
                                                           @RequestBody @Valid final AdminRequestDto dto,
                                                           final BindingResult result) {
        validator.validateBodyFields(result);
        adminService.activateAccount(userId, accountId, dto);
        return ResponseEntity.ok(new SuccessResponse(true));
    }

}
