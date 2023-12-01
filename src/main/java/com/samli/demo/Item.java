// This class represents an entity 'Item' that maps to a MongoDB collection named "items"
// It is used to store information about items

package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mark this class as a MongoDB document and specify the collection name
@Document(collection = "items")
public class Item {

    @Id
    private String itemId; // Unique identifier for the item, can be user-defined
    private String itemType; // Type of the item
    private String itemName; // Name of the item
    private String brand; // Brand of the item
    private String itemSize; // Size of the item
    private String unit; // Unit of measurement for the item
    private String note; // Additional notes about the item

    // Default Constructor
    public Item() {}

    // Parameterized Constructor to initialize all fields
    public Item(String itemId, String itemType, String itemName, String brand, String itemSize, String unit, String note) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.itemName = itemName;
        this.brand = brand;
        this.itemSize = itemSize;
        this.unit = unit;
        this.note = note;
    }

    // Getter and Setter methods for each field
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Override of the toString() method to provide a string representation of the object
    @Override
    public String toString() {
        // Concatenate each field with its value to form a readable string
        return "Item { " +
                "itemId: " + itemId + ", " +
                "itemType: " + itemType + ", " +
                "itemName: " + itemName + ", " +
                "brand: " + brand + ", " +
                "itemSize: " + itemSize + ", " +
                "unit: " + unit + ", " +
                "note: " + note +
                " }";
    }
}
