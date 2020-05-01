package tech.lantern.demoElasticsearch.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = "hunt-r", type = "thing")
public class Thing {
	
	@Id
	private String id;
	
	private String thingId;
	
	
	private String location;
	private String source;
	private String thingName;	
	private String status;
	
	private Integer statusTimeMillis;
	
	private Float temperature;
	private Float pressure;
	private Float radioSignalStrength;
	private Float gForceX;
	private Float gForceY;
	private Float gForceZ;
	private Integer batteryCharge;
	private Float batteryVoltage;
	private Integer voltage;
	private Integer frequency;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date recoverDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date originialDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThingId() {
		return thingId;
	}

	public void setThingId(String thingId) {
		this.thingId = thingId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusTimeMillis() {
		return statusTimeMillis;
	}

	public void setStatusTimeMillis(Integer statusTimeMillis) {
		this.statusTimeMillis = statusTimeMillis;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getPressure() {
		return pressure;
	}

	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}

	public Float getRadioSignalStrength() {
		return radioSignalStrength;
	}

	public void setRadioSignalStrength(Float radioSignalStrength) {
		this.radioSignalStrength = radioSignalStrength;
	}

	public Float getgForceX() {
		return gForceX;
	}

	public void setgForceX(Float gForceX) {
		this.gForceX = gForceX;
	}

	public Float getgForceY() {
		return gForceY;
	}

	public void setgForceY(Float gForceY) {
		this.gForceY = gForceY;
	}

	public Float getgForceZ() {
		return gForceZ;
	}

	public void setgForceZ(Float gForceZ) {
		this.gForceZ = gForceZ;
	}

	public Integer getBatteryCharge() {
		return batteryCharge;
	}

	public void setBatteryCharge(Integer batteryCharge) {
		this.batteryCharge = batteryCharge;
	}

	public Float getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(Float batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public Integer getVoltage() {
		return voltage;
	}

	public void setVoltage(Integer voltage) {
		this.voltage = voltage;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Date getRecoverDate() {
		return recoverDate;
	}

	public void setRecoverDate(Date recoverDate) {
		this.recoverDate = recoverDate;
	}

	public Date getOriginialDate() {
		return originialDate;
	}

	public void setOriginialDate(Date originialDate) {
		this.originialDate = originialDate;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
