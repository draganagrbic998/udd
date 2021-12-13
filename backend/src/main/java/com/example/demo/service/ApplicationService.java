package com.example.demo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ApplicationUpload;
import com.example.demo.mapper.ApplicationMapper;
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationIndexUnit;
import com.example.demo.repository.ApplicationIndexRepository;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.utils.CustomLogger;
import com.example.demo.utils.PDFHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationService {

	private final ApplicationRepository repo;
	private final ApplicationIndexRepository indexRepo;
	private final ApplicationMapper mapper;
	private final FileService fileService;
	private final CustomLogger logger;
	private final UserService userService;

	public Application upload(ApplicationUpload upload) throws IOException {
		logger.storeApplicationSubmitLog();

		Application model = mapper.map(upload);
		ApplicationIndexUnit indexUnit = mapper.mapToIndexUnit(upload);

		String cvLocation = fileService.store(upload.getCvFile());
		String letterLocation = fileService.store(upload.getLetterFile());

		model.setCvLocation(cvLocation);
		model.setLetterLocation(letterLocation);

		indexUnit.setCvLocation(cvLocation);
		indexUnit.setLetterLocation(letterLocation);
		indexUnit.setCvText(PDFHandler.parse(cvLocation));
		indexUnit.setLetterText(PDFHandler.parse(letterLocation));

		indexRepo.save(indexUnit);
		return repo.save(model);
	}

	public void announceFormAccess() {
		logger.storeApplicationFormAccessLog(userService.getLoggedInUser().getLat(),
				userService.getLoggedInUser().getLng());
	}

}
