package com.volleytracker.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volleytracker.tracker.models.Set;
import com.volleytracker.tracker.repositories.SetRepository;

@Service
public class SetService {

	@Autowired
	private SetRepository setRepository;

	public Set save(Set set) {
		return setRepository.save(set);
	}

	public List<Set> findByMatchId(Long matchId) {
	    return setRepository.findByMatchId(matchId);
	}

	public void deleteById(Long id) {
		setRepository.deleteById(id);
	}
	
	
	
	

}
