// This interface 'ItemRepository' is a Spring Data MongoDB repository
// It is used to perform CRUD (Create, Read, Update, Delete) operations on 'Item' entities

package com.samli.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indicates that this interface is a Spring repository component
public interface ItemRepository extends MongoRepository<Item, String> {

    // Custom query methods for searching items by various criteria

    // Find items by 'brand'
    List<Item> findByBrand(String brand);

    // Find items by 'brand' and 'itemType'
    List<Item> findByBrandAndItemType(String brand, String itemType);

    // Find items by 'brand', 'itemType', and 'itemName'
    List<Item> findByBrandAndItemTypeAndItemName(String brand, String itemType, String itemName);

    // Find items by 'brand', 'itemType', 'itemName', and 'unit'
    List<Item> findByBrandAndItemTypeAndItemNameAndUnit(String brand, String itemType, String itemName, String unit);

    // Find items by 'brand', 'itemType', 'itemName', 'unit', and 'itemSize'
    List<Item> findByBrandAndItemTypeAndItemNameAndUnitAndItemSize(String brand, String itemType, String itemName, String unit, String itemSize);

    // Override of the findAll() method to retrieve all items
    @Override
    List<Item> findAll();
}
