package com.example.demo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.JobApplicationUpload;
import com.example.demo.mapper.JobApplicationMapper;
import com.example.demo.model.JobApplication;
import com.example.demo.model.JobApplicationIndexUnit;
import com.example.demo.repository.JobApplicationIndexRepository;
import com.example.demo.repository.JobApplicationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobApplicationService {

	private final JobApplicationMapper mapper;
	private final JobApplicationRepository repo;
	private final JobApplicationIndexRepository indexRepo;
	private final FileService fileService;

	public JobApplication create(JobApplicationUpload upload) throws IOException {
		JobApplication model = mapper.map(upload);
		JobApplicationIndexUnit indexUnit = mapper.mapToIndexUnit(upload);

		String cvLocation = fileService.store(upload.getCvFile());
		String letterLocation = fileService.store(upload.getLetterFile());

		model.setCvLocation(cvLocation);
		model.setLetterLocation(letterLocation);

		indexUnit.setCvLocation(cvLocation); // is this needed?
		indexUnit.setLetterLocation(letterLocation); // is this needed?
		// fileName when storing should be id (timestamp or something like that)

		indexRepo.index(indexUnit);
		return repo.save(model);
	}

}
