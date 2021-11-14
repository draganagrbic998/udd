package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApplicationSearchResult;
import com.example.demo.model.ApplicationIndexUnit;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationSearchService {

	private final ElasticsearchTemplate template;

	public List<ApplicationSearchResult> search(QueryBuilder query) {
		// add hightlight

		List<ApplicationSearchResult> result = new ArrayList<>();
		if (query == null) {
			return result;
		}
		template.queryForList(new NativeSearchQueryBuilder().withQuery(query).build(), ApplicationIndexUnit.class)
				.forEach(indexUnit -> result.add(new ApplicationSearchResult(indexUnit)));
		return result;
	}

}
