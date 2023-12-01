// This is a Data Transfer Object (DTO) class named 'StockInStatisticsDTO'.
// It is used to represent stock-in statistics data, including 'itemId' and 'totalStockIn'.

package com.samli.demo;

public class StockInStatisticsDTO {
    private String itemId;         // A field to store the unique identifier of an item.
    private Integer totalStockIn;  // A field to store the total quantity of stock-in for the item.

    // Constructor to initialize 'itemId' and 'totalStockIn' when creating an instance of this DTO.
    public StockInStatisticsDTO(String itemId, Integer totalStockIn) {
        this.itemId = itemId;
        this.totalStockIn = totalStockIn;
    }

    // Getter for 'itemId' to retrieve the unique identifier of an item.
    public String getItemId() {
        return itemId;
    }

    // Setter for 'itemId' to set the unique identifier of an item.
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    // Getter for 'totalStockIn' to retrieve the total quantity of stock-in for the item.
    public Integer getTotalStockIn() {
        return totalStockIn;
    }

    // Setter for 'totalStockIn' to set the total quantity of stock-in for the item.
    public void setTotalStockIn(Integer totalStockIn) {
        this.totalStockIn = totalStockIn;
    }
}
