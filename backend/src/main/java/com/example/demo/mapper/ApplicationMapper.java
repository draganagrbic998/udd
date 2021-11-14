package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ApplicationUpload;
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationIndexUnit;

@Component
public class ApplicationMapper {

	public Application map(ApplicationUpload upload) {
		Application model = new Application();
		model.setFirstName(upload.getFirstName());
		model.setLastName(upload.getLastName());
		model.setEmail(upload.getEmail());
		model.setAddress(upload.getAddress());
		model.setEducation(upload.getEducation());
		return model;
	}

	public ApplicationIndexUnit mapToIndexUnit(ApplicationUpload upload) {
		ApplicationIndexUnit indexUnit = new ApplicationIndexUnit();
		indexUnit.setFirstName(upload.getFirstName());
		indexUnit.setLastName(upload.getLastName());
		indexUnit.setEducation(upload.getEducation());
		return indexUnit;
	}

}
