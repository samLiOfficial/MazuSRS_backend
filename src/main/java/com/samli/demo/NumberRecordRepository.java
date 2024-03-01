// This interface 'NumberRecordRepository' is a Spring Data MongoDB repository
// It is used to perform CRUD (Create, Read, Update, Delete) operations on 'NumberRecord' entities

// Importing necessary libraries for the NumberRecordRepository interface
package com.samli.demo;

// Importing Spring Data MongoDB repository interface
import org.springframework.data.mongodb.repository.MongoRepository;

// Declaring the NumberRecordRepository interface, extending MongoRepository for CRUD operations on NumberRecord objects
public interface NumberRecordRepository extends MongoRepository<NumberRecord, String> {
    // This repository interface extends 'MongoRepository' and is parameterized with 'NumberRecord' as the entity class
    // and 'String' as the type of the unique identifier (ID) of 'NumberRecord'
}
