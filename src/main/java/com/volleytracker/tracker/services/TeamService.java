package com.volleytracker.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.volleytracker.tracker.models.Team;
import com.volleytracker.tracker.repositories.TeamRepository;

@Service
public class TeamService {
	
	private TeamRepository teamRepository;
	
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	public void save(Team team) {
		teamRepository.save(team);
	}
	
	public Team findById(Long id) {
	    return teamRepository.findById(id).orElse(null);
	}
	
	public List<Team> findAllTeam() {
		return teamRepository.findAll();
	}
	
	public void deleteById(Long id) {
		teamRepository.deleteById(id);
	}
	
	public Team findByName(String name) {
		return teamRepository.findByName(name);
	}

	public Team update(Long id, Team teamDetails) {
		return null;
	}
	
	
	
	

}
