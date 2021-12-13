package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
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
		return template
				.search(new NativeSearchQueryBuilder().withQuery(query)
						.withHighlightFields(new HighlightBuilder.Field("firstName"),
								new HighlightBuilder.Field("lastName"), new HighlightBuilder.Field("education"),
								new HighlightBuilder.Field("cvText"), new HighlightBuilder.Field("letterText"))
						.build(), ApplicationIndexUnit.class)
				.stream()
				.map(res -> new ApplicationSearchResult(res.getContent(), res.getHighlightFields()))
				.collect(Collectors.toList());
	}

	public List<ApplicationSearchResult> search(CriteriaQuery query) {
		return template.search(query, ApplicationIndexUnit.class).stream()
				.map(res -> new ApplicationSearchResult(res.getContent())).collect(Collectors.toList());
	}

}
