package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	// File.separatorChar
	private static final String RESOURCES_PATH = "src/main/resources/pdf";

	public String store(MultipartFile file) throws IOException {
		String fileLocation = RESOURCES_PATH + "/" + file.getOriginalFilename() + "_" + new Date().getTime() + ".pdf";
		FileOutputStream fout = new FileOutputStream(new File(fileLocation));
		fout.write(file.getBytes());
		fout.close();
		return fileLocation;
	}

}
