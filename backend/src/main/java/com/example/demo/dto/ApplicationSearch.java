package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationSearch {

	private SimpleQuery query1;
	private String operation;
	private SimpleQuery query2;

}
