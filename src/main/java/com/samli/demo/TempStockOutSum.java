// This class represents a document in the 'temp_stock_out_sum' MongoDB collection.

package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "temp_stock_out_sum") // Specifies that instances of this class should be stored in the 'temp_stock_out_sum' collection in MongoDB.
public class TempStockOutSum {

    @Id // Indicates that the 'id' field serves as the unique identifier for MongoDB documents.
    private String id; // Unique identifier for MongoDB document
    private String itemName; // Name of the item
    private String itemSize; // Size of the item
    private String unit; // Unit of measurement for the item
    private String itemType; // Type or category of the item
    private String brand; // Brand of the item
    private LocalDate startDate; // Start date for the summary period
    private LocalDate endDate; // End date for the summary period
    private int sumStockOutAmount; // Total stock-out amount during the period
    private double sumSellPrice; // Total sell price during the period

    // Constructors

    // Default constructor with no arguments.
    public TempStockOutSum() {
    }

    // Parameterized constructor to initialize all fields of the document.
    public TempStockOutSum(String itemName, String itemSize, String unit, String itemType, String brand, LocalDate startDate, LocalDate endDate, int sumStockOutAmount, double sumSellPrice) {
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.unit = unit;
        this.itemType = itemType;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sumStockOutAmount = sumStockOutAmount;
        this.sumSellPrice = sumSellPrice;
    }

    // Getters and Setters for accessing and modifying private fields.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getSumStockOutAmount() {
        return sumStockOutAmount;
    }

    public void setSumStockOutAmount(int sumStockOutAmount) {
        this.sumStockOutAmount = sumStockOutAmount;
    }

    public double getSumSellPrice() {
        return sumSellPrice;
    }

    public void setSumSellPrice(double sumSellPrice) {
        this.sumSellPrice = sumSellPrice;
    }
}
