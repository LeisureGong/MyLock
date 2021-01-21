package com.leisure.ibm;

public class Account extends Thread {

    String holderName;
    float amount;
    public Account(String name, float amt) {
        holderName = name;
        amount = amt;
    }

    public void deposit(float amt) {
        amount += amt;
    }

    public void withdraw(float amt) {
        amount -= amt;
    }
}
