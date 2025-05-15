package com.volleytracker.tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Player {
    @Id 
    @GeneratedValue
    private Long id;
    private String name;
    private Integer number; 
    private String position;
    

    @ManyToOne
    private Team team;

	
	
	public Player(Long id, String name, Integer number, String position, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.position = position;
		this.team = team;
	}

	public Player() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
    
    
}
