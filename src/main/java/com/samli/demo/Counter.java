package com.samli.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counter")  // Tells Spring that this is a MongoDB document
public class Counter {

    @Id  // Marks 'id' as the identifier for this document
    private String id;

    private int seq;  // An integer field named 'seq'

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
