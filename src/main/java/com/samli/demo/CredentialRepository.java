// Importing necessary libraries for the CredentialRepository interface
package com.samli.demo;

// Importing Spring Data MongoDB repository interface
import org.springframework.data.mongodb.repository.MongoRepository;

// Declaring the CredentialRepository interface, extending MongoRepository for CRUD operations on Credential objects
public interface CredentialRepository extends MongoRepository<Credential, String> {
    // Method signature for finding a Credential by username
    Credential findByUsername(String username); // Find a Credential object by username
}
