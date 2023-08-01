package com.fernando.finance.model;

public enum StatusType {
    PENDING(0, "pending"),
    COMPLETED(1, "completed");

    private int id;
    private String name;
    StatusType(int id, String name){
        this.id = id;
        this.name = name;
    }
}
