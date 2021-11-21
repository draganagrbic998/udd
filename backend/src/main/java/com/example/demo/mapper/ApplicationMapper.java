package com.example.demo.mapper;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ApplicationUpload;
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationIndexUnit;
import com.example.demo.repository.AdvertisementRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ApplicationMapper {

	private final AdvertisementRepository adRepo;

	public Application map(ApplicationUpload upload) {
		Application model = new Application();
		model.setAdvertisement(adRepo.findById(upload.getAdvertisementId()).get());
		model.setFirstName(upload.getFirstName());
		model.setLastName(upload.getLastName());
		model.setEmail(upload.getEmail());
		model.setAddress(upload.getAddress());
		model.setEducation(upload.getEducation());
		return model;
	}

	public ApplicationIndexUnit mapToIndexUnit(ApplicationUpload upload) {
		ApplicationIndexUnit indexUnit = new ApplicationIndexUnit();
		indexUnit.setFirstName(upload.getFirstName());
		indexUnit.setLastName(upload.getLastName());
		indexUnit.setEducation(upload.getEducation());
		indexUnit.setAdTitle(adRepo.findById(upload.getAdvertisementId()).get().getTitle());
		indexUnit.setLocation(new GeoPoint(upload.getLat(), upload.getLng()));
		return indexUnit;
	}

}
