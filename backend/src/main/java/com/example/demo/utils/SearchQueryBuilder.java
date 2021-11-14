package com.example.demo.utils;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

public class SearchQueryBuilder {

	public static QueryBuilder buildQuery(SearchQuery searchQuery) {
		QueryBuilder query1 = searchQuery.getQuery1().isPhrase()
				? QueryBuilders.matchPhraseQuery(searchQuery.getQuery1().getField(),
						searchQuery.getQuery1().getValue().toLowerCase())
				: QueryBuilders.termQuery(searchQuery.getQuery1().getField(),
						searchQuery.getQuery1().getValue().toLowerCase());

		if (searchQuery.getOperation() == null || searchQuery.getQuery2() == null) {
			return query1;
		}

		QueryBuilder query2 = searchQuery.getQuery2().isPhrase()
				? QueryBuilders.matchPhraseQuery(searchQuery.getQuery2().getField(),
						searchQuery.getQuery2().getValue().toLowerCase())
				: QueryBuilders.termQuery(searchQuery.getQuery2().getField(),
						searchQuery.getQuery2().getValue().toLowerCase());
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		if (searchQuery.getOperation().equalsIgnoreCase("and")) {
			boolQuery.must(query1);
			boolQuery.must(query2);
		} else if (searchQuery.getOperation().equalsIgnoreCase("or")) {
			boolQuery.should(query1);
			boolQuery.should(query2);
		} else if (searchQuery.getOperation().equalsIgnoreCase("not")) {
			boolQuery.must(query1);
			boolQuery.mustNot(query2);
		} else {
			return null;
		}
		return boolQuery;

	}

}
