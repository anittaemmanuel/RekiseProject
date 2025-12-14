package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;

public class TC001_DashboardTest extends BaseClass{
	
	@Test
	public void verifyAllVesselsData() {

	    DashboardPage dashboard = new DashboardPage(driver);

	    Assert.assertEquals(dashboard.getCardsCount(), 3);

	    List<String> vessels = dashboard.getAllVesselData();

	    for (String vessel : vessels) {
	        System.out.println(vessel);
	    }

	    boolean offlineFound = false;

	    for (String vessel : vessels) {
	        if (vessel.contains("Status=Offline")) {
	            offlineFound = true;
	            break;
	        }
	    }

	    Assert.assertTrue(offlineFound, "Expected at least one Offline vessel");
	}


}
