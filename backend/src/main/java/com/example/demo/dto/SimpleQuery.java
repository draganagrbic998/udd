package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SimpleQuery {

	private String field;
	private String value;
	private String startValue;
	private String endValue;

}
