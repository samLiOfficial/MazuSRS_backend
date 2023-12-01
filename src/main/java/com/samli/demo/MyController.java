// This class 'MyController' is a Spring Boot REST controller responsible for handling HTTP requests

package com.samli.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private NumberRecordRepository repository; // Auto-wired repository for number records data access

    // Endpoint to respond with a simple "Hello from Spring Boot!" message
    @CrossOrigin(origins = "http://localhost:3000") // Cross-origin resource sharing (CORS) configuration
    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring Boot!";
    }

    // Endpoint to receive and process data sent as a JSON request body
    @CrossOrigin(origins = "http://localhost:3000") // CORS configuration
    @PostMapping("/record")
    public String receiveData(@RequestBody NumberRecord record) {
        System.out.println("Received ID: " + record.getId());
        System.out.println("Received number: " + record.getNumber());

        // Save the received record to MongoDB using the repository
        repository.save(record);

        return "Data received: ID - " + record.getId() + ", Number - " + record.getNumber();
    }

    // Endpoint to retrieve all number records from MongoDB
    @CrossOrigin(origins = "http://localhost:3000") // CORS configuration
    @GetMapping("/records")
    public List<NumberRecord> getAllRecords() {
        // Fetch all number records from the repository
        List<NumberRecord> records = repository.findAll();

        // Print the fetched records in the backend console
        records.forEach(record -> {
            System.out.println("ID: " + record.getId() + ", Number: " + record.getNumber());
        });

        // Return the list of number records
        return records;
    }
}
