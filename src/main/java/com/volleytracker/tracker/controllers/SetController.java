package com.volleytracker.tracker.controllers;

import com.volleytracker.tracker.models.Set;
import com.volleytracker.tracker.services.SetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sets")
public class SetController {

	@Autowired
	private SetService setService;

	@GetMapping("/{id}")
	public ResponseEntity<Set> getSetById(@PathVariable Long id) {
		Set set = setService.findById(id);
		if (set == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(set);
	}

	@PostMapping
	public ResponseEntity<Void> createSet(@RequestBody Set set) {
		setService.save(set);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Set> updateSet(@PathVariable Long id, @RequestBody Set setDetails) {
		Set updated = setService.update(id, setDetails);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
		Set set = setService.findById(id);
		if (set == null) {
			return ResponseEntity.notFound().build();
		}
		setService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/byMatch/{matchId}")
	public ResponseEntity<List<Set>> getSetsByMatch(@PathVariable Long matchId) {
		List<Set> sets = setService.findByMatchId(matchId);
		return ResponseEntity.ok(sets);
	}
}
