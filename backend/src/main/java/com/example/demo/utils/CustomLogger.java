package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomLogger {

	private static final Logger LOGGER1 = LoggerFactory.getLogger("logger-1");
	private static final Logger LOGGER2 = LoggerFactory.getLogger("logger-2");

	public void storeApplicationFormAccessLog(String city, Double lat, Double lng) {
		LOGGER1.info("city: " + city + ", lat: " + lat + ", lng: " + lng);
	}

	public void storeApplicationSubmitLog() {
		LOGGER2.info("Application subbmited");
	}

}
