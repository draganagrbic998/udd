package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.JobApplicationIndexUnit;

@Repository
public interface JobApplicationIndexRepository extends ElasticsearchRepository<JobApplicationIndexUnit, String> {

}
