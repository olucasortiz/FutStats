package com.fut.futstats.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String date;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @ManyToMany
    @JoinTable(
            name = "match_player",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players;

    public Match() {
    }

    public Match(Set<Player> players, Team awayTeam, String date, Team homeTeam, String location, Long id) {
        this.players = players;
        this.awayTeam = awayTeam;
        this.date = date;
        this.homeTeam = homeTeam;
        this.location = location;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
