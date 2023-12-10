// This class serves as a RESTful controller for handling item-related operations
// It includes endpoints for creating items, retrieving item-related data, and performing searches

package com.samli.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository repository; // Auto-wired repository for item data access

    @Autowired
    private InventoryStatsRepository inventoryStatsRepository; // Auto-wired repository for inventory statistics

    @Autowired
    private MongoOperations mongo; // Auto-wired MongoDB operations

    // Method to get the next sequence for generating item IDs
    public int getNextSequence(String seqName) {
        Counter counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq", 1),
                options().returnNew(true).upsert(true),
                Counter.class);
        return counter.getSeq();
    }

    // Endpoint to create an item
    @CrossOrigin(origins = "http://localhost:3000") // Cross-origin resource sharing (CORS) configuration
    @PostMapping("/item")
    public String createItem(@RequestBody Item item) {

        // Retrieve all items from the database
        List<Item> allItems = repository.findAll();

        // Check if the item already exists in the database
        for (Item existingItem : allItems) {
            if (
                    existingItem.getItemType().equals(item.getItemType()) &&
                    existingItem.getItemName().equals(item.getItemName()) &&
                    existingItem.getBrand().equals(item.getBrand()) &&
                    existingItem.getItemSize().equals(item.getItemSize()) &&
                    existingItem.getUnit().equals(item.getUnit())) {
                return "Item already saved!";
            }
        }

        // Check if the item ID is empty or null
        if (item.getItemId() == null || item.getItemId().isEmpty()) {
            // Generate the next item ID using the getNextSequence method
            int nextId = getNextSequence("itemId");
            String nextIdStr = String.format("P-%08d", nextId);  // Convert it to a string with leading zeros
            item.setItemId(nextIdStr);
        }

        // Save the item in the repository
        repository.save(item);

        // Create an initial inventory stats entry for the item
        InventoryStats stats = new InventoryStats();
        stats.setItemId(item.getItemId());
        stats.setItemType(item.getItemType());
        stats.setItemName(item.getItemName());
        stats.setBrand(item.getBrand());
        stats.setItemSize(item.getItemSize());
        stats.setUnit(item.getUnit());
        stats.setStockAmount(0); // Set initial stock amount to 0

        // Save the inventory stats entry
        inventoryStatsRepository.save(stats);

        // Return a success message with item attributes
        return "Item and initial inventory stats saved! Attributes: " + item.toString();
    }

    // New endpoints for dependent dropdowns

    // Endpoint to get all unique brands
    @GetMapping("/brands")
    public List<String> getAllBrands() {
        return repository.findAll().stream()
                .map(Item::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }

    // Endpoint to get item types by brand
    @GetMapping("/itemTypes/{brand}")
    public List<String> getItemTypesByBrand(@PathVariable String brand) {
        return repository.findByBrand(brand).stream()
                .map(Item::getItemType)
                .distinct()
                .collect(Collectors.toList());
    }

    // Endpoint to get units by brand and item type
    @GetMapping("/units/{brand}/{itemType}")
    public List<String> getUnitsByBrandAndItemType(@PathVariable String brand, @PathVariable String itemType) {
        return repository.findByBrandAndItemType(brand, itemType).stream()
                .map(Item::getUnit)
                .distinct()
                .collect(Collectors.toList());
    }

    // Endpoint to get item names by brand and item type
    @GetMapping("/itemNames/{brand}/{itemType}")
    public List<String> getItemNamesByBrandAndItemType(@PathVariable String brand, @PathVariable String itemType) {
        return repository.findByBrandAndItemType(brand, itemType).stream()
                .map(Item::getItemName)
                .distinct()
                .collect(Collectors.toList());
    }

    // Endpoint to get units by criteria (brand, item type, item name)
    @GetMapping("/units/{brand}/{itemType}/{itemName}")
    public List<String> getUnitsByCriteria(@PathVariable String brand, @PathVariable String itemType, @PathVariable String itemName) {
        return repository.findByBrandAndItemTypeAndItemName(brand, itemType, itemName).stream()
                .map(Item::getUnit)
                .distinct()
                .collect(Collectors.toList());
    }

    // Endpoint to get sizes by criteria (brand, item type, item name, unit)
    @GetMapping("/sizes/{brand}/{itemType}/{itemName}/{unit}")
    public List<String> getSizesByCriteria(@PathVariable String brand, @PathVariable String itemType, @PathVariable String itemName, @PathVariable String unit) {
        return repository.findByBrandAndItemTypeAndItemNameAndUnit(brand, itemType, itemName, unit).stream()
                .map(Item::getItemSize)
                .distinct()
                .collect(Collectors.toList());
    }

    // Endpoint to search for items based on criteria (brand, item type, item name, unit, item size)
    @GetMapping("/searchItem")
    public List<Item> searchItem(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String itemType,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) String unit,
            @RequestParam(required = false) String itemSize) {

        // Check for the presence of criteria and apply filtering accordingly
        if (brand != null && itemType != null && itemName != null && unit != null && itemSize != null) {
            return repository.findByBrandAndItemTypeAndItemNameAndUnitAndItemSize(brand, itemType, itemName, unit, itemSize);
        } else if (brand != null && itemType != null && itemName != null && unit != null) {
            return repository.findByBrandAndItemTypeAndItemNameAndUnit(brand, itemType, itemName, unit);
        } else if (brand != null && itemType != null && itemName != null) {
            return repository.findByBrandAndItemTypeAndItemName(brand, itemType, itemName);
        } else if (brand != null && itemType != null) {
            return repository.findByBrandAndItemType(brand, itemType);
        } else if (brand != null) {
            return repository.findByBrand(brand);
        } else {
            return new ArrayList<>(); // Return an empty list if no criteria provided
        }
    }

    // Endpoint to get all items
    @GetMapping("/all-items")
    public List<ItemDTO> getAllItems() {
        return repository.findAll().stream().map(item -> new ItemDTO(
                item.getItemId(),
                String.format("%s-%s-%s-%s-%s-%s", item.getItemType(), item.getItemName(), item.getItemSize(), item.getUnit(), item.getBrand(), item.getItemId())
        )).collect(Collectors.toList());
    }
}

// A DTO (Data Transfer Object) class for representing items with formatted strings
class ItemDTO {
    // Private fields to store item ID and formatted string
    private String itemId;
    private String formattedString;

    // Constructor to initialize the ItemDTO object with item ID and formatted string
    public ItemDTO(String itemId, String formattedString) {
        this.itemId = itemId; // Set the provided item ID to the class field
        this.formattedString = formattedString; // Set the provided formatted string to the class field
    }

    // Getter method to retrieve the item ID
    public String getItemId() {
        return itemId; // Return the stored item ID
    }

    // Setter method to update the item ID
    public void setItemId(String itemId) {
        this.itemId = itemId; // Update the item ID with the provided value
    }

    // Getter method to retrieve the formatted string
    public String getFormattedString() {
        return formattedString; // Return the stored formatted string
    }

    // Setter method to update the formatted string
    public void setFormattedString(String formattedString) {
        this.formattedString = formattedString; // Update the formatted string with the provided value
    }
}
