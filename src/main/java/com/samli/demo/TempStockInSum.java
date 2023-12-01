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

    public int getSumStockInAmount() {
        return sumStockInAmount;
    }

    public void setSumStockInAmount(int sumStockInAmount) {
        this.sumStockInAmount = sumStockInAmount;
    }

    public double getSumTotalPrice() {
        return sumTotalPrice;
    }

    public void setSumTotalPrice(double sumTotalPrice) {
        this.sumTotalPrice = sumTotalPrice;
    }
}
