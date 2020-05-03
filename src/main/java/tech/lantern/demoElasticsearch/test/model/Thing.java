package tech.lantern.demoElasticsearch.test.model;

import java.util.List;

import tech.lantern.demoElasticsearch.model.ThingReport;

public class Thing {

	
	
	private String thingId;
	private Country country;
	private String source;
	private String thingName;	

	private ThingReport thingReport;
	private List<StatusThing> timeLine;

	
	
	public List<StatusThing> getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(List<StatusThing> timeLine) {
		this.timeLine = timeLine;
	}
	public String getThingId() {
		return thingId;
	}
	public void setThingId(String thingId) {
		this.thingId = thingId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getThingName() {
		return thingName;
	}
	public void setThingName(String thingName) {
		this.thingName = thingName;
	}
	public ThingReport getThingReport() {
		return thingReport;
	}
	public void setThingReport(ThingReport thingReport) {
		this.thingReport = thingReport;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	

	
}
