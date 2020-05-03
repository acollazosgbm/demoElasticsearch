package tech.lantern.demoElasticsearch.test.factories;

import java.util.List;

import tech.lantern.demoElasticsearch.test.model.Site;
import tech.lantern.demoElasticsearch.test.model.Stage;

public class StageFactory {

	private SiteFactory siteFactory = new SiteFactory();
	
	
	
	public Stage createStage(int periodDuration) {
		
		List<Site> sites = siteFactory.configSiteStage(periodDuration);
		
		Stage stage = new Stage();
		stage.setSites(sites);

		return stage;
	}

	public void updateStage(Stage stage, int moment) {
		
		siteFactory.updateSites(stage.getSites(), moment);
		
	}

}
