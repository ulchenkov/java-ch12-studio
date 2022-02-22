package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    @NotBlank(message = "User name is required")
    @Size(min = 3, max = 12, message = "User name mut be between 3 and 12 characters long")
    private String username;

    @Email(message = "Invalid e-mail address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Passwords must be at least 6 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    private Date creationDate;

    private static int nextId = 1;
    private final int id;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        this.id = nextId;
        this.creationDate = new Date();
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public int getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null || verifyPassword != null && verifyPassword == null || !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
