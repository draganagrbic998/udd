package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "digitallibrary")
@Setting(settingPath = "settings.json")
public class ApplicationIndexUnit {

	@Field(type = FieldType.Text, index = true, store = true)
	private String firstName;

	@Field(type = FieldType.Text, index = true, store = true)
	private String lastName;

	@Field(type = FieldType.Text, index = true, store = true)
	private String education;

	@Field(type = FieldType.Text, index = true, store = true)
	private String letterText;

	@Id
	@Field(type = FieldType.Text, index = false, store = true)
	private String cvLocation;

	@Field(type = FieldType.Text, index = false, store = true)
	private String adTitle;

}
