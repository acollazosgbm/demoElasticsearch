package tech.lantern.demoElasticsearch.sevice;

import java.util.List;

import tech.lantern.demoElasticsearch.model.Location;
import tech.lantern.demoElasticsearch.model.ThingReport;

public interface ThingFactoryI {

	List<String> LOCATIONS = List.of("9.9454601,-84.1972393", "3.3762037,-76.5279861", "9.9508149,-84.082032",
			"9.0103624,-79.4774889", "9.9387116,-84.1017712", "9.9619609,-84.2348599", "9.9449706,-84.2301131",
			"12.1218859,-86.2961419", "14.1010974,-87.21793", "13.695879,-89.2679125", "14.5824725,-90.5296612",
			"4.6731266,-74.0538725", "9.9454601,-84.1972393", "3.3762037,-76.5279861", "9.9508149,-84.082032",
			"9.9454601,-84.1972393", "3.3762037,-76.5279861", "9.9508149,-84.082032");

	List<String> THING_NAMES = List.of("TAPmaster", "CARBIDE 3D SHAPEOKO", "Sainsmart Genmitsu CNC 3018",
			"MYSWEETY CNC 3018-PRO", "Mill One V3 de Sienci", "Maker Made CNC Maslow", "NANO PMF80 de Next3D",
			"X-Carve de Inventables", "Ooznest WorkBee", "CNC Piranha FX");

	List<String> SOURCES = List.of("thing","thing","thing","thing","thing","thing", "external", "external", "Gateway", "Gateway");

	List<ThingReport> crateThingsByLocation(Location Location);

}
