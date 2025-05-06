package com.volleytracker.tracker.models;

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
}
