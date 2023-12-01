// This interface defines a repository for StockOutRecordCounter objects, allowing CRUD (Create, Read, Update, Delete) operations.
// It extends the MongoRepository interface, which provides basic database operations for MongoDB.

package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockOutRecordCounterRepository extends MongoRepository<StockOutRecordCounter, String> {
    // This interface doesn't contain any custom methods or queries because it inherits basic repository functionality
    // from MongoRepository, which includes methods like save, findById, findAll, delete, etc.
}
