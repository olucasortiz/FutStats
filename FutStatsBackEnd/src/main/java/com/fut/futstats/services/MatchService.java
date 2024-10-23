package com.fut.futstats.services;

import com.fut.futstats.entities.Match;
import com.fut.futstats.entities.Player;
import com.fut.futstats.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        Optional<Match> matchOptional = matchRepository.findById(id);
        if (matchOptional.isPresent()) {
            Match existingMatch = matchOptional.get();
            existingMatch.setHomeTeam(updatedMatch.getHomeTeam());
            existingMatch.setAwayTeam(updatedMatch.getAwayTeam());
            existingMatch.setMatchDate(updatedMatch.getMatchDate());
            existingMatch.setLocation(updatedMatch.getLocation());
            existingMatch.setHomeTeamScore(updatedMatch.getHomeTeamScore());
            existingMatch.setAwayTeamScore(updatedMatch.getAwayTeamScore());
            return matchRepository.save(existingMatch);
        } else {
            throw new NoSuchElementException("Match not found with id: " + id);
        }
    }

    public Match createMatch(Match newMatch) {
        return matchRepository.save(newMatch);
    }
}
