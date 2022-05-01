package org.example.bank;

import java.util.UUID;

public class Account {
    private String id;
    private int balance;
    private boolean isBlocked;

    public Account() {
        this.id = UUID.randomUUID().toString();
        this.balance = 0;
        this.isBlocked = false;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance) {
        this.balance += balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
