package org.example.bank;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Client {
    private String id;
    private ArrayList<Account> accounts;

    public Client(String id) {
        this.id = id;
        this.accounts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Account getAccount(String id) {
        for (Account account: accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        throw new NoSuchElementException();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
