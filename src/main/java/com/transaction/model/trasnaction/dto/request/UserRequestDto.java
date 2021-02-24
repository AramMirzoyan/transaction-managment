package com.transaction.model.trasnaction.dto.request;

import com.transaction.model.trasnaction.dto.AbstractUserDto;

import javax.validation.constraints.NotBlank;

public class UserRequestDto extends AbstractUserDto {

    @NotBlank(message = "username must no be empty")
    private String username;

    @NotBlank(message = "password must no be empty")
    private String password;

    public UserRequestDto() {

    }


    public UserRequestDto(String name, String surname, String username, String password) {
        super(name, surname);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
