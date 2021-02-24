package com.transaction.model.trasnaction.model.enums;

public enum AccountStatus {
    ACTIVE(1, "ACTIVE"), LOCK(2, "LOCK");


    private final int value;
    public String name;

    AccountStatus(final int value, final String name) {
        this.name = name;
        this.value = value;
    }

    public static AccountStatus ofName(final String name) {
        for (AccountStatus item : AccountStatus.values()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }


    public static AccountStatus ofValue(final int value) {
        for (AccountStatus item : AccountStatus.values()) {
            if (item.getValue() == value) {
                return item;
            }
        }
        return null;
    }


    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
