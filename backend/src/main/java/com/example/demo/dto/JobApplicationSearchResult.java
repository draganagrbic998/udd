package com.example.demo.dto;

import com.example.demo.model.JobApplicationIndexUnit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class JobApplicationSearchResult {

	private String firstName;
	private String lastName;
	private String education;
	private String cvLocation;
	private String hightlight;

	public JobApplicationSearchResult(JobApplicationIndexUnit indexUnit) {
		firstName = indexUnit.getFirstName();
		lastName = indexUnit.getLastName();
		education = indexUnit.getEducation();
		cvLocation = indexUnit.getCvLocation();
		hightlight = indexUnit.getLetterText();
	}

}
