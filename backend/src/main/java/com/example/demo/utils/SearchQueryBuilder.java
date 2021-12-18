package com.example.demo.utils;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import com.example.demo.dto.ApplicationGeoSearch;
import com.example.demo.dto.ApplicationSearch;

public class SearchQueryBuilder {

	public static Query search(ApplicationSearch search) {
		BoolQueryBuilder query = QueryBuilders.boolQuery();
		search.getQueries().forEach(sq -> {
			QueryBuilder simpleQuery = !sq.getField().equals("educationLevel")
					? sq.getValue().startsWith("\"") && sq.getValue().endsWith("\"")
							? QueryBuilders.matchPhraseQuery(sq.getField(), sq.getValue())
							: QueryBuilders.matchQuery(sq.getField(), sq.getValue())
					: QueryBuilders.rangeQuery(sq.getField()).from(sq.getStartValue()).to(sq.getEndValue());
			if (search.getOperator().equalsIgnoreCase("and")) {
				query.must(simpleQuery);
			} else {
				query.should(simpleQuery);
			}
		});

		return new NativeSearchQueryBuilder().withQuery(query)
				.withHighlightFields(new HighlightBuilder.Field("cvText"), new HighlightBuilder.Field("letterText"))
				.build();
	}

	public static Query geoSearch(ApplicationGeoSearch search) {
		return new CriteriaQuery(new Criteria("location").within(new GeoPoint(search.getLat(), search.getLng()),
				search.getDistance() + search.getUnit()));
	}

}
