package tech.lantern.demoElasticsearch.test.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import tech.lantern.demoElasticsearch.model.ThingReport;
import tech.lantern.demoElasticsearch.test.model.Country;
import tech.lantern.demoElasticsearch.test.model.StatusThing;
import tech.lantern.demoElasticsearch.test.model.Thing;

public class ThingFactory {

	private List<String> THING_NAMES = List.of("TAPmaster", "CARBIDE 3D SHAPEOKO", "Sainsmart Genmitsu CNC 3018",
			"MYSWEETY CNC 3018-PRO", "Mill One V3 de Sienci", "Maker Made CNC Maslow", "NANO PMF80 de Next3D",
			"X-Carve de Inventables", "Ooznest WorkBee", "CNC Piranha FX");

	private List<String> SOURCES = List.of("thing", "external", "Gateway");
	
	ThingReportFactory thingReportFactory = new ThingReportFactory();

	// por cada maquina en el listado crea un thing

	public List<Thing> configThings(int periodDuration, Country country) {

		List<Thing> things = new ArrayList<Thing>();
		Thing thing;

		for (String thingName : THING_NAMES) {
			thing = configThing(periodDuration, country, thingName);
			things.add(thing);
		}
		return things;
	}

	
	public void updateThings(List<Thing> things, int moment) {

		for (Thing thing: things) {
			updateThing(thing, moment);
		}
	}
	
	private void updateThing(Thing thing, int moment){
		
		ThingReport thingReport = thing.getThingReport();
		thingReportFactory.updateThingReport(moment,thingReport,thing);
		
		
	}
	
	private Thing configThing(int periodDuration, Country country, String thingName) {
		Thing thing = new Thing();

		thing.setThingId(UUID.randomUUID().toString().substring(0, 7));
		thing.setThingName(thingName);
		
		thing.setCountry(country);
		
		String source = SOURCES.get(new Random().nextInt(SOURCES.size()));
		thing.setSource(source);
		
		StatusFactory statusFactory = new StatusFactory(periodDuration);
		List<StatusThing> timeLine = statusFactory.createStatusTimeLine();
		thing.setTimeLine(timeLine);
		
		ThingReport thingReport =  thingReportFactory.createThingReport(0, timeLine, thing);
		thing.setThingReport(thingReport);
		
		return thing;
	}
	
	
	
	
	
	
	

}
