// This is a controller class named 'StockOutRecordController' responsible for handling stock-out record-related HTTP requests.

package com.samli.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StockOutRecordController {

    @Autowired
    private StockOutRecordRepository repository;  // Repository for StockOutRecord

    @Autowired
    private InventoryStatsRepository inventoryStatsRepository;  // Repository for InventoryStats

    @Autowired
    private StockOutRecordCounterRepository counterRepository;  // Repository for StockOutRecordCounter

    @Autowired
    private ItemRepository itemRepository;  // Repository for Item

    @Autowired
    private TempStockOutSumRepository tempStockOutSumRepository;  // Repository for TempStockOutSum

    @CrossOrigin(origins = "http://localhost:3000")  // Allow cross-origin requests from a specific URL
    @PostMapping("/stock-out-record")  // Handle POST requests to create stock-out records
    public String createStockOutRecord(@RequestBody StockOutRecord record) {
        // Get current stock amount from InventoryStats
        InventoryStats stats = inventoryStatsRepository.findByItemId(record.getItemId());

        // Check if stock out amount is valid
        if (stats != null && stats.getStockAmount() >= record.getStockOutAmount()) {
            // Set the current date
            record.setDate(LocalDate.now());

            // Auto-generate record ID
            StockOutRecordCounter counter = counterRepository.findById("stockOutRecordCounter")
                    .orElse(new StockOutRecordCounter("stockOutRecordCounter", 0));
            counter.setSeq(counter.getSeq() + 1);
            counterRepository.save(counter);
            String newId = String.format("O-%08d", counter.getSeq());
            record.setRecordId(newId);

            // Update InventoryStats
            stats.setStockAmount(stats.getStockAmount() - record.getStockOutAmount());
            inventoryStatsRepository.save(stats);

            // Save the record
            repository.save(record);
            return "Stock-out record saved! Attributes: " + record.toString();
        } else {
            return "Error: Stock out amount exceeds current stock.";
        }
    }

    // Handle GET requests to retrieve stock-out records between specified dates
    @GetMapping("/stock-out-statistics")
    public List<StockOutRecord> getStockOutRecordsBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return repository.findByDateBetween(startDate, endDate);
    }

    // Handle GET requests to retrieve stock-out records by item between specified dates
    @GetMapping("/stock-out-record-by-item")
    public List<StockOutRecord> getStockOutRecordsByItem(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("itemId") String itemId) {
        return repository.findByDateBetweenAndItemId(startDate, endDate, itemId);
    }

    // Handle GET requests to summarize stock-out records between specified dates
    @GetMapping("/summarize-stock-out")
    public List<TempStockOutSum> summarizeStockOut(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        // Clear the existing data in TempStockOutSum collection
        tempStockOutSumRepository.deleteAll();

        // Fetch all items and calculate the summary
        // First get all the item from the item inventory list
        List<Item> allItems = itemRepository.findAll();
        //then map through each of the item in the alltime list
        allItems.forEach(item -> {
            // Get a list of stock out records for the specific start date and end date of an item
            List<StockOutRecord> records = repository.findByDateBetweenAndItemId(startDate, endDate, item.getItemId());

            // Calculate the sum of stock out amounts
            int sumStockOutAmount = records.stream().mapToInt(StockOutRecord::getStockOutAmount).sum();

            // Calculate the sum of sell price correctly by multiplying stockOutAmount with sellPrice for each record
            // Using a in-line function converter
            double sumSellPrice = records.stream().mapToDouble(record -> record.getStockOutAmount() * record.getSellPrice()).sum();

            if (!records.isEmpty()) {
                TempStockOutSum tempSum = new TempStockOutSum();
                tempSum.setItemName(item.getItemName());
                tempSum.setItemSize(item.getItemSize());
                tempSum.setUnit(item.getUnit());
                tempSum.setItemType(item.getItemType());
                tempSum.setBrand(item.getBrand());
                tempSum.setStartDate(startDate);
                tempSum.setEndDate(endDate);
                tempSum.setSumStockOutAmount(sumStockOutAmount);
                tempSum.setSumSellPrice(sumSellPrice);
                tempStockOutSumRepository.save(tempSum);
            }
        });

        return tempStockOutSumRepository.findAll();
    }

    // Handle GET requests to summarize stock-out records by item between specified dates
    @GetMapping("/stock-out-summary-by-item")
    public TempStockOutSum summarizeStockOutByItem(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("itemId") String itemId) {

        List<StockOutRecord> records = repository.findByDateBetweenAndItemId(startDate, endDate, itemId);
        int sumStockOutAmount = records.stream().mapToInt(StockOutRecord::getStockOutAmount).sum();
        double sumSellPrice = records.stream().mapToDouble(record -> record.getStockOutAmount() * record.getSellPrice()).sum();

        if (!records.isEmpty()) {
            TempStockOutSum tempSum = new TempStockOutSum();
            Item item = itemRepository.findById(itemId).orElse(null);
            if (item != null) {
                tempSum.setItemName(item.getItemName());
                tempSum.setItemSize(item.getItemSize());
                tempSum.setUnit(item.getUnit());
                tempSum.setItemType(item.getItemType());
                tempSum.setBrand(item.getBrand());
            }
            tempSum.setStartDate(startDate);
            tempSum.setEndDate(endDate);
            tempSum.setSumStockOutAmount(sumStockOutAmount);
            tempSum.setSumSellPrice(sumSellPrice);
            return tempSum;
        }

        return null; // Or handle the case of empty records as per your requirement
    }

    // New delete endpoint for stock-out records
    @DeleteMapping("/stock-out-record/{id}")
    public ResponseEntity<?> deleteStockOutRecord(@PathVariable String id) {
        return repository.findById(id)
                .map(record -> {
                    // Fetch the InventoryStats for the item
                    InventoryStats stats = inventoryStatsRepository.findByItemId(record.getItemId());
                    if (stats != null) {
                        // Increase the stock amount to account for the deletion of the stock-out record
                        stats.setStockAmount(stats.getStockAmount() + record.getStockOutAmount());
                        // Save the updated InventoryStats
                        inventoryStatsRepository.save(stats);
                    }

                    // Delete the StockOutRecord
                    repository.delete(record);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PutMapping("/stock-out-record/{id}")
    public ResponseEntity<StockOutRecord> updateStockOutRecord(@PathVariable String id, @RequestBody StockOutRecord updatedRecord) {
        return repository.findById(id)
                .map(record -> {
                    // Calculate the difference between the new and the existing stockOutAmount
                    int amountDifference = updatedRecord.getStockOutAmount() - record.getStockOutAmount();

                    // Update the fields that are allowed to be edited
                    record.setStockOutAmount(updatedRecord.getStockOutAmount());
                    record.setSellPrice(updatedRecord.getSellPrice());

                    // Save the updated record
                    StockOutRecord savedRecord = repository.save(record);

                    // Fetch the InventoryStats for the item and update it
                    InventoryStats stats = inventoryStatsRepository.findByItemId(record.getItemId());
                    if (stats != null) {
                        // Adjust the stock amount in InventoryStats based on the new stockOutAmount
                        // Note: Decreasing stockAmount because it's stock-out
                        stats.setStockAmount(stats.getStockAmount() - amountDifference);
                        inventoryStatsRepository.save(stats);
                    }

                    return ResponseEntity.ok(savedRecord);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
