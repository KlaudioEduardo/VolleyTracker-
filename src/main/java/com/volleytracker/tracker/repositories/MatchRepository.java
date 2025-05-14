package com.volleytracker.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.volleytracker.tracker.models.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
