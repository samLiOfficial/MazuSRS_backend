// This interface 'StockInRecordCounterRepository' serves as a repository for the 'StockInRecordCounter' entity.
// It extends the 'MongoRepository' interface, which provides basic CRUD (Create, Read, Update, Delete) operations
// for working with 'StockInRecordCounter' objects in MongoDB.

// Importing necessary libraries for the StockInRecordCounterRepository interface
package com.samli.demo;

// Importing Spring Data MongoDB repository interface
import org.springframework.data.mongodb.repository.MongoRepository;
// Importing Spring stereotype annotation for declaring this interface as a repository
import org.springframework.stereotype.Repository;

// Declaring the StockInRecordCounterRepository interface and annotating it as a repository
@Repository
// Extending MongoRepository for CRUD operations on StockInRecordCounter objects
public interface StockInRecordCounterRepository extends MongoRepository<StockInRecordCounter, String> {
}
