package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApplicationSearchResult;
import com.example.demo.dto.ApplicationUpload;
import com.example.demo.model.Application;
import com.example.demo.service.ApplicationSearchService;
import com.example.demo.service.ApplicationService;
import com.example.demo.utils.SearchQuery;
import com.example.demo.utils.SearchQueryBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController {

	private final ApplicationService service;
	private final ApplicationSearchService searchService;

	@PostMapping
	@PreAuthorize("hasAuthority('kandidat')")
	public ResponseEntity<Application> create(@ModelAttribute ApplicationUpload upload) {
		try {
			return ResponseEntity.ok(service.create(upload));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(path = "/search", consumes = "application/json")
	@PreAuthorize("hasAnyAuthority('tehnicko lice','hr lice', 'zaposleni u sluzbi nabavke', 'dobavljac')")
	public ResponseEntity<List<ApplicationSearchResult>> search(@RequestBody SearchQuery searchQuery) {
		return ResponseEntity.ok(searchService.search(SearchQueryBuilder.buildQuery(searchQuery)));
	}
}
