package tech.lantern.demoElasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import tech.lantern.demoElasticsearch.model.Thing;


@Repository
public interface ThingRepository extends ElasticsearchRepository<Thing, String> {

}
