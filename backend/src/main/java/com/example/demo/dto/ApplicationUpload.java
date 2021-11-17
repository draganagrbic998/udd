package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationUpload {

	private Long advertisementId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String education;
	private MultipartFile cvFile;
	private MultipartFile letterFile;

}
