package com.fut.futstats.services;

import com.fut.futstats.entities.Statistics;
import com.fut.futstats.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StatisticsService {

    @Autowired
    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public Statistics getStatisticsById(Long id) {
        return statisticsRepository.findById(id).orElse(null);
    }

    public Statistics saveStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public void deleteStatistics(Long id) {
        statisticsRepository.deleteById(id);
    }

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Statistics updateStatistics(Long id, Statistics updatedStatistics) {
        Optional<Statistics> statisticsOptional = statisticsRepository.findById(id);
        if (statisticsOptional.isPresent()) {
            Statistics existingStatistics = statisticsOptional.get();
            existingStatistics.setPlayer(updatedStatistics.getPlayer());
            existingStatistics.setMatch(updatedStatistics.getMatch());
            existingStatistics.setMinutesPlayed(updatedStatistics.getMinutesPlayed());
            existingStatistics.setGoalsScored(updatedStatistics.getGoalsScored());
            existingStatistics.setAssists(updatedStatistics.getAssists());
            existingStatistics.setYellowCards(updatedStatistics.getYellowCards());
            existingStatistics.setRedCards(updatedStatistics.getRedCards());
            return statisticsRepository.save(existingStatistics);
        } else {
            throw new NoSuchElementException("Statistics not found with id: " + id);
        }
    }
}
