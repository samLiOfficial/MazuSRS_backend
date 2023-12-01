// This class 'StockInRecordCounter' represents a counter for generating unique IDs for StockInRecord objects.

package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock_in_record_counter")  // Maps to MongoDB collection named "stock_in_record_counter"
public class StockInRecordCounter {

    @Id  // Unique identifier for this entity
    private String id;

    private int seq;  // An integer field named 'seq' to hold the current sequence value

    // Getter for 'id'
    public String getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(String id) {
        this.id = id;
    }

    // Getter for 'seq'
    public int getSeq() {
        return seq;
    }

    // Setter for 'seq'
    public void setSeq(int seq) {
        this.seq = seq;
    }
}
