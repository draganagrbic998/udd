package com.example.demo.model.index;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SimpleQuery {

	private String field;
	private String value;
	private boolean phrase;

}
