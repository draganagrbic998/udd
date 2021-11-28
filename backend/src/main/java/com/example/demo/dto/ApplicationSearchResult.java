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

	private String firstName;
	private String lastName;
	private String education;
	private String letterText;
	private String adTitle;
	private String cvLocation;
	private String letterLocation;

	public ApplicationSearchResult(ApplicationIndexUnit indexUnit) {
		firstName = indexUnit.getFirstName();
		lastName = indexUnit.getLastName();
		education = indexUnit.getEducation();
		letterText = indexUnit.getLetterText();

		adTitle = indexUnit.getAdTitle();
		cvLocation = indexUnit.getCvLocation();
		letterLocation = indexUnit.getLetterLocation();
	}

	public ApplicationSearchResult(ApplicationIndexUnit indexUnit, Map<String, List<String>> highlights) {
		this(indexUnit);
		firstName = highlights.getOrDefault("firstName", List.of(firstName)).get(0);
		lastName = highlights.getOrDefault("lastName", List.of(lastName)).get(0);
		education = highlights.getOrDefault("education", List.of(education)).get(0);
		letterText = highlights.getOrDefault("letterText", List.of(letterText)).get(0);
	}

}
