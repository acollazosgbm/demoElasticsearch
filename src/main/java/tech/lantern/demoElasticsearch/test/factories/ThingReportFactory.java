package tech.lantern.demoElasticsearch.test.factories;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import tech.lantern.demoElasticsearch.model.ThingReport;
import tech.lantern.demoElasticsearch.test.model.Country;
import tech.lantern.demoElasticsearch.test.model.StatusThing;
import tech.lantern.demoElasticsearch.test.model.Thing;

public class ThingReportFactory {


	private Random random = new Random();

	
	
	public ThingReport createThingReport(int moment, List<StatusThing> timeLine, Thing thing) {

		
		
		//configura reporte con todos los datos del thing
		ThingReport thingReport = createThingReport(thing);
		
		// asigna los valores de las metricas, de forma aleatoria
		setRandonThingReport(thingReport);
		
		// asigna el esatdo segun el timeline configurado para esta cosa
		String status = getStatusThing(moment,timeLine);
		thingReport.setStatus(status);
		
		return thingReport;

	}

	public void updateThingReport(int moment, ThingReport thingReport, Thing thing) {

		// asigna los valores de las metricas, de forma aleatoria
		setRandonThingReport(thingReport);
		
		// asigna el esatdo segun el timeline configurado para esta cosa
		String status = getStatusThing(moment,thing.getTimeLine());
		thingReport.setStatus(status);		
	}
	
	
	private ThingReport createThingReport(Thing thing) {
		
		
		ThingReport thingReport = new ThingReport();
		thingReport.setThingId(thing.getThingId());
		thingReport.setThingName(thing.getThingName());
		
		Country country = thing.getCountry();
 		thingReport.setLocation(country.getLocation());
 		
 		thingReport.setLocationName(country.getNameCountry());
		thingReport.setSource(thing.getSource());
		
		return thingReport;
	}






	private String getStatusThing(int moment,List<StatusThing> timeLine) {

		String nameStatus = null;
		int timeIni = 0;
		int timeFin = 0;

		for (StatusThing status : timeLine) {

			nameStatus = status.getName();
			timeIni = status.getTimeIni();
			timeFin = status.getTimeFin();

			if (moment >= timeIni  & moment < timeFin) {
				return nameStatus;
			}

		}
		return nameStatus;

	}

	
	
	private ThingReport setRandonThingReport(ThingReport thingReport) {

		
		thingReport.setId(thingReport.getThingId() + "-" + UUID.randomUUID().toString().substring(0, 7));

		// Integer statusTimeMillis;
		thingReport.setStatusTimeMillis(random.nextInt(5));
		// Float temperature;
		thingReport.setTemperature(getFloatRandom(40, 60));
		// Float pressure;
		thingReport.setPressure(getFloatRandom(1000, 10000));
		// Float radioSignalStrength;
		thingReport.setRadioSignalStrength(getFloatRandom(0, 60));
		// Integer batteryCharge;
		thingReport.setBatteryCharge(getIntRandom(0, 100));
		// Float batteryVoltage;
		thingReport.setBatteryVoltage(getFloatRandom(60, 220));
		// Integer voltage;
		thingReport.setVoltage(getIntRandom(60, 220));
		// Long frequency;
		thingReport.setFrequency(getIntRandom(0, 110));
		// Float gForceX;
		thingReport.setgForceX(getFloatRandom(-5, 5));
		// Float gForceY;
		thingReport.setgForceY(getFloatRandom(-5, 5));
		// Float gForceZ;
		thingReport.setgForceZ(getFloatRandom(-5, 5));

		Calendar cal = Calendar.getInstance();
		Date timestamp = cal.getTime();
		thingReport.setTimestamp(timestamp);

		int latency = getIntRandom(0, 5);

		cal.add(Calendar.SECOND, latency);
		Date recoverDate = cal.getTime();
		thingReport.setRecoverDate(recoverDate);

		cal.add(Calendar.SECOND, -2 * latency);
		Date originialDate = cal.getTime();
		thingReport.setOriginialDate(originialDate);
		
		return thingReport;
	}

	private Float getFloatRandom(int min, int max) {

		float leftLimit = Float.parseFloat(min + "");
		float rightLimit = Float.parseFloat(min + "");

		DecimalFormat df = new DecimalFormat("0.##");
		Float generatedFloat = Float
				.parseFloat(df.format(leftLimit + new Random().nextFloat() * (rightLimit - leftLimit)));

		return generatedFloat;

	}

	private int getIntRandom(int min, int max) {
		max = max - min;
		int numRandom = random.nextInt(max) + min;
		return numRandom;
	}


}
