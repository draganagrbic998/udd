package com.example.demo.controller;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApplicationGeoSearch;
import com.example.demo.dto.ApplicationSearch;
import com.example.demo.dto.ApplicationSearchResult;
import com.example.demo.dto.ApplicationUpload;
import com.example.demo.model.Application;
import com.example.demo.service.ApplicationSearchService;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.FileService;
import com.example.demo.utils.SearchQueryBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController {

	private final ApplicationService service;
	private final ApplicationSearchService searchService;

	@GetMapping("/cv/{fileName}")
	@PreAuthorize("hasAnyAuthority('tehnicko lice','hr lice', 'zaposleni u sluzbi nabavke', 'dobavljac')")
	public ResponseEntity<FileSystemResource> downloadCv(@PathVariable String fileName) {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/pdf")
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(new FileSystemResource(FileService.RESOURCES_PATH + fileName));
	}

	@GetMapping("/letter/{fileName}")
	@PreAuthorize("hasAnyAuthority('tehnicko lice','hr lice', 'zaposleni u sluzbi nabavke', 'dobavljac')")
	public ResponseEntity<FileSystemResource> downloadLetter(@PathVariable String fileName) {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/pdf")
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(new FileSystemResource(FileService.RESOURCES_PATH + fileName));
	}

	@PostMapping
	@PreAuthorize("hasAuthority('kandidat')")
	public ResponseEntity<Application> upload(@ModelAttribute ApplicationUpload upload) {
		try {
			return ResponseEntity.ok(service.upload(upload));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/search")
	@PreAuthorize("hasAnyAuthority('tehnicko lice','hr lice', 'zaposleni u sluzbi nabavke', 'dobavljac')")
	public ResponseEntity<List<ApplicationSearchResult>> search(@RequestBody ApplicationSearch search) {
		return ResponseEntity.ok(searchService.search(SearchQueryBuilder.build(search)));
	}

	@PostMapping("/geo_search")
	@PreAuthorize("hasAnyAuthority('tehnicko lice','hr lice', 'zaposleni u sluzbi nabavke', 'dobavljac')")
	public ResponseEntity<List<ApplicationSearchResult>> search(@RequestBody ApplicationGeoSearch search) {
		return ResponseEntity.ok(searchService.search(SearchQueryBuilder.build(search)));
	}

	@GetMapping("/form_access")
	@PreAuthorize("hasAuthority('kandidat')")
	public ResponseEntity<Void> formAccess() {
		service.announceFormAccess();
		return ResponseEntity.noContent().build();
	}

}
