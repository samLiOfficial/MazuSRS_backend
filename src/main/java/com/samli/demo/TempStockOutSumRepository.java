// This interface extends MongoRepository to provide CRUD (Create, Read, Update, Delete) operations
// for documents of type TempStockOutSum in MongoDB.

package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TempStockOutSumRepository extends MongoRepository<TempStockOutSum, String> {
    // No custom repository methods are defined here.
    // The interface inherits basic CRUD operations from MongoRepository.
}
