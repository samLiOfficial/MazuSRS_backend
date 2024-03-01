// This class represents a document in the "temp_stock_in_sum" collection of MongoDB.
package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "temp_stock_in_sum") // Maps to MongoDB collection "temp_stock_in_sum"
public class TempStockInSum {

    @Id // Unique identifier for MongoDB
    private String id;
    private String itemName;
    private String itemSize;
    private String unit;
    private String itemType;
    private String brand;
    private LocalDate startDate; // Start date for the stock-in summary period
    private LocalDate endDate;   // End date for the stock-in summary period
    private int sumStockInAmount; // Total stock-in amount for the specified period
    private double sumTotalPrice; // Total sum of the prices for the specified period

    // Default Constructor
    public TempStockInSum() {
    }

    // Parameterized Constructor
    public TempStockInSum(String itemName, String itemSize, String unit, String itemType, String brand, LocalDate startDate, LocalDate endDate, int sumStockInAmount, double sumTotalPrice) {
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.unit = unit;
        this.itemType = itemType;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sumStockInAmount = sumStockInAmount;
        this.sumTotalPrice = sumTotalPrice;
    }

    // Getter and Setter methods for class fields
    public String getId() { // Method to get the document ID
        return id;
    }

    public void setId(String id) { // Method to set the document ID
        this.id = id;
    }

    public String getItemName() { // Method to get the item name
        return itemName;
    }

    public void setItemName(String itemName) { // Method to set the item name
        this.itemName = itemName;
    }

    public String getItemSize() { // Method to get the item size
        return itemSize;
    }

    public void setItemSize(String itemSize) { // Method to set the item size
        this.itemSize = itemSize;
    }

    public String getUnit() { // Method to get the unit
        return unit;
    }

    public void setUnit(String unit) { // Method to set the unit
        this.unit = unit;
    }

    public String getItemType() { // Method to get the item type
        return itemType;
    }

    public void setItemType(String itemType) { // Method to set the item type
        this.itemType = itemType;
    }

    public String getBrand() { // Method to get the brand
        return brand;
    }

    public void setBrand(String brand) { // Method to set the brand
        this.brand = brand;
    }

    public LocalDate getStartDate() { // Method to get the start date
        return startDate;
    }

    public void setStartDate(LocalDate startDate) { // Method to set the start date
        this.startDate = startDate;
    }

    public LocalDate getEndDate() { // Method to get the end date
        return endDate;
    }

    public void setEndDate(LocalDate endDate) { // Method to set the end date
        this.endDate = endDate;
    }

    public int getSumStockInAmount() { // Method to get the total stock-in amount
        return sumStockInAmount;
    }

    public void setSumStockInAmount(int sumStockInAmount) { // Method to set the total stock-in amount
        this.sumStockInAmount = sumStockInAmount;
    }

    public double getSumTotalPrice() { // Method to get the total sum of prices
        return sumTotalPrice;
    }

    public void setSumTotalPrice(double sumTotalPrice) { // Method to set the total sum of prices
        this.sumTotalPrice = sumTotalPrice;
    }
}
