package com.volleytracker.tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.volleytracker.tracker.models.Set;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
	
	List<Set> findByMatchId(Long matchId);


}
