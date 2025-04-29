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
    private Integer pointNumber; // Sequência do lance

    @ManyToOne
    private Player player; // Jogador que realizou a ação
    @ManyToOne
    private Team team; // Time da ação
    @ManyToOne
    private Set set; // Set em que ocorreu

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private boolean successful; // Ex: saque válido ou erro
}
