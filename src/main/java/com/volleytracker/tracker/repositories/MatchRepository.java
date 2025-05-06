package com.volleytracker.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.volleytracker.tracker.models.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, ID> {

}
