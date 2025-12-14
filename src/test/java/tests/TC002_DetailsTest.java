package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.DetailsPage;

public class TC002_DetailsTest extends BaseClass {

	
	@Test
    public void verifyVesselDetailsModal() {

        DashboardPage dashboard = new DashboardPage(driver);

  
        String vesselName = "AquaOne";  
        dashboard.clickDetailsButton(vesselName);

     
        DetailsPage details = new DetailsPage(driver);

  
        Assert.assertTrue(details.isModalDisplayed(), "Details modal is not displayed");
        Assert.assertEquals(details.getMissionName(), "Survey Mission Alpha");
        Assert.assertEquals(details.getPropulsionStatus(), "Propulsion: OK");
        Assert.assertEquals(details.getBatteryStatus(), "Battery: OK");
    }
}
