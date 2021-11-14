package com.example.demo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ApplicationUpload;
import com.example.demo.mapper.ApplicationMapper;
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationIndexUnit;
import com.example.demo.repository.ApplicationIndexRepository;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.utils.PDFHandler;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationService {

	private final ApplicationMapper mapper;
	private final ApplicationRepository repo;
	private final ApplicationIndexRepository indexRepo;
	private final FileService fileService;

	public Application create(ApplicationUpload upload) throws IOException {
		Application model = mapper.map(upload);
		ApplicationIndexUnit indexUnit = mapper.mapToIndexUnit(upload);

		String cvLocation = fileService.store(upload.getCvFile());
		String letterLocation = fileService.store(upload.getLetterFile());

		model.setCvLocation(cvLocation);
		model.setLetterLocation(letterLocation);

		indexUnit.setCvLocation(cvLocation); // is this needed?
		indexUnit.setLetterText(PDFHandler.parse(letterLocation).trim());
		// is the trim() necesary?
		// fileName when storing should be id (timestamp or something like that)

		indexRepo.save(indexUnit);
		return repo.save(model);
	}

}
