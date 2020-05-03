package tech.lantern.demoElasticsearch.test.model;

public class StatusThing {

	private String nameStatus;
	private int timeIni;
	private int timeFin;
	
	public StatusThing(int timeIni, int timeFin,String nameStatus) {
		this.timeIni = timeIni;
		this.timeFin = timeFin;
		this.nameStatus = nameStatus;
		
	}
	
	public int getTimeIni() {
		return timeIni;
	}
	public int getTimeFin() {
		return timeFin;
	}
	public String getName() {
		return nameStatus;
	}
	
}
