package tech.lantern.demoElasticsearch.test.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tech.lantern.demoElasticsearch.test.model.StatusThing;

public class StatusFactory {

	public List<StatusThing> createStatusTimeLine(int periodDuration) {

		List<StatusThing> statusTimeLine = new ArrayList<StatusThing>();

		StatusThing status;

		for (int index = 0; index <= periodDuration;) {
			status = createStatus(index,periodDuration);
			statusTimeLine.add(status);
			index = status.getTimeFin();

		}

		return statusTimeLine;
	}

	private StatusThing createStatus(int index, int periodDuration) {

		StatusThing status = null;

		Random random = new Random();
		int num = random.nextInt(5);

		String statusName;

		int timeIni = index;
		int duracion =0;


		Double minDuration = Double.parseDouble(periodDuration+"")*0.3;

		Double maxDuration = Double.parseDouble(periodDuration+"")*0.7;

		Double maxDurationNoRunning = Double.parseDouble(periodDuration+"")*0.1;
		Double minDurationNoRunning = Double.parseDouble(periodDuration+"")*0.01;


		
		switch (num) {
		case 1:
			statusName = "Running";
			duracion = random.nextInt(maxDuration.intValue())+minDuration.intValue();
			break;
		case 2:
			statusName = "No Loaded";
			duracion = random.nextInt(maxDurationNoRunning.intValue())+minDurationNoRunning.intValue();
			break;
		case 3:
			statusName = "Iddle";
			duracion = random.nextInt(maxDurationNoRunning.intValue())+minDurationNoRunning.intValue();
			break;
		case 4:
			statusName = "Machine Off";
			duracion = random.nextInt(maxDurationNoRunning.intValue())+minDurationNoRunning.intValue();
			break;
		default:
			statusName = "Running";
			duracion = random.nextInt(maxDuration.intValue())+minDuration.intValue();
			break;
		}

		int timeFin = index+duracion;	
		
		status = new StatusThing(timeIni, timeFin, statusName);
		return status;

	}

}
