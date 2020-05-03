package tech.lantern.demoElasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import tech.lantern.demoElasticsearch.model.ThingReport;


@Repository
public interface ThingRepository extends ElasticsearchRepository<ThingReport, String> {

}
