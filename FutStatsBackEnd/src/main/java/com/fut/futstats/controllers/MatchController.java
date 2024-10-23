package com.fut.futstats.controllers;

import com.fut.futstats.entities.Match;
import com.fut.futstats.entities.Player;
import com.fut.futstats.services.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/match")
public class MatchController {


    MatchService matchServices;
    //requisições http

    public MatchController(MatchService matchServices) {
        this.matchServices = matchServices;
    }
    @GetMapping
    public ResponseEntity<List<Match>> getAllPlayers() {
        List<Match> matches = matchServices.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    @GetMapping("{id}")
    public ResponseEntity<Match> getPlayerById(@PathVariable Long id) {
        Match match = matchServices.getMatchById(id);
        if(match != null) {
            return ResponseEntity.ok(match);
        }
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match newMatch =matchServices.createMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(match);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        Match updtMatch = matchServices.updateMatch(id, match);
        return ResponseEntity.ok(updtMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Match> deleteMatch(@PathVariable Long id) {
        Match match = matchServices.getMatchById(id);
        if(match != null) {
            matchServices.deleteMatch(id);
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
