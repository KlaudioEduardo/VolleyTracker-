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

import com.volleytracker.tracker.models.Team;
import com.volleytracker.tracker.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/{id}")
	public ResponseEntity<Team> findById(@PathVariable Long id) {
		Team team = teamService.findById(id);
		if (team == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(team);
	}

	@PostMapping
	public ResponseEntity<Void> createTeam(@RequestBody Team team) {
		teamService.save(team);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Team>> getAllTeams() {
		return ResponseEntity.ok().body(teamService.findAllTeam());
	}

	@GetMapping("/search")
	public ResponseEntity<Team> findByName(@RequestParam String name) {
		Team teamFound = teamService.findByName(name);
		return ResponseEntity.ok().body(teamFound);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
		teamService.deleteById(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
		Team updated = teamService.update(id, teamDetails);
		return ResponseEntity.ok(updated);
	}

}
