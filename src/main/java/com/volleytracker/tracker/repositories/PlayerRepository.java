package com.volleytracker.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.volleytracker.tracker.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
