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
import org.springframework.web.bind.annotation.RestController;

import com.volleytracker.tracker.models.Match;
import com.volleytracker.tracker.services.MatchService;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;

	@PostMapping
	public ResponseEntity<Match> createMatch(@RequestBody Match match) {
		return ResponseEntity.status(201).body(matchService.save(match));
	}

	@GetMapping
	public ResponseEntity<List<Match>> findAll() {
		return ResponseEntity.ok(matchService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Match> findById(@PathVariable Long id) {
		Match match = matchService.findById(id);
		if (match == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(matchService.findById(id));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
		Match updated = matchService.update(id, match);
		
		if (updated == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(updated);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
		Match match = matchService.findById(id);
		
		if (match == null) {
			return ResponseEntity.notFound().build();
		} else {
			matchService.deleteById(id);
			return ResponseEntity.ok().build();
		}

	}

}
