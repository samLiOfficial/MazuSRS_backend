package com.samli.demo;

import java.time.LocalDate;

// This class represents a Data Transfer Object (DTO) for Date Range
public class DateRangeDTO {
    private LocalDate startDate; // Private field to store the start date of the range
    private LocalDate endDate;   // Private field to store the end date of the range

    // Getters and Setters

    // Getter for startDate, returns the start date of the range
    public LocalDate getStartDate() {
        return startDate;
    }

    // Setter for startDate, sets the start date of the range
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getter for endDate, returns the end date of the range
    public LocalDate getEndDate() {
        return endDate;
    }

    // Setter for endDate, sets the end date of the range
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Override of the toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "DateRangeDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
