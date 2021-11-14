package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "index")
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

}
