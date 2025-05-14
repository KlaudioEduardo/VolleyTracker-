package com.volleytracker.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volleytracker.tracker.services.SetService;

@RestController

@RequestMapping("/sets")
public class SetController {
	
	@Autowired
	private SetService setService;
	
	

}
