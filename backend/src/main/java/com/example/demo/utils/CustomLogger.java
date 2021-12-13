package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomLogger {

	private static final Logger LOGGER1 = LoggerFactory.getLogger("logger-1");
	private static final Logger LOGGER2 = LoggerFactory.getLogger("logger-2");

	public void storeApplicationFormAccessLog(Double lat, Double lng) {
		LOGGER1.info("lat: " + lat + ", lng: " + lng + " coordinates");
	}

	public void storeApplicationSubmitLog() {
		LOGGER2.info("Application subbmited");
	}

}
