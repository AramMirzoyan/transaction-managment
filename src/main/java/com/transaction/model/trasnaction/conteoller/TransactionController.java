package com.transaction.model.trasnaction.conteoller;

import com.transaction.model.trasnaction.dto.request.TransactionRequestDto;
import com.transaction.model.trasnaction.dto.response.SuccessResponse;
import com.transaction.model.trasnaction.service.TransactionService;
import com.transaction.model.trasnaction.validator.FieldValidator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, path = "/api/transaction")
public class TransactionController {

    private final FieldValidator validator;
    private final TransactionService transactionService;

    public TransactionController(FieldValidator validator, TransactionService transactionService) {
        this.validator = validator;
        this.transactionService = transactionService;
    }


    @PostMapping(path = "/create/transaction")
    public ResponseEntity<SuccessResponse> transaction(@RequestBody @Valid final TransactionRequestDto dto, final BindingResult result) {
        validator.validateBodyFields(result);
        transactionService.createTransaction(dto);
        return ResponseEntity.ok(new SuccessResponse(true));
    }

}
