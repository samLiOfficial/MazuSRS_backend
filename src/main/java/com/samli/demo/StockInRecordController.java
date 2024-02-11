// This class 'StockInRecordController' serves as a controller for handling stock-in record-related operations

package com.samli.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StockInRecordController {

    @Autowired
    private InventoryStatsRepository inventoryStatsRepository;

    @Autowired
    private StockInRecordRepository stockInRecordRepository; // Repository for StockInRecord

    @Autowired
    private StockInRecordCounterRepository stockInRecordCounterRepository; // Repository for StockInRecordCounter

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TempStockInSumRepository tempStockInSumRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/stock-in-record")
    public String createStockInRecord(@RequestBody StockInRecord stockInRecord) {

        // Set the current date
        stockInRecord.setDate(LocalDate.now());

        // Load or create the counter
        StockInRecordCounter counter = stockInRecordCounterRepository.findById("stockInRecordId")
                .orElse(new StockInRecordCounter());
        if (counter.getId() == null) {
            counter.setId("stockInRecordId");
            counter.setSeq(0);
        }

        // Increment the counter
        counter.setSeq(counter.getSeq() + 1);

        // Save the updated counter
        stockInRecordCounterRepository.save(counter);

        // Generate the new ID for the stock-in record
        String newId = String.format("I-%08d", counter.getSeq());
        stockInRecord.setRecordId(newId);

        // Save the stock-in record
        stockInRecordRepository.save(stockInRecord);

        // Update inventory stats
        InventoryStats stats = inventoryStatsRepository.findByItemId(stockInRecord.getItemId());
        if (stats != null) {
            stats.setStockAmount(stats.getStockAmount() + stockInRecord.getStockInAmount());
            inventoryStatsRepository.save(stats);
        }

        return "Stock-in record and updated inventory stats saved! Attributes: " + stockInRecord.toString();
    }

    // Add the following endpoint for stock-in statistics
    @GetMapping("/stock-in-statistics")
    public List<StockInRecord> getStockInRecordsBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return stockInRecordRepository.findByDateBetween(startDate, endDate);
    }

    @GetMapping("/stock-in-record-by-item")
    public List<StockInRecord> getStockInRecordsByItem(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("itemId") String itemId) {
        return stockInRecordRepository.findByDateBetweenAndItemId(startDate, endDate, itemId);
    }

    @GetMapping("/summarize-stock-in")
    public List<TempStockInSum> summarizeStockIn(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        // Clear the existing data in temp_stock_in_sum collection
        tempStockInSumRepository.deleteAll();

        // Fetch all items and calculate the summary
        //allItems is a list of Items
        List<Item> allItems = itemRepository.findAll();

        //For each of the item
        allItems.forEach(item -> {

            //Get the list of the record bese on the current item
            //So it should return a list of StockInRecord?
            List<StockInRecord> records = stockInRecordRepository.findByDateBetweenAndItemId(startDate, endDate, item.getItemId());
            //Stock in amount is record
            //int equals to records to stream, and then mapEachOneTo Int, using the getStockInAmount and then sum them up
            int sumStockInAmount = records.stream().mapToInt(StockInRecord::getStockInAmount).sum();
            double sumTotalPrice = records.stream().mapToDouble(StockInRecord::getTotalPrice).sum();

            if (!records.isEmpty()) {
                TempStockInSum tempSum = new TempStockInSum();
                tempSum.setItemName(item.getItemName());
                tempSum.setItemSize(item.getItemSize());
                tempSum.setUnit(item.getUnit());
                tempSum.setItemType(item.getItemType());
                tempSum.setBrand(item.getBrand());
                tempSum.setStartDate(startDate);
                tempSum.setEndDate(endDate);
                tempSum.setSumStockInAmount(sumStockInAmount);
                tempSum.setSumTotalPrice(sumTotalPrice);
                tempStockInSumRepository.save(tempSum);
            }
        });

        return tempStockInSumRepository.findAll();
    }

    @GetMapping("/stock-in-summary-by-item")
    public TempStockInSum summarizeStockInByItem(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("itemId") String itemId) {

        List<StockInRecord> records = stockInRecordRepository.findByDateBetweenAndItemId(startDate, endDate, itemId);
        int sumStockInAmount = records.stream().mapToInt(StockInRecord::getStockInAmount).sum();
        double sumTotalPrice = records.stream().mapToDouble(StockInRecord::getTotalPrice).sum();

        if (!records.isEmpty()) {
            TempStockInSum tempSum = new TempStockInSum();
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
            tempSum.setSumStockInAmount(sumStockInAmount);
            tempSum.setSumTotalPrice(sumTotalPrice);
            return tempSum;
        }

        return null; // Or handle empty records case as per your requirement
    }

    @DeleteMapping("/stock-in-record/{id}")
    public ResponseEntity<?> deleteStockInRecord(@PathVariable String id) {
        try {
            stockInRecordRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
