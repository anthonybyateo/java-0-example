package org.example.bank;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Bank {
    private String name;
    private ArrayList<Client> clients;

    public Bank(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    public void createClient(String passportId) {
        clients.add(new Client(passportId));
    }

    public Client getClient(String passportId) {
        for (Client client : clients) {
            if (client.getId().equals(passportId)) {
                return client;
            }
        }
        throw new NoSuchElementException();
    }

    public String createAccount(String passportId) {
        Account account = new Account();
        getClient(passportId).addAccount(account);
        return account.getId();
    }

    public void addBalance(String passportId, String accountId, int balance) throws IllegalAccessException {
        Account account = getClient(passportId).getAccount(accountId);
        if (!account.isBlocked()) {
            account.addBalance(balance);
        } else {
            throw new IllegalAccessException();
        }
    }

    public void blockAccount(String passportId, String accountId) {
        getClient(passportId).getAccount(accountId).setBlocked(true);
    }

    public void unblockAccount(String passportId, String accountId) {
        getClient(passportId).getAccount(accountId).setBlocked(false);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}
