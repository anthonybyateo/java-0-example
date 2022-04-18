package org.example.library;

public class App {

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        AuthService authService = new AuthService(catalog);

        try {
            authService.signIn();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

//        System.out.println(catalog);
    }

}
