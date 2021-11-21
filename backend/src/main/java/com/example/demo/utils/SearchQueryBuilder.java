package com.example.demo.utils;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

import com.example.demo.dto.ApplicationGeoSearch;
import com.example.demo.dto.ApplicationSearch;

public class SearchQueryBuilder {

	public static CriteriaQuery buildQuery(ApplicationGeoSearch search) {
		return new CriteriaQuery(new Criteria("location").within(new GeoPoint(search.getLat(), search.getLng()),
				search.getDistance() + search.getUnit()));
	}

	public static QueryBuilder buildQuery(ApplicationSearch search) {
		QueryBuilder query1 = QueryBuilders.matchPhraseQuery(search.getQuery1().getField(),
				search.getQuery1().getValue());

		if (search.getOperation() == null || search.getQuery2() == null) {
			return query1;
		}

		QueryBuilder query2 = QueryBuilders.matchPhraseQuery(search.getQuery2().getField(),
				search.getQuery2().getValue());
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		if (search.getOperation().equalsIgnoreCase("and")) {
			boolQuery.must(query1);
			boolQuery.must(query2);
		} else if (search.getOperation().equalsIgnoreCase("or")) {
			boolQuery.should(query1);
			boolQuery.should(query2);
		} else if (search.getOperation().equalsIgnoreCase("not")) {
			boolQuery.must(query1);
			boolQuery.mustNot(query2);
		} else {
			return null;
		}
		return boolQuery;

	}

}
