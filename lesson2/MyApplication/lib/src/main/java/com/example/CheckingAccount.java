package com.example;

/**
 * Created by smyers on 9/12/2016.
 */
public class CheckingAccount extends Account {

    public CheckingAccount(long amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "Checking Account Balance: $" + getAmount();
    }

    public void withdraw(long amount) {
        setAmount(getAmount() - amount);
    }
}
