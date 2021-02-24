package com.transaction.model.trasnaction.model.enums;

public enum UserType {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");


    private int value;
    private String name;

    UserType(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static UserType ofValue(final int value) {
        for (UserType item : UserType.values()) {
            if (item.getValue() == value) {
                return item;
            }
        }
        return null;
    }


    public static UserType ofName(final String name) {
        for (UserType item : UserType.values()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
