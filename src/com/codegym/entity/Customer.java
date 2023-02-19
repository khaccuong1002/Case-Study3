package com.codegym.entity;

public class Customer {
    private int id;
    private String name;
    private double wallet;

    public Customer() {
    }

    public Customer(int id, String name, double wallet) {
        this.id = id;
        this.name = name;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void addMoney(Double amount){
        this.wallet += amount;
    }

    public void makePayment(Double amount){
        this.wallet -= amount;
    }
}
