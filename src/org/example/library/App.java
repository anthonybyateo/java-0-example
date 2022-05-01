package org.example.library;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        Catalog catalog = new Catalog();
        AuthService authService = new AuthService(catalog);
        MenuBuilder.printStart();
        Scanner in = new Scanner(System.in);
        int menuChoice = Integer.parseInt(in.nextLine());
        switch (menuChoice) {
            case 0: return;
            case 1: authService.signIn();
            case 2: authService.signUp();
        }

//        try {
//            authService.signIn();
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());
//        }

//        System.out.println(catalog);
    }

}
