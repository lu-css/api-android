package com.example.models;

public class History {
    private final int id;
    public String moneyFrom;
    public String moneyTo;

    public History() {
        this.id = 0;
        this.moneyFrom = "";
        this.moneyTo = "";
    }

    public History(int id, String moneyFrom, String moneyTo) {
        this.id = id;
        this.moneyFrom = moneyFrom;
        this.moneyTo = moneyTo;
    }
}
