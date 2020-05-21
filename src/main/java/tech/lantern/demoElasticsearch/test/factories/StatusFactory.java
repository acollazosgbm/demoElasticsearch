package tech.lantern.demoElasticsearch.test.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import tech.lantern.demoElasticsearch.test.model.StatusThing;

public class StatusFactory {

	
	
	private int timeRunning = 0;
	private int timeNoLoaded = 0;
	private int timeIddle = 0;
	private int timeMachineOff = 0;
	private int timeTotal = 0;
	
	List<Integer> numStatuses;
	
	
	
	public static void main(String[] args) {
		
		StatusFactory statusFactory = new StatusFactory(1000);
		
		List<StatusThing> statusTimeLine = statusFactory.createStatusTimeLine();
		
		System.out.println("-----------INICIO-------------");

		int index =0;
		for(StatusThing statusThing: statusTimeLine) {
			
			System.out.println("index: "+index);	
			System.out.println("nameStatus: "+statusThing.getName());	
			System.out.println("timeIni: "+statusThing.getTimeIni());	
			System.out.println("timeFin: "+statusThing.getTimeFin());	
			System.out.println("------------------------");
			index++;

		}

		System.out.println("-----------FIN-------------");
	
	}
	
	
	public StatusFactory(int timeTotal) {
		this.timeTotal = timeTotal;
		
		distribuirTiempoTotal();
	}

	private void distribuirTiempoTotal() {

		timeRunning = Double.valueOf(timeTotal*getPorcParticipacion(80,90)).intValue();
		timeNoLoaded = Double.valueOf(timeTotal*getPorcParticipacion(5,15)).intValue();
		timeIddle = Double.valueOf(timeTotal*getPorcParticipacion(5,15)).intValue();
		timeMachineOff = Double.valueOf(timeTotal*getPorcParticipacion(5,15)).intValue();
		int tiempoRestante = timeTotal -(timeRunning+timeNoLoaded+timeIddle+timeMachineOff);
		timeRunning = tiempoRestante+timeRunning;

		
	}

	public List<StatusThing> createStatusTimeLine() {

		List<StatusThing> statusTimeLine = new ArrayList<StatusThing>();
		
		numStatuses = new ArrayList<Integer>();

		StatusThing status;

		for (int index = 0; index < timeTotal;) {

			status = createStatus(index,timeTotal);
			statusTimeLine.add(status);
			index = status.getTimeFin();

		}

		return statusTimeLine;
	}

	private StatusThing createStatus(int index, int periodDuration) {

		StatusThing status = null;

		int num = radomNoRepetible(4);

		String statusName;

		int timeIni = index;
		int duracion =0;

		switch (num) {
		case 0:
			statusName = "Running";
			duracion = timeRunning;
			break;
		case 1:
			statusName = "No Loaded";
			duracion = timeNoLoaded;
			break;
		case 2:
			statusName = "Iddle";
			duracion = timeIddle;
			break;
		case 3:
			statusName = "Machine Off";
			duracion = timeMachineOff;
			break;
		default:
			statusName = "Running";
			duracion = timeRunning;
			break;
		}

		int timeFin = index+duracion;	
		
		status = new StatusThing(timeIni, timeFin, statusName);
		return status;

	}
	
	private Double getPorcParticipacion(int min, int max) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		Double porcParticipacion = Double.valueOf(randomNum)/100;
		return  porcParticipacion;
		
	}
	
	private int radomNoRepetible(int max) {

		int num = ThreadLocalRandom.current().nextInt(max);
		while (numStatuses.contains(num)) {
			num = ThreadLocalRandom.current().nextInt(max);
		}
		numStatuses.add(num);
		return num;


	}

}
