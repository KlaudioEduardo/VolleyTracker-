package com.volleytracker.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volleytracker.tracker.models.Player;
import com.volleytracker.tracker.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping
	public ResponseEntity<Void> createPlayer(@RequestBody Player player) {
		playerService.save(player);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/players")
	public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
		Player player = playerService.findById(id);
		if (player == null) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(player);
		}
	}

	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers(@PathVariable Player player) {
		return ResponseEntity.ok(playerService.findAll());

	}

	@GetMapping("/search")
	public ResponseEntity<Player> getPlayerByName(@RequestParam String name) {
		Player player = playerService.findByName(name);
		if (player == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(player);
	}

	@GetMapping("/byTeam")
	public ResponseEntity<List<Player>> getPlayersByTeam(@RequestParam Long teamId) {
		return ResponseEntity.ok(playerService.findByTeamId(teamId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) {
		Player updatedPlayer = playerService.update(id, playerDetails);
		if (updatedPlayer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedPlayer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
		Player player = playerService.findById(id);
		if (player == null) {
			return ResponseEntity.notFound().build();
		}
		playerService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
