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
import org.springframework.web.bind.annotation.RestController;

import com.volleytracker.tracker.models.Play;
import com.volleytracker.tracker.services.PlayService;

@RestController
@RequestMapping("/api/plays")
public class PlayController {

	@Autowired
	private PlayService playService;

    @PostMapping
    public ResponseEntity<Play> create(@RequestBody Play play) {
        Play saved = playService.create(play);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Play> findById(@PathVariable Long id) {
        Play play = playService.getById(id);
        if (play == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(play);
    }

    @GetMapping
    public ResponseEntity<List<Play>> findAll() {
        return ResponseEntity.ok(playService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Play> update(@PathVariable Long id, @RequestBody Play play) {
        return ResponseEntity.ok(playService.update(id, play));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playService.delete(id);
        return ResponseEntity.noContent().build();
    }
}