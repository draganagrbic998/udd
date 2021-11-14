package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JobApplicationUpload;
import com.example.demo.model.JobApplication;
import com.example.demo.service.JobApplicationService;

import lombok.AllArgsConstructor;

@RestController("job_application")
@AllArgsConstructor
public class JobApplicationController {

	private final JobApplicationService service;

	@PostMapping
	public ResponseEntity<JobApplication> create(@ModelAttribute JobApplicationUpload upload) {
		try {
			return ResponseEntity.ok(service.create(upload));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
