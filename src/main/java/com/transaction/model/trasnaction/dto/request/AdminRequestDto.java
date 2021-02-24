package com.transaction.model.trasnaction.dto.request;

import javax.validation.constraints.NotBlank;

public class AdminRequestDto {

    @NotBlank(message = "Please add admin uid")
    private String userId;

    public AdminRequestDto() {
    }

    public AdminRequestDto(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String userId) {
        this.userId = userId;
    }
}
