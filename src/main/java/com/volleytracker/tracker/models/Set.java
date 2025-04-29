package com.volleytracker.tracker.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Match match;

    @OneToMany(mappedBy = "set")
    private List<Play> plays;
}
