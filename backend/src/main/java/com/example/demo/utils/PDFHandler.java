package com.example.demo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFHandler {

	public static String parse(String fileLocation) throws FileNotFoundException, IOException {
		PDFParser parser = new PDFParser(new RandomAccessFile(new File(fileLocation), "r"));
		parser.parse();
		PDFTextStripper stripper = new PDFTextStripper();
		return stripper.getText(parser.getPDDocument());
	}

}
