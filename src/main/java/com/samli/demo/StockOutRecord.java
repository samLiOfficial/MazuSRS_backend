// This is a class named 'StockOutRecord' representing records of stock-out transactions.
// It is mapped to a MongoDB collection named "stock_out_record".

package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "stock_out_record")  // Maps to MongoDB collection
public class StockOutRecord {

    @Id  // Unique identifier
    private String recordId;        // Field to store the unique identifier of a stock-out record.

    private LocalDate date;         // Field to store the date of the stock-out transaction.
    private String itemId;          // Field to store the unique identifier of the item.
    private String itemName;        // Field to store the name of the item.
    private String brand;           // Field to store the brand of the item.
    private String itemSize;        // Field to store the size of the item.
    private String unit;            // Field to store the unit of measurement for the item.
    private int stockOutAmount;     // Field to store the quantity of items stock-out.
    private String currencyUnit;    // Field to store the currency unit for the transaction.
    private String note;            // Field to store any notes or comments for the transaction.
    private double sellPrice;       // Field to store the selling price of the item.

    // Default Constructor
    public StockOutRecord() {
    }

    // Parameterized Constructor to initialize all fields when creating an instance of this class.
    public StockOutRecord(String recordId, LocalDate date, String itemId, String itemName, String brand, String itemSize, String unit, int stockOutAmount, String currencyUnit, String note, double sellPrice) {
        this.recordId = recordId;
        this.date = date;
        this.itemId = itemId;
        this.itemName = itemName;
        this.brand = brand;
        this.itemSize = itemSize;
        this.unit = unit;
        this.stockOutAmount = stockOutAmount;
        this.currencyUnit = currencyUnit;
        this.note = note;
        this.sellPrice = sellPrice;
    }

    // Getter for 'recordId' to retrieve the unique identifier of the stock-out record.
    public String getRecordId() {
        return recordId;
    }

    // Setter for 'recordId' to set the unique identifier of the stock-out record.
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    // Getter for 'date' to retrieve the date of the stock-out transaction.
    public LocalDate getDate() {
        return date;
    }

    // Setter for 'date' to set the date of the stock-out transaction.
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter for 'itemId' to retrieve the unique identifier of the item.
    public String getItemId() {
        return itemId;
    }

    // Setter for 'itemId' to set the unique identifier of the item.
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    // Getter for 'itemName' to retrieve the name of the item.
    public String getItemName() {
        return itemName;
    }

    // Setter for 'itemName' to set the name of the item.
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for 'brand' to retrieve the brand of the item.
    public String getBrand() {
        return brand;
    }

    // Setter for 'brand' to set the brand of the item.
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter for 'itemSize' to retrieve the size of the item.
    public String getItemSize() {
        return itemSize;
    }

    // Setter for 'itemSize' to set the size of the item.
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    // Getter for 'unit' to retrieve the unit of measurement for the item.
    public String getUnit() {
        return unit;
    }

    // Setter for 'unit' to set the unit of measurement for the item.
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Getter for 'stockOutAmount' to retrieve the quantity of items stock-out.
    public int getStockOutAmount() {
        return stockOutAmount;
    }

    // Setter for 'stockOutAmount' to set the quantity of items stock-out.
    public void setStockOutAmount(int stockOutAmount) {
        this.stockOutAmount = stockOutAmount;
    }

    // Getter for 'currencyUnit' to retrieve the currency unit for the transaction.
    public String getCurrencyUnit() {
        return currencyUnit;
    }

    // Setter for 'currencyUnit' to set the currency unit for the transaction.
    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    // Getter for 'note' to retrieve any notes or comments for the transaction.
    public String getNote() {
        return note;
    }

    // Setter for 'note' to set any notes or comments for the transaction.
    public void setNote(String note) {
        this.note = note;
    }

    // Getter for 'sellPrice' to retrieve the selling price of the item.
    public double getSellPrice() {
        return sellPrice;
    }

    // Setter for 'sellPrice' to set the selling price of the item.
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    // Override of the 'toString' method to provide a string representation of the object.
    @Override
    public String toString() {
        return "StockOutRecord{" +
                "recordId='" + recordId + '\'' +
                ", date=" + date +
                ", itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", brand='" + brand + '\'' +
                ", itemSize='" + itemSize + '\'' +
                ", unit='" + unit + '\'' +
                ", stockOutAmount=" + stockOutAmount +
                ", currencyUnit='" + currencyUnit + '\'' +
                ", note='" + note + '\'' +
                ", sellPrice=" + sellPrice +
                '}';
    }
}
