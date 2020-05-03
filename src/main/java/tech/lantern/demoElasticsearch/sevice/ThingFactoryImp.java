package tech.lantern.demoElasticsearch.sevice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import tech.lantern.demoElasticsearch.model.Location;
import tech.lantern.demoElasticsearch.model.ThingReport;

@Service
public class ThingFactoryImp implements ThingFactoryI {

	
	private Random random = new Random();
	
	@Override
	public List<ThingReport> crateThingsByLocation(Location location){

		List<ThingReport> thingsByLocation = new ArrayList<ThingReport>();
		ThingReport thing;
		int index = 0;
		for(String thingName:THING_NAMES) {
			thing = crateThings(location,thingName,index);
			thingsByLocation.add(thing);
			index++;
		}
		return thingsByLocation;

	}
	
	private ThingReport crateThings(Location location,String thingName,int index){
		
		ThingReport thing = new ThingReport();
		
		//id: TODO validar como está quedando en la BD
		
		//thingId;
		thing.setThingId(UUID.randomUUID().toString().substring(0, 7));
		
		/**
		 * Configuración de las maquinas
		 */
		//location;
		thing.setLocation(location);
		
		//source;
		thing.setSource(SOURCES.get(index));
		//thingName;
		thing.setThingName(thingName);
		
		//TODO status;


		//Integer statusTimeMillis;
		thing.setStatusTimeMillis(random.nextInt(5));
		//Float temperature;
		thing.setTemperature(0F);
		//Float pressure;
		thing.setPressure(0F);
		//Float radioSignalStrength;
		thing.setRadioSignalStrength(0F);
		//Integer batteryCharge;
		thing.setBatteryCharge(0);
		//Float batteryVoltage;
		thing.setBatteryVoltage(0F);
		//Integer voltage;
		thing.setVoltage(0);
		//Long frequency;
		thing.setFrequency(0);
		//Float gForceX;
		thing.setgForceX(getAxis());
		//Float gForceY;
		thing.setgForceY(getAxis());
		//Float gForceZ;
		thing.setgForceZ(getAxis());
		
		
		//Date recoverDate;
		//Date originialDate;
		//Date timestamp;
		thing.setTimestamp(new Date());
		
		return thing;
	}
	
	private Float getAxis(){
		
        float leftLimit = -5F;
        float rightLimit = 5F;
        DecimalFormat df = new DecimalFormat("0.##");
	    Float generatedFloat = Float.parseFloat(df.format(leftLimit + new Random().nextFloat() * (rightLimit - leftLimit)));
	    
	    return generatedFloat;
		
	}

}
