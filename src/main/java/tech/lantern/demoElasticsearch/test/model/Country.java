package tech.lantern.demoElasticsearch.test.model;

import tech.lantern.demoElasticsearch.model.Location;

public class Country {
	
	Location location;
	String nameCountry;

	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getNameCountry() {
		return nameCountry;
	}
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	
	

}
