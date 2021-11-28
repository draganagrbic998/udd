package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

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
		List<ApplicationSearchResult> result = new ArrayList<>();
		template.search(new NativeSearchQueryBuilder().withQuery(query)
				.withHighlightFields(new HighlightBuilder.Field("firstName"), new HighlightBuilder.Field("lastName"),
						new HighlightBuilder.Field("education"), new HighlightBuilder.Field("letterText"))
				.build(), ApplicationIndexUnit.class)
				.forEach(searchHit -> result
						.add(new ApplicationSearchResult(searchHit.getContent(), searchHit.getHighlightFields())));
		return result;
	}

	public List<ApplicationSearchResult> search(CriteriaQuery query) {
		List<ApplicationSearchResult> result = new ArrayList<>();
		template.search(query, ApplicationIndexUnit.class)
				.forEach(indexUnit -> result.add(new ApplicationSearchResult(indexUnit.getContent())));
		return result;
	}

}
