package com.fut.futstats.services;

import com.fut.futstats.entities.Player;
import com.fut.futstats.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerById(Long id){
        return playerRepository.findById(id).orElse(null);
    }
    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if(playerOptional.isPresent()){
            Player existingPlayer = playerOptional.get();
            //agora vai atualizar os campos com os novos dados
            existingPlayer.setBirthDate(updatedPlayer.getBirthDate());
            existingPlayer.setLastName(updatedPlayer.getLastName());
            existingPlayer.setFirstName(updatedPlayer.getFirstName());
            existingPlayer.setNationality(updatedPlayer.getNationality());
            existingPlayer.setTeam(updatedPlayer.getTeam());
            existingPlayer.setPosition(updatedPlayer.getPosition());

            return playerRepository.save(existingPlayer);
        }
        else throw new NoSuchElementException("Player not found with id: "+ id);
    }
}
