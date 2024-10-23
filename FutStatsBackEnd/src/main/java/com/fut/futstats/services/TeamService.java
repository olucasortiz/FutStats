package com.fut.futstats.services;

import com.fut.futstats.entities.Team;
import com.fut.futstats.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team existingTeam = teamOptional.get();
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setCity(updatedTeam.getCity());
            existingTeam.setCountry(updatedTeam.getCountry());
            return teamRepository.save(existingTeam);
        } else {
            throw new NoSuchElementException("Team not found with id: " + id);
        }
    }
}
