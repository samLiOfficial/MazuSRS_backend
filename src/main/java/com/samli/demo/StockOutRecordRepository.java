// This interface extends the MongoRepository interface and defines custom methods and queries
// for interacting with the MongoDB database for StockOutRecord entities.

package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface StockOutRecordRepository extends MongoRepository<StockOutRecord, String> {

    // Custom query to find StockOutRecord objects whose 'date' field falls within a specified date range.
    @Query("{'date': {$gte: ?0, $lte: ?1}}")
    List<StockOutRecord> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom query to fetch all StockOutRecord objects.
    List<StockOutRecord> findAll();

    // Custom query to find StockOutRecord objects whose 'date' field falls within a specified date range
    // and whose 'itemId' matches the provided value.
    @Query("{'date': {$gte: ?0, $lte: ?1}, 'itemId': ?2}")
    List<StockOutRecord> findByDateBetweenAndItemId(LocalDate startDate, LocalDate endDate, String itemId);
}
