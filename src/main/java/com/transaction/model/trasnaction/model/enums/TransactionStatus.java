package com.transaction.model.trasnaction.model.enums;

public enum TransactionStatus {

    PENDING(1, "PENDING"),
    COMPLETED(2, "COMPLETED");


    private final int value;
    private final String name;


    TransactionStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static TransactionStatus ofValue(final int value) {
        for (TransactionStatus item : TransactionStatus.values()) {
            if (item.getValue() == value) {
                return item;
            }
        }

        return null;
    }

    public static TransactionStatus ofName(final String name) {
        for (TransactionStatus item : TransactionStatus.values()) {
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
