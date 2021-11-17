package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Auth;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<String> login(@RequestBody Auth login) {
		return ResponseEntity.ok(userService.login(login.getEmail(), login.getPassword()));
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody Auth registration) {
		return ResponseEntity.ok(userService.register(registration.getEmail(), registration.getPassword()));
	}

}
