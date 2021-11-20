package com.example.demo.dto;

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

}
