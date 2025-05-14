package com.volleytracker.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.volleytracker.tracker.models.Play;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long>{

}
