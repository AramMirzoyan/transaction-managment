package com.transaction.model.trasnaction.dto.response;

import com.transaction.model.trasnaction.dto.AbstractUserDto;
import com.transaction.model.trasnaction.model.enums.UserType;
import com.transaction.model.trasnaction.model.enums.converter.UserTypeConverter;

import javax.persistence.Convert;

public class UserResponseDto extends AbstractUserDto {

    private String id;

    @Convert(converter = UserTypeConverter.class)
    private UserType userType;

    public UserResponseDto() {

    }

    public UserResponseDto(String name, String surname, String id, UserType userType) {
        super(name, surname);
        this.id = id;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}

