package com.volleytracker.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volleytracker.tracker.models.Player;
import com.volleytracker.tracker.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player findById(Long id) {
		return playerRepository.findById(id).orElse(null);
	}

	public List<Player> findAllPlayer() {
		return playerRepository.findAll();
	}

	public void save(Player player) {
		playerRepository.save(player);
	}

	public void deleteById(Long id) {
		playerRepository.deleteById(id);
	}

	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	public Player findByName(String name) {
		return playerRepository.findByName(name);
	}

	public Player update(Long id, Player playerDetails) {
		Player player = findById(id);
		if (player == null)
			return null;

		player.setName(playerDetails.getName());
		player.setPosition(playerDetails.getPosition());
		player.setNumber(playerDetails.getNumber());
		player.setTeam(playerDetails.getTeam());

		return playerRepository.save(player);
	}
	
	public List<Player> findByTeamId(Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }

}
