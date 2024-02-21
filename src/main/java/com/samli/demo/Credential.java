package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credentials")
public class Credential {
    @Id
    private String id;
    private String username;
    private String password;

    // Constructors, Getters, and Setters
    public Credential() {}

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // ID omitted for brevity
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}