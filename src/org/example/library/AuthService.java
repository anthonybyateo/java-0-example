package org.example.library;

import java.util.Scanner;

public class AuthService {
    private final Catalog catalog;

    public AuthService(Catalog catalog) {
        this.catalog = catalog;
    }

    public void signIn() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your login: ");
        String login = in.nextLine();

        System.out.print("Enter your password: ");
        String password = in.nextLine();

        checkSignIn(login, password);
        System.out.println("password is: " + password);
        in.close();
    }

    private void checkSignIn(String login, String password) {
        for (User user: catalog.getUsers()) {
            if (user.getLogin().equals(login)) {
                return;
            }
        }
        throw new RuntimeException("User with login isn't existing");
    }

}
