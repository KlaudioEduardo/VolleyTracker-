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

    @ManyToOne
    private Team team;
}
