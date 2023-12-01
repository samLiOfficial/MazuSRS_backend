package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

// This interface extends the MongoRepository interface, indicating it's a repository for 'InventoryStats' entities
public interface InventoryStatsRepository extends MongoRepository<InventoryStats, String> {

    // This method is used to find an 'InventoryStats' entity by its 'itemId'
    InventoryStats findByItemId(String itemId);
}
