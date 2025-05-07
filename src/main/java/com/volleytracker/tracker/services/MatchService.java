package com.volleytracker.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volleytracker.tracker.models.Match;
import com.volleytracker.tracker.repositories.MatchRepository;

@Service
public class MatchService {
	
	@Autowired
	private MatchRepository matchRepository;

	    public Match save(Match match) {
	        return matchRepository.save(match);
	    }

	    public List<Match> findAll() {
	        return matchRepository.findAll();
	    }

	    public Match findById(Long id) {
	        return matchRepository.findById(id).orElse(null);
	    }

	    public void deleteById(Long id) {
	        matchRepository.deleteById(id);
	    }
	    
	    public Match update(Long id, Match updatedMatch) {
	        Match existing = findById(id);
	        if (existing != null) {
	            existing.setLocation(updatedMatch.getLocation());
	            existing.setStartTime(updatedMatch.getStartTime());
	            existing.setStatus(updatedMatch.getStatus());
	            existing.setTeamA(updatedMatch.getTeamA());
	            existing.setTeamB(updatedMatch.getTeamB());
	            return matchRepository.save(existing);
	        }
	        return null;
	    }
	    
	    
	
	

}
