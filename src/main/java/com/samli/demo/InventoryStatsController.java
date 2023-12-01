package com.samli.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class is a RESTful controller for handling inventory statistics
@RestController
public class InventoryStatsController {

    @Autowired
    private InventoryStatsRepository repository; // Auto-wired repository for data access

    // Endpoint to get all inventory statistics
    @CrossOrigin(origins = "http://localhost:3000") // Cross-origin resource sharing (CORS) configuration
    @GetMapping("/inventory-stats") // HTTP GET request mapping for the "/inventory-stats" endpoint
    public List<InventoryStats> getAllInventoryStats() {
        // This method returns a list of all inventory statistics from the repository
        return repository.findAll();
    }
}
