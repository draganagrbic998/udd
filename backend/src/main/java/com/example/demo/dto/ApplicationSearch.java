package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationSearch {

	public enum Operator {
		AND, OR
	}

	@NotNull(message = "Queries cannot be null")
	private List<SimpleQuery> queries;

	@NotNull(message = "Operator cannot be null")
	private Operator operator;

}
