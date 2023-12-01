// This class 'NumberRecord' represents a data entity for storing numbers in MongoDB

package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "numbers") // Indicates that this class maps to a MongoDB collection named "numbers"
public class NumberRecord {

    @Id // Indicates that the 'id' field is the unique identifier for this entity
    private String id; // Unique identifier for the number record
    private int number; // The integer number to be stored

    // Default Constructor (No-args constructor)
    public NumberRecord() {}

    // Parameterized Constructor for creating a number record with 'id' and 'number'
    public NumberRecord(String id, int number) {
        this.id = id;
        this.number = number;
    }

    // Getter method for retrieving the 'id' of the number record
    public String getId() {
        return id;
    }

    // Setter method for setting the 'id' of the number record
    public void setId(String id) {
        this.id = id;
    }

    // Getter method for retrieving the 'number' value of the number record
    public int getNumber() {
        return number;
    }

    // Setter method for setting the 'number' value of the number record
    public void setNumber(int number) {
        this.number = number;
    }

    // Overriding the 'toString' method to provide a human-readable representation of the object
    @Override
    public String toString() {
        return "NumberRecord{" +
                "id='" + id + '\'' +
                ", number=" + number +
                '}';
    }
}
