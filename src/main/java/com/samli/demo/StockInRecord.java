// This class 'StockInRecord' represents a data entity for storing stock-in records in MongoDB

package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "stock_in_record") // Indicates that this class maps to a MongoDB collection named "stock_in_record"
public class StockInRecord {

    @Id // Indicates that the 'recordId' field is the unique identifier for this entity
    private String recordId; // Unique identifier for the stock-in record
    private LocalDate date; // Date of the stock-in record
    private String itemId; // Identifier of the item associated with the stock-in
    private String itemName; // Name of the item
    private String brand; // Brand of the item
    private String itemSize; // Size of the item
    private String unit; // Unit of measurement for the item
    private int stockInAmount; // Amount of the item stock-in
    private double unitPrice; // Price per unit of the item
    private double totalPrice; // Total price for the stock-in
    private String currencyUnit; // Currency unit used for pricing
    private String note; // Additional notes or comments

    // Getter method for retrieving the 'recordId' of the stock-in record
    public String getRecordId() {
        return recordId;
    }

    // Setter method for setting the 'recordId' of the stock-in record
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    // Getter method for retrieving the 'date' of the stock-in record
    public LocalDate getDate() {
        return date;
    }

    // Setter method for setting the 'date' of the stock-in record
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter method for retrieving the 'itemId' of the stock-in record
    public String getItemId() {
        return itemId;
    }

    // Setter method for setting the 'itemId' of the stock-in record
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    // Getter method for retrieving the 'itemName' of the stock-in record
    public String getItemName() {
        return itemName;
    }

    // Setter method for setting the 'itemName' of the stock-in record
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter method for retrieving the 'brand' of the stock-in record
    public String getBrand() {
        return brand;
    }

    // Setter method for setting the 'brand' of the stock-in record
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter method for retrieving the 'itemSize' of the stock-in record
    public String getItemSize() {
        return itemSize;
    }

    // Setter method for setting the 'itemSize' of the stock-in record
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    // Getter method for retrieving the 'unit' of the stock-in record
    public String getUnit() {
        return unit;
    }

    // Setter method for setting the 'unit' of the stock-in record
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Getter method for retrieving the 'stockInAmount' of the stock-in record
    public int getStockInAmount() {
        return stockInAmount;
    }

    // Setter method for setting the 'stockInAmount' of the stock-in record
    public void setStockInAmount(int stockInAmount) {
        this.stockInAmount = stockInAmount;
    }

    // Getter method for retrieving the 'unitPrice' of the stock-in record
    public double getUnitPrice() {
        return unitPrice;
    }

    // Setter method for setting the 'unitPrice' of the stock-in record
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    // Getter method for retrieving the 'totalPrice' of the stock-in record
    public double getTotalPrice() {
        return totalPrice;
    }

    // Setter method for setting the 'totalPrice' of the stock-in record
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Getter method for retrieving the 'currencyUnit' of the stock-in record
    public String getCurrencyUnit() {
        return currencyUnit;
    }

    // Setter method for setting the 'currencyUnit' of the stock-in record
    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    // Getter method for retrieving the 'note' of the stock-in record
    public String getNote() {
        return note;
    }

    // Setter method for setting the 'note' of the stock-in record
    public void setNote(String note) {
        this.note = note;
    }

    // Overriding the 'toString' method to provide a string representation of the 'StockInRecord' object
    @Override
    public String toString() {
        return "StockInRecord{" +
                "recordId='" + recordId + '\'' +
                ", date='" + date + '\'' +
                ", itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", brand='" + brand + '\'' +
                ", itemSize='" + itemSize + '\'' +
                ", unit='" + unit + '\'' +
                ", stockInAmount=" + stockInAmount +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", currencyUnit='" + currencyUnit + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
