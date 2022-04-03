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
        if (account.isBlocked()) {
            throw new IllegalAccessException();
        }
        account.addBalance(balance);
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
        List<Account> accounts = getClient(passportId).getAccounts();
        accounts.sort(Comparator.comparing(Account::getBalance));
        return accounts;
    }

    public int getBalanceSum(String passportId) {
        int sum = 0;
        for (Account account : getClient(passportId).getAccounts()) {
            sum += account.getBalance();
        }
        return sum;
    }

    public int getPositiveBalanceSum(String passportId) {
        int sum = 0;
        for (Account account : getClient(passportId).getAccounts()) {
            if (account.getBalance() > 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public int getNegativeBalanceSum(String passportId) {
        int sum = 0;
        for (Account account : getClient(passportId).getAccounts()) {
            if (account.getBalance() < 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}
