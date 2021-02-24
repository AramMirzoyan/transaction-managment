package com.transaction.model.trasnaction.validator;

import com.transaction.model.trasnaction.dto.response.ErrorResponse;
import com.transaction.model.trasnaction.exceptions.exceptionsType.impl.UserErrorCode;
import com.transaction.model.trasnaction.exceptions.impl.UserException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class FieldValidator {

    private FieldValidator() {

    }

    public void validateBodyFields(final BindingResult result) {
        if (result.hasErrors()) {
            final List<ErrorResponse> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(new ErrorResponse(((FieldError) error).getField(), error.getDefaultMessage())));
            throw new UserException(UserErrorCode.AUTH_INVALID_CREDENTIALS);
        }
    }

}
