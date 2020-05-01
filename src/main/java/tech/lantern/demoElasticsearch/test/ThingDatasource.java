package tech.lantern.demoElasticsearch.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import tech.lantern.demoElasticsearch.model.Thing;
import tech.lantern.demoElasticsearch.repository.ThingRepository;
import tech.lantern.demoElasticsearch.sevice.ThingFactory;


@Component
public class ThingDatasource {
	
	@Autowired
	private ThingRepository deviceElasticsearchRepository;
	
	@Autowired
	private ThingFactory thingFactory;
	
	List<String> LOCATIONS = List.of("9.9454601,-84.1972393", "3.3762037,-76.5279861", "9.9508149,-84.082032",
			"9.0103624,-79.4774889", "9.9387116,-84.1017712", "9.9619609,-84.2348599", "9.9449706,-84.2301131",
			"12.1218859,-86.2961419", "14.1010974,-87.21793", "13.695879,-89.2679125", "14.5824725,-90.5296612",
			"4.6731266,-74.0538725", "9.9454601,-84.1972393", "3.3762037,-76.5279861", "9.9508149,-84.082032",
			"9.9454601,-84.1972393", "3.3762037,-76.5279861", "9.9508149,-84.082032");

	@EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
	public void saveDevicesInfo() {

		List<Thing> things = new ArrayList<Thing>();
		
		for(String location:LOCATIONS) {
			things = thingFactory.crateThingsByLocation(location);
			deviceElasticsearchRepository.saveAll(things);
		}
		
	}

}
