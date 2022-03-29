package org.example.bank;

//Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
//всем счетам, имеющим положительный и отрицательный балансы отдельно.
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Bank bank = new Bank("Bank");

        String passportId = "HB0000001";
        bank.createClient(passportId);

        String accountId1 = bank.createAccount(passportId);
        bank.addBalance(passportId, accountId1, 10);
        bank.addBalance(passportId, accountId1, 20);
        bank.blockAccount(passportId, accountId1);

        String accountId2 = bank.createAccount(passportId);
        bank.addBalance(passportId, accountId2, 5);

        System.out.println(bank);
    }

}
