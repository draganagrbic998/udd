package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationGeoSearch {

	private double lat;
	private double lng;
	private double distance;
	private String unit;

}
