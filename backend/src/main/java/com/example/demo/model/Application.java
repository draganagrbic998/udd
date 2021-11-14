package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// not blank validation

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String email;

	@NotNull
	private String address;

	@NotNull
	private String education;

	@NotNull
	private String cvLocation;

	@NotNull
	private String letterLocation;

}
