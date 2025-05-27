package com.volleytracker.tracker.services;

import com.volleytracker.tracker.models.Play;
import com.volleytracker.tracker.repositories.PlayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayService {

	private final PlayRepository playRepository;

	public Play create(Play play) {
		return playRepository.save(play);
	}

	public Play getById(Long id) {
		return playRepository.findById(id).orElse(null);
	}

	public List<Play> getAll() {
		return playRepository.findAll();
	}

	public Play update(Long id, Play updatedPlay) {
		Play existingPlay = getById(id);
		if (existingPlay == null) {
			return null;
		}

		existingPlay.setPointNumber(updatedPlay.getPointNumber());
		existingPlay.setPlayer(updatedPlay.getPlayer());
		existingPlay.setTeam(updatedPlay.getTeam());
		existingPlay.setSet(updatedPlay.getSet());
		existingPlay.setActionType(updatedPlay.getActionType());
		existingPlay.setSuccessful(updatedPlay.isSuccessful());

		return playRepository.save(existingPlay);
	}

	public void delete(Long id) {
		playRepository.deleteById(id);
	}
}
