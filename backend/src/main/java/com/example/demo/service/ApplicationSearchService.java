package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApplicationSearchResult;
import com.example.demo.model.ApplicationIndexUnit;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationSearchService {

	private final ElasticsearchRestTemplate template;

	public List<ApplicationSearchResult> search(QueryBuilder query) {
		List<ApplicationSearchResult> result = new ArrayList<>();
		template.search(new NativeSearchQueryBuilder().withQuery(query).build(), ApplicationIndexUnit.class)
				.forEach(indexUnit -> result.add(new ApplicationSearchResult(indexUnit.getContent())));
		return result;
	}

	public List<ApplicationSearchResult> search(CriteriaQuery query) {
		List<ApplicationSearchResult> result = new ArrayList<>();
		template.search(query, ApplicationIndexUnit.class)
				.forEach(indexUnit -> result.add(new ApplicationSearchResult(indexUnit.getContent())));
		return result;
	}

}
