// This interface 'StockInRecordRepository' serves as a repository for the 'StockInRecord' entity.
// It extends the 'MongoRepository' interface, which provides basic CRUD (Create, Read, Update, Delete) operations
// for working with 'StockInRecord' objects in MongoDB.

package com.samli.demo;

import com.samli.demo.StockInRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface StockInRecordRepository extends MongoRepository<StockInRecord, String> {

    // This method is annotated with the @Query annotation, indicating a custom query to fetch 'StockInRecord' objects
    // based on the date range specified as 'startDate' and 'endDate'. It uses MongoDB's query syntax with $gte (greater than or equal to)
    // and $lte (less than or equal to) operators to filter records within the date range.
    @Query("{'date': {$gte: ?0, $lte: ?1}}")
    List<StockInRecord> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // This method is added to the repository to fetch all 'StockInRecord' objects without any date filtering.
    List<StockInRecord> findAll();

    // This method is annotated with the @Query annotation, indicating a custom query to fetch 'StockInRecord' objects
    // based on both the date range specified as 'startDate' and 'endDate', and a specific 'itemId'.
    @Query("{'date': {$gte: ?0, $lte: ?1}, 'itemId': ?2}")
    List<StockInRecord> findByDateBetweenAndItemId(LocalDate startDate, LocalDate endDate, String itemId);
}
