package com.example.demo.model.index;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JobApplicationSearchResult;
import com.example.demo.model.JobApplicationIndexUnit;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobApplicationIndexSearch {

	private final ElasticsearchTemplate template;

	public List<JobApplicationSearchResult> search(QueryBuilder query) {
		// add hightlight

		List<JobApplicationSearchResult> result = new ArrayList<>();
		if (query == null) {
			return result;
		}
		template.queryForList(new NativeSearchQueryBuilder().withQuery(query).build(), JobApplicationIndexUnit.class)
				.forEach(indexUnit -> result.add(new JobApplicationSearchResult(indexUnit)));
		return result;
	}

}
