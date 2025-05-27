package com.volleytracker.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volleytracker.tracker.models.Play;
import com.volleytracker.tracker.models.Set;
import com.volleytracker.tracker.repositories.PlayRepository;
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
			return setRepository.save(existing);
		}
		return null;
	}

	public List<Set> findByMatchId(Long matchId) {
		return setRepository.findByMatchId(matchId);
	}
	
	private void validatePlay(Play play) {
		if(play.getPlayer() == null) {
			throw new IllegalArgumentException("O jogador é obrigatório.");
		}
		if(play.getTeam() == null) {
			throw new IllegalArgumentException("O time é obrigatório.");
		}
		if(play.getPointNumber() == null || play.getPointNumber() < 1) {
			throw new IllegalArgumentException("O número do ponto deve ser maior ou igual a 1.");
		}
		if(play.getActionType() == null) {
			throw new IllegalArgumentException("O tipo de ação é obrigatório.");
		}
		if(play.getSet() == null) {
			throw new IllegalArgumentException("O set é obrigatório.");
		} else {
			Optional<Set> set = setRepository.findById(play.getSet().getId());
			if (set.isEmpty() || set.get().isFinished()) {
				throw new IllegalArgumentException("O set deve existir e estar em andamento.");
			}
		}
	}
	

}


