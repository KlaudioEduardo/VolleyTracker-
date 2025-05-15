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

	public List<Set> findAllSets() {
		return setRepository.findAll();
	}

	public Set findById(Long id) {
		return setRepository.findById(id).orElse(null);
	}

	public void save(Set set) {
		setRepository.save(set);
	}

	public void deleteById(Long id) {
		setRepository.deleteById(id);
	}

	public Set update(Long id, Set setDetails) {
		Set existing = findById(id);
		if (existing != null) {
			// exemplo: existing.setScore(setDetails.getScore()); // ajuste conforme
			// atributos
			return setRepository.save(existing);
		}
		return null;
	}

	public List<Set> findByMatchId(Long matchId) {
		return setRepository.findByMatchId(matchId);
	}

}
