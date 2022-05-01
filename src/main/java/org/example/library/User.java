package org.example.library;

import java.util.UUID;

public class User {
    private String id;
    private String email;
    private String passwordHash;
    private boolean isAdmin;

    public User(String email, String passwordHash) {
        this(UUID.randomUUID().toString(), email, passwordHash, false);
    }

    public User(String id, String email, String passwordHash, boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", login='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

}
