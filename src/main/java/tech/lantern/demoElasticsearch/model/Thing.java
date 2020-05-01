package tech.lantern.demoElasticsearch.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = "Hunt-R", type = "thing")
public class Thing {
	
	@Id
	private String id;
	private String thingId;
	
	
	private String location;
	private String source;
	private String thingName;	
	private String status;
	
	private Long statusTimeMillis;
	

	private Long temperature;
	private Long pressure;
	private Long radioSignalStrength;
	private Long gForceX;
	private Long gForceY;
	private Long gForceZ;
	private Integer batteryCharge;
	private Long batteryVoltage;
	private Integer Voltage;
	private Long frequency;
	
	

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

	public Long getStatusTimeMillis() {
		return statusTimeMillis;
	}

	public void setStatusTimeMillis(Long statusTimeMillis) {
		this.statusTimeMillis = statusTimeMillis;
	}

	public Long getTemperature() {
		return temperature;
	}

	public void setTemperature(Long temperature) {
		this.temperature = temperature;
	}

	public Long getPressure() {
		return pressure;
	}

	public void setPressure(Long pressure) {
		this.pressure = pressure;
	}

	public Long getRadioSignalStrength() {
		return radioSignalStrength;
	}

	public void setRadioSignalStrength(Long radioSignalStrength) {
		this.radioSignalStrength = radioSignalStrength;
	}

	public Long getgForceX() {
		return gForceX;
	}

	public void setgForceX(Long gForceX) {
		this.gForceX = gForceX;
	}

	public Long getgForceY() {
		return gForceY;
	}

	public void setgForceY(Long gForceY) {
		this.gForceY = gForceY;
	}

	public Long getgForceZ() {
		return gForceZ;
	}

	public void setgForceZ(Long gForceZ) {
		this.gForceZ = gForceZ;
	}

	public Integer getBatteryCharge() {
		return batteryCharge;
	}

	public void setBatteryCharge(Integer batteryCharge) {
		this.batteryCharge = batteryCharge;
	}

	public Long getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(Long batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public Integer getVoltage() {
		return Voltage;
	}

	public void setVoltage(Integer voltage) {
		Voltage = voltage;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
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
