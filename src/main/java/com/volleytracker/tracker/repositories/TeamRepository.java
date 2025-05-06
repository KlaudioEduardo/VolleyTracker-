package com.volleytracker.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volleytracker.tracker.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
	Team findByName(String name);
	
	

}
