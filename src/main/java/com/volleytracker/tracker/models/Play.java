package com.volleytracker.tracker.models;

import com.volleytracker.tracker.enums.ActionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Play {
	
    @Id 
    @GeneratedValue
    private Long id;
    private Integer pointNumber; // sequência do lance

    @ManyToOne
    private Player player; // jogador que realizou a ação
    @ManyToOne
    private Team team; // time da ação
    @ManyToOne
    private Set set; // set em que ocorreu

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private boolean successful; // válido ou erro

    
	public Play(Long id, Integer pointNumber, Player player, Team team, Set set, ActionType actionType,
			boolean successful) {
		this.id = id;
		this.pointNumber = pointNumber;
		this.player = player;
		this.team = team;
		this.set = set;
		this.actionType = actionType;
		this.successful = successful;
	}
	
	public Play() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPointNumber() {
		return pointNumber;
	}

	public void setPointNumber(Integer pointNumber) {
		this.pointNumber = pointNumber;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
    
    
}
