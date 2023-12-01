// This interface 'NumberRecordRepository' is a Spring Data MongoDB repository
// It is used to perform CRUD (Create, Read, Update, Delete) operations on 'NumberRecord' entities

package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NumberRecordRepository extends MongoRepository<NumberRecord, String> {
    // This repository interface extends 'MongoRepository' and is parameterized with 'NumberRecord' as the entity class
    // and 'String' as the type of the unique identifier (ID) of 'NumberRecord'
}
