package com.fut.futstats.controllers;

import com.fut.futstats.entities.Statistics;
import com.fut.futstats.services.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public ResponseEntity<List<Statistics>> getAllStatistics() {
        List<Statistics> statisticsList = statisticsService.getAllStatistics();
        return ResponseEntity.ok(statisticsList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Statistics> getStatisticsById(@PathVariable Long id) {
        Statistics statistics = statisticsService.getStatisticsById(id);
        if (statistics != null) {
            return ResponseEntity.ok(statistics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Statistics> createStatistics(@RequestBody Statistics statistics) {
        Statistics newStatistics = statisticsService.saveStatistics(statistics);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStatistics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistics> updateStatistics(@PathVariable Long id, @RequestBody Statistics statistics) {
        Statistics updatedStatistics = statisticsService.updateStatistics(id, statistics);
        return ResponseEntity.ok(updatedStatistics);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Statistics> deleteStatistics(@PathVariable Long id) {
        Statistics statistics = statisticsService.getStatisticsById(id);
        if (statistics != null) {
            statisticsService.deleteStatistics(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
