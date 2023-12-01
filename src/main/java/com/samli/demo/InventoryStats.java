package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This class represents an entity that maps to a MongoDB collection named "inventory_stats"
@Document(collection = "inventory_stats")
public class InventoryStats {

    @Id // This annotation indicates that the 'itemId' field is the unique identifier
    private String itemId; // Field to store the item's unique identifier

    private String itemType; // Field to store the type of the item
    private String itemName; // Field to store the name of the item
    private String brand; // Field to store the brand of the item
    private String itemSize; // Field to store the size of the item
    private String unit; // Field to store the unit of measurement for the item
    private int stockAmount; // Field to store the stock amount of the item

    // Default Constructor
    public InventoryStats() {
    }

    // Parameterized Constructor
    public InventoryStats(String itemId, String itemType, String itemName, String brand, String itemSize, String unit, int stockAmount) {
        // Initialize the fields with provided values
        this.itemId = itemId;
        this.itemType = itemType;
        this.itemName = itemName;
        this.brand = brand;
        this.itemSize = itemSize;
        this.unit = unit;
        this.stockAmount = stockAmount;
    }

    // Getter for 'itemId'
    public String getItemId() {
        return itemId;
    }

    // Setter for 'itemId'
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    // Getter for 'itemType'
    public String getItemType() {
        return itemType;
    }

    // Setter for 'itemType'
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    // Getter for 'itemName'
    public String getItemName() {
        return itemName;
    }

    // Setter for 'itemName'
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for 'brand'
    public String getBrand() {
        return brand;
    }

    // Setter for 'brand'
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter for 'itemSize'
    public String getItemSize() {
        return itemSize;
    }

    // Setter for 'itemSize'
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    // Getter for 'unit'
    public String getUnit() {
        return unit;
    }

    // Setter for 'unit'
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Getter for 'stockAmount'
    public int getStockAmount() {
        return stockAmount;
    }

    // Setter for 'stockAmount'
    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
