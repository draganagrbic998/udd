package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JobApplicationSearchResult;
import com.example.demo.dto.JobApplicationUpload;
import com.example.demo.model.JobApplication;
import com.example.demo.model.index.JobApplicationIndexSearch;
import com.example.demo.model.index.SearchQuery;
import com.example.demo.model.index.SearchQueryBuilder;
import com.example.demo.service.JobApplicationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/job_applications")
public class JobApplicationController {

	private final JobApplicationService service;
	private final JobApplicationIndexSearch indexSearch;

	@PostMapping
	public ResponseEntity<JobApplication> create(@ModelAttribute JobApplicationUpload upload) {
		try {
			return ResponseEntity.ok(service.create(upload));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(path = "/search", consumes = "application/json")
	public ResponseEntity<List<JobApplicationSearchResult>> search(@RequestBody SearchQuery searchQuery) {
		return ResponseEntity.ok(indexSearch.search(SearchQueryBuilder.buildQuery(searchQuery)));
	}
}
