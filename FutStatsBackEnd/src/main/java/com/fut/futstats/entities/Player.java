package com.fut.futstats.entities;

import com.fut.futstats.entities.Match;
import com.fut.futstats.entities.Team;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private int number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToMany(mappedBy = "players")
    private Set<Match> matches;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }
}
