package tech.lantern.demoElasticsearch.test.factories;

import java.util.ArrayList;
import java.util.List;

import tech.lantern.demoElasticsearch.model.Location;
import tech.lantern.demoElasticsearch.test.model.Country;
import tech.lantern.demoElasticsearch.test.model.Site;
import tech.lantern.demoElasticsearch.test.model.Thing;

public class SiteFactory {

	/*
	 * private static final List<String> LOCATIONS =
	 * List.of("3.3762037,-76.5279861,pais 1", "9.9508149,-84.082032,pais 2",
	 * "12.1218859,-86.2961419", "14.1010974,-87.21793", "13.695879,-89.2679125",
	 * "4.6731266,-74.0538725", "6.268844,-75.6664321", "0.0107294,-78.4556501",
	 * "-12.0459039,-77.0427928", "-15.7877669,-47.8948612",
	 * "-34.6167605,-58.3709316", "18.4743226,-69.8912537",
	 * "19.3910038,-99.2836954", "25.7824806,-80.2644778", "32.7581604,-96.7298588",
	 * "37.7577627,-122.4726193", "-33.4724228,-70.7699124",
	 * "40.6976637,-74.1197626", "40.4380638,-3.749576", "51.5287718,-0.2416793");
	 */

	private static final List<String> LOCATIONS = List.of("3.3762037,-76.5279861,Cali", "9.9508149,-84.082032,San José",
			"12.1218859,-86.2961419,Managua", "14.1010974,-87.21793,Tegucigalpa", "13.695879,-89.2679125,San Salvador",
			"4.6731266,-74.0538725,Bogotá", "6.268844,-75.6664321,Medellín", "0.0107294,-78.4556501,Quito",
			"-12.0459039,-77.0427928,Lima", "-15.7877669,-47.8948612,Basilia", "-34.6167605,-58.3709316,Buenos Aires",
			"18.4743226,-69.8912537,Santo Domingo", "19.3910038,-99.2836954, Ciudad de México");

	ThingFactory thingFactory = new ThingFactory();

	public List<Site> configSiteStage(int periodDuration) {

		List<Site> sites = getSitefromLocations();

		// Para cada sitio se adicionan sus maquinas
		for (Site site : sites) {
			List<Thing> things = thingFactory.configThings(periodDuration, site.getCountry());
			site.setThings(things);
		}
		return sites;
	}

	private List<Site> getSitefromLocations() {
		List<Site> sites = new ArrayList<Site>();

		List<Country> Countries = getAllCountries();

		Site site;
		for (Country country : Countries) {
			site = new Site();
			site.setCountry(country);
			sites.add(site);
		}

		return sites;
	}

	public List<Site> updateSites(List<Site> sites, int moment) {

		for (Site site : sites) {
			updateSite(site, moment);
		}
		return sites;
	}

	private void updateSite(Site site, int moment) {

		thingFactory.updateThings(site.getThings(), moment);
	}

	private List<Country> getAllCountries() {

		List<Country> countries = new ArrayList<Country>();
		String lat;
		String lon;
		String nameCountry;
		Location location;
		Country country;

		for (String locationInfo : LOCATIONS) {
			lat = locationInfo.split(",")[0];
			lon = locationInfo.split(",")[1];
			nameCountry = locationInfo.split(",")[2];

			location = new Location(lat, lon);
			country = new Country();
			country.setLocation(location);
			country.setNameCountry(nameCountry);

			countries.add(country);
		}
		return countries;
	}

}
