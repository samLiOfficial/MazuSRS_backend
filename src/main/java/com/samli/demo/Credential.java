// Importing necessary libraries for the Credential class
package com.samli.demo;

// Importing MongoDB specific annotations
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Declaring the Credential class and annotating it as a MongoDB document mapped to the "credentials" collection
@Document(collection = "credentials")
public class Credential {
    // Declaring instance variables
    // Annotating the id field as the document identifier
    @Id
    private String id; // Variable to store the document id
    private String username; // Variable to store the username
    private String password; // Variable to store the password

    // Constructors, Getters, and Setters

    // Default constructor for the Credential class
    public Credential() {}

    // Constructor for the Credential class that initializes username and password
    public Credential(String username, String password) {
        this.username = username; // Setting the value of username
        this.password = password; // Setting the value of password
    }

    // Getter method for retrieving the username
    public String getUsername() { return username; } // Return the value of username

    // Setter method for updating the username
    public void setUsername(String username) { this.username = username; } // Set the value of username

    // Getter method for retrieving the password
    public String getPassword() { return password; } // Return the value of password

    // Setter method for updating the password
    public void setPassword(String password) { this.password = password; } // Set the value of password
}
