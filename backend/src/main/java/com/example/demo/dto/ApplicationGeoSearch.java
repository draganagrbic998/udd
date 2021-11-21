package com.example.demo.dto;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationGeoSearch {

	private GeoPoint location;
	private double distance;
	private String unit;

}
