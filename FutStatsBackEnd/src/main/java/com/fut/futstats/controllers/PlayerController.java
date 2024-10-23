package com.fut.futstats.controllers;


import com.fut.futstats.entities.Player;
import com.fut.futstats.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {


    PlayerService playerServices;
    //requisições http

    public PlayerController(PlayerService playerServices) {
        this.playerServices = playerServices;
    }
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerServices.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerServices.getPlayerById(id);
        if(player != null) {
            return ResponseEntity.ok(player);
        }
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player newPlayer =playerServices.createPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        Player updtPlayer = playerServices.updatePlayer(id,player);
        return ResponseEntity.ok(updtPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable Long id) {
        Player player = playerServices.getPlayerById(id);
        if(player != null) {
            playerServices.deletePlayer(id);
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
