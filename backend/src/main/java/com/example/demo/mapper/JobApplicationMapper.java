package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.JobApplicationUpload;
import com.example.demo.model.JobApplication;
import com.example.demo.model.JobApplicationIndexUnit;

@Component
public class JobApplicationMapper {

	public JobApplication map(JobApplicationUpload upload) {
		JobApplication model = new JobApplication();
		model.setFirstName(upload.getFirstName());
		model.setLastName(upload.getLastName());
		model.setEmail(upload.getEmail());
		model.setAddress(upload.getAddress());
		model.setEducation(upload.getEducation());
		return model;
	}

	public JobApplicationIndexUnit mapToIndexUnit(JobApplicationUpload upload) {
		JobApplicationIndexUnit indexUnit = new JobApplicationIndexUnit();
		indexUnit.setFirstName(upload.getFirstName());
		indexUnit.setLastName(upload.getLastName());
		indexUnit.setEducation(upload.getEducation());
		return indexUnit;
	}

}
