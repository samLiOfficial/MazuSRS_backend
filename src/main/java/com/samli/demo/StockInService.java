// This is a service class named 'StockInService' used for performing operations related to stock-in records.
// It is annotated with '@Service', indicating that it is a Spring service component.

package com.samli.demo;

import com.samli.demo.StockInRecord;
import com.samli.demo.StockInRecordRepository;
import com.samli.demo.StockInStatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockInService {

    // Autowired annotation is used to inject the 'StockInRecordRepository' bean into this service.
    @Autowired
    private StockInRecordRepository stockInRecordRepository;

    // This method 'calculateStockInStatistics' calculates stock-in statistics within a given date range.
    // It takes 'startDate' and 'endDate' as input parameters, representing the date range to consider.
    public List<StockInStatisticsDTO> calculateStockInStatistics(LocalDate startDate, LocalDate endDate) {
        // Fetching stock-in records within the specified date range.
        List<StockInRecord> records = stockInRecordRepository.findByDateBetween(startDate, endDate);

        // Assuming 'StockInRecord' has fields 'quantity' and 'itemId', this block of code calculates
        // the total stock-in quantity for each unique 'itemId' in the fetched records.
        Map<String, Integer> totalByItem = records.stream()
                .collect(Collectors.groupingBy(StockInRecord::getItemId,
                        Collectors.summingInt(StockInRecord::getStockInAmount)));

        // Converting the calculated totals into a list of 'StockInStatisticsDTO' objects,
        // which include 'itemId' and the corresponding total quantity.
        return totalByItem.entrySet().stream()
                .map(entry -> new StockInStatisticsDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
