package com.example.demo.model.index;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SearchQuery {

	private SimpleQuery query1;
	private String operation;
	private SimpleQuery query2;

}
