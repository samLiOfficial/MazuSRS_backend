// This interface 'StockInRecordCounterRepository' serves as a repository for the 'StockInRecordCounter' entity.
// It extends the 'MongoRepository' interface, which provides basic CRUD (Create, Read, Update, Delete) operations
// for working with 'StockInRecordCounter' objects in MongoDB.

package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInRecordCounterRepository extends MongoRepository<StockInRecordCounter, String> {
}
