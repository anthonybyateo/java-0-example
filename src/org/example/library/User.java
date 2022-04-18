package org.example.library;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String passwordHash;
    private boolean isAdmin;

    public User(String id, String login, String password, boolean isAdmin) {
        this.id = id;
        this.username = login;
        this.passwordHash = password;
        this.isAdmin = isAdmin;
    }

    public User(String login, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = login;
        this.passwordHash = password;
        this.isAdmin = false;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

}
