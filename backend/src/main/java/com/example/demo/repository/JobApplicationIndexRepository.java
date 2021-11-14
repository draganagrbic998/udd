package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.JobApplicationIndexUnit;

public interface JobApplicationIndexRepository extends ElasticsearchRepository<JobApplicationIndexUnit, String> {

}
