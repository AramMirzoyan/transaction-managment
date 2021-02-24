package com.transaction.model.trasnaction.utils;

import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    private RoleConverter() {

    }


    public String roleConverter(final String userProfile) {
        String userProfileName = null;
        if (userProfile.equalsIgnoreCase("admin")) {
            userProfileName = "ADMIN";
        }
        if (userProfile.equalsIgnoreCase("user")) {
            userProfileName = "USER";
        }
        return userProfileName;
    }

}
