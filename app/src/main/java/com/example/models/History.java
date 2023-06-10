package com.example.models;

public class History {
    private final int id;
    public final String moneyFrom;
    public final String moneyTo;

    public History(int id, String moneyFrom, String moneyTo) {
        this.id = id;
        this.moneyFrom = moneyFrom;
        this.moneyTo = moneyTo;
    }
}
