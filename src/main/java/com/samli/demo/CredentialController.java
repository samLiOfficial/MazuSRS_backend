// Importing necessary libraries for the CredentialController class
package com.samli.demo;

// Importing Spring Boot annotations for RESTful web services
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Declaring the CredentialController class and annotating it as a REST controller
@RestController
@RequestMapping("/api")
public class CredentialController {

    // Autowiring the CredentialRepository dependency
    @Autowired
    private CredentialRepository credentialRepository; // Repository for managing Credential objects

    // POST mapping for the "/login" endpoint
    @PostMapping("/login")
    // Method to handle login requests
    public ResponseEntity<?> login(@RequestBody Credential credential) { // Request body containing user credentials
        // Finding a credential by username from the repository
        Credential foundCredential = credentialRepository.findByUsername(credential.getUsername()); // Search for a Credential object by username

        // Checking if a credential is found and if the password matches
        if (foundCredential != null && foundCredential.getPassword().equals(credential.getPassword())) {
            // Returning a success response if authentication is successful
            return ResponseEntity.ok().body("User authenticated"); // Return a success message
        } else {
            // Returning an unauthorized response if authentication fails
            return ResponseEntity.status(401).body("Invalid username or password"); // Return an error message
        }
    }
}
