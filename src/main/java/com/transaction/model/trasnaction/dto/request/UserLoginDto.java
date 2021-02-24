package com.transaction.model.trasnaction.dto.request;
import javax.validation.constraints.NotBlank;

public class UserLoginDto {
    @NotBlank(message = "email must be not empty")
    private String username;
    @NotBlank(message = "password must be not empty")
    private String password;

    public UserLoginDto() {
    }

    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
