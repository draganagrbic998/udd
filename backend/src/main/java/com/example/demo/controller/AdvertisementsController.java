package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Advertisement;
import com.example.demo.service.AdvertisementsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/advertisements")
public class AdvertisementsController {

	private final AdvertisementsService service;

	@GetMapping
	public ResponseEntity<List<Advertisement>> read() {
		return ResponseEntity.ok(service.read());
	}

}
