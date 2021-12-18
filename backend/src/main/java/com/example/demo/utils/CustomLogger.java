package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger("logger");

	public void storeApplicationFormAccessLog(String city, Double lat, Double lng) {
		LOGGER.info("city: " + city + ", lat: " + lat + ", lng: " + lng);
	}

	public void storeApplicationSubmitLog() {
		LOGGER.info("Application subbmited");
	}

}
