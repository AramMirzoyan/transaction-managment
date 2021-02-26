package com.transaction.model.trasnaction.utils;

import org.springframework.stereotype.Component;

@Component
public class StatusConverter {


    private StatusConverter() {

    }


    public static String statusConverter(final String status) {
        String statusName = null;
        if (status.equalsIgnoreCase("deposit")) {
            statusName = "DEPOSIT";
        }
        if (status.equalsIgnoreCase("withdrawal")) {
            statusName = "WITHDRAWAL";
        }
        return statusName;
    }

}
