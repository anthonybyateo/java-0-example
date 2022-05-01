package org.example.library;

public class MenuBuilder {

    public static void printStart() {
        System.out.print("""
                0 - Exit
                1 - Log in
                2 - Log out
                """);
        System.out.print("Choose action: ");
    }

}
