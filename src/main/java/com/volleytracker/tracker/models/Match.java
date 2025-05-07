package com.volleytracker.tracker.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.config.YamlProcessor.MatchStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDateTime startTime;
	private String location;

	@Enumerated(EnumType.STRING)
	private MatchStatus status;

	@ManyToOne
	@JoinColumn(name = "team_a_id")
	private Team teamA;

	@ManyToOne
	@JoinColumn(name = "team_b_id")
	private Team teamB;

	@OneToMany(mappedBy = "match")
	private List<Set> sets;

	public Match(Long id, LocalDateTime startTime, String location, MatchStatus status, Team teamA, Team teamB,
			List<Set> sets) {
		this.id = id;
		this.startTime = startTime;
		this.location = location;
		this.status = status;
		this.teamA = teamA;
		this.teamB = teamB;
		this.sets = sets;
	}
	
	public Match() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public MatchStatus getStatus() {
		return status;
	}

	public void setStatus(MatchStatus status) {
		this.status = status;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public List<Set> getSets() {
		return sets;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
	
	
		
	}
