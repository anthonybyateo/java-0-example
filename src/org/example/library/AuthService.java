package org.example.library;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class AuthService {
    private final Catalog catalog;

    public AuthService(Catalog catalog) {
        this.catalog = catalog;
    }

    public void signIn() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = in.nextLine();

        System.out.print("Enter your password: ");
        String password = in.nextLine();

        catalog.setCurrentUser(getUser(username, password));
        in.close();
    }

    public void signUp() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = in.nextLine();

        System.out.print("Enter your password: ");
        String password = in.nextLine();

        //todo: setCurrentUser, save to file, add to catalog users
        new User(username, password);

        catalog.setCurrentUser(getUser(username, password));
        in.close();
    }

    private User getUser(String username, String password) {
        for (User user: catalog.getUsers()) {
            if (user.getUsername().equals(username) && user.getPasswordHash().equals(hashPassword(password))) {
                return user;
            }
        }
        throw new RuntimeException("User with username isn't existing");
    }

    // https://www.baeldung.com/java-password-hashing
    // https://www.baeldung.com/sha-256-hashing-java
    private String hashPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final byte[] hashbytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashbytes);
    }

    // https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    public static String bytesToHex(byte[] bytes) {
        final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }

}
