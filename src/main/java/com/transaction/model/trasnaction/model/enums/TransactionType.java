package com.transaction.model.trasnaction.model.enums;

public enum TransactionType {

    DEPOSIT(1, "DEPOSIT"),
    WITHDRAWAL(2, "WITHDRAWAL");


    private final int value;
    private final String name;


    TransactionType(int value, String name) {
        this.value = value;
        this.name = name;
    }


    public static TransactionType ofValue(final int value) {
        for (TransactionType item : TransactionType.values()) {
            if (item.getValue() == value) {
                return item;
            }
        }

        return null;
    }

    public static TransactionType ofName(final String name) {
        for (TransactionType item : TransactionType.values()) {
            if (item.getName().equalsIgnoreCase(name)) {
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
