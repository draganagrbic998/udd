package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SimpleQuery {

	@NotBlank(message = "Field cannot be blank")
	private String field;
	private String value;
	private Integer startValue;
	private Integer endValue;

}
