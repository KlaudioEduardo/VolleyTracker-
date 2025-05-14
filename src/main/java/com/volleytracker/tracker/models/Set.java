package com.volleytracker.tracker.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Set {
    @Id 
    @GeneratedValue
    private Long id;
    private Integer setNumber; // 1º set, 2º set, etc.
    private Integer teamAScore;
    private Integer teamBScore;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @OneToMany(mappedBy = "set")
    private List<Play> plays;
    

	public Set(Long id, Integer setNumber, Integer teamAScore, Integer teamBScore, Match match, List<Play> plays) {
		
		this.id = id;
		this.setNumber = setNumber;
		this.teamAScore = teamAScore;
		this.teamBScore = teamBScore;
		this.match = match;
		this.plays = plays;
	}
	
	public Set() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSetNumber() {
		return setNumber;
	}

	public void setSetNumber(Integer setNumber) {
		this.setNumber = setNumber;
	}

	public Integer getTeamAScore() {
		return teamAScore;
	}

	public void setTeamAScore(Integer teamAScore) {
		this.teamAScore = teamAScore;
	}

	public Integer getTeamBScore() {
		return teamBScore;
	}

	public void setTeamBScore(Integer teamBScore) {
		this.teamBScore = teamBScore;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<Play> getPlays() {
		return plays;
	}

	public void setPlays(List<Play> plays) {
		this.plays = plays;
	}
    
}
