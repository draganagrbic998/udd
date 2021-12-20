package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import com.example.demo.model.ApplicationIndexUnit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationSearchResult {

	private String adTitle;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String education;
	private Integer educationLevel;
	private String cvText;
	private String letterText;
	private String cvLocation;
	private String letterLocation;

	public ApplicationSearchResult(ApplicationIndexUnit indexUnit, Map<String, List<String>> highlights) {
		adTitle = indexUnit.getAdTitle();
		email = indexUnit.getEmail();
		address = indexUnit.getAddress();
		cvLocation = indexUnit.getCvLocation();
		letterLocation = indexUnit.getLetterLocation();

		firstName = highlights.getOrDefault("firstName", List.of(indexUnit.getFirstName())).get(0);
		lastName = highlights.getOrDefault("lastName", List.of(indexUnit.getLastName())).get(0);
		education = highlights.getOrDefault("education", List.of(indexUnit.getEducation())).get(0);
		educationLevel = indexUnit.getEducationLevel();
		cvText = highlights.getOrDefault("cvText", List.of("")).get(0);
		letterText = highlights.getOrDefault("letterText", List.of("")).get(0);
	}

}
