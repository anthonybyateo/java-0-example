package org.example.bank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public Account findById(String passportId, String accountId) {
        return getClient(passportId).getAccount(accountId);
    }

    public List<Account> sortAccounts(String passportId) {
        return getClient(passportId).getAccounts().stream()
                .sorted(Comparator.comparing(Account::getBalance)).toList();
    }

    public int getBalanceSum(String passportId) {
        return getClient(passportId).getAccounts().stream().mapToInt(Account::getBalance).sum();
    }

    public int getPositiveBalanceSum(String passportId) {
        return getClient(passportId).getAccounts().stream()
                .filter(account -> account.getBalance() > 0)
                .mapToInt(Account::getBalance).sum();
    }

    public int getNegativeBalanceSum(String passportId) {
        return getClient(passportId).getAccounts().stream()
                .filter(account -> account.getBalance() < 0)
                .mapToInt(Account::getBalance).sum();
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}
