package tech.lantern.demoElasticsearch.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import tech.lantern.demoElasticsearch.model.ThingReport;
import tech.lantern.demoElasticsearch.repository.ThingRepository;
import tech.lantern.demoElasticsearch.test.factories.StageFactory;
import tech.lantern.demoElasticsearch.test.model.Site;
import tech.lantern.demoElasticsearch.test.model.Stage;
import tech.lantern.demoElasticsearch.test.model.Thing;

@Component
public class ExecuteDataLoad {

	@Autowired
	private ThingRepository thingElasticsearchRepository;

	private static final Logger log = LoggerFactory.getLogger(ExecuteDataLoad.class);

	private static final int periodDuration = 100;
	
	private int amoutReports =0;
	
	@EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
	public void executeLoad() {

		log.info("INICIO");

		
		StageFactory stageFactory = new StageFactory();
		Stage stage = stageFactory.createStage(periodDuration);

		for(int i =0; i<= periodDuration; i++){
			log.info("--------------");
			log.info("Momento: "+i);
			log.info("--------------");
			executeStage(stage);
			stageFactory.updateStage(stage, i+1);
		}
	

		log.info("FIN");
		log.info("was save "+amoutReports+" ThingReport");
		log.info("*******************************************");
	}

	public void executeStage(Stage stage) {
		
		List<Site> sites = stage.getSites();
		int index = 0;
		
		for (Site site :sites) {
			
			log.info("site # "+index);

			executeEscenarioBySite(site);
			index++;

		}
	}

	public void executeEscenarioBySite(Site site) {

		List<Thing> things = site.getThings();
		
		List<ThingReport> thingsReports = new ArrayList<ThingReport>();
		
		for(Thing thing:things) {
			
			// Espera un segundo antes de enviar los reportes de otro site
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//thingElasticsearchRepository.save(thing.getThingReport());
			//amoutReports++;
			thingsReports.add(thing.getThingReport());
		}
		
		thingElasticsearchRepository.saveAll(thingsReports);
		log.info("saved " + things.size() + " things of site");
	}

}
