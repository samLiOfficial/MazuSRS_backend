// This class represents the counter for generating unique StockOutRecord IDs.

package com.samli.demo;

import org.springframework.data.annotation.Id;

public class StockOutRecordCounter {
    @Id
    private String id; // Identifier for MongoDB
    private int seq; // The sequence number for generating record IDs

    // Constructor for creating a new StockOutRecordCounter instance
    public StockOutRecordCounter(String id, int seq) {
        this.id = id; // Initialize the identifier
        this.seq = seq; // Initialize the sequence number
    }

    // Getter method for retrieving the identifier
    public String getId() {
        return id;
    }

    // Setter method for setting the identifier
    public void setId(String id) {
        this.id = id;
    }

    // Getter method for retrieving the sequence number
    public int getSeq() {
        return seq;
    }

    // Setter method for setting the sequence number
    public void setSeq(int seq) {
        this.seq = seq;
    }

    // Override the toString() method to provide a string representation of the StockOutRecordCounter instance
    @Override
    public String toString() {
        return "StockOutRecordCounter{" +
                "id='" + id + '\'' +
                ", seq=" + seq +
                '}';
    }
}
