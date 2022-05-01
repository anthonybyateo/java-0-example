package org.example.library;

public class MenuBuilder {

    public static void printStart() {
        System.out.print("""
                0 - Exit
                1 - Sign in
                2 - Sign up
                """);
        System.out.print("Choose action: ");
    }

}
