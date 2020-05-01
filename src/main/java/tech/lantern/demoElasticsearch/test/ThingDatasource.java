package tech.lantern.demoElasticsearch.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import tech.lantern.demoElasticsearch.model.Thing;
import tech.lantern.demoElasticsearch.repository.ThingRepository;


@Component
public class ThingDatasource {

	@Autowired
	private ThingRepository deviceElasticsearchRepository;

	@EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
	public void saveDevicesInfo() {

		List<Thing> things = createThings();
		deviceElasticsearchRepository.saveAll(things);

	}

	private List<Thing> createThings() {

		List<Thing> things = new ArrayList<Thing>();
		return things;

	}

}
