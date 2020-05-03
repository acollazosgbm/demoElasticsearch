package tech.lantern.demoElasticsearch.test.model;

import java.util.List;

public class Site {

	
	private Country country;
	private List<Thing> things;
	
	
	public List<Thing> getThings() {
		return things;
	}
	public void setThings(List<Thing> things) {
		this.things = things;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	
	
}
