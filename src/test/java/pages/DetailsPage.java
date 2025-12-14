package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsPage {
	 
		WebDriver driver;
	    WebDriverWait wait;

	    public DetailsPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    private By modal = By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]");
	    private By missionName = By.xpath("//span[contains(@class,'mission-name')]");
	    private By propulsionStatus = By.xpath("//div[contains(@class,'subsystem') and contains(@class,'propulsion')]");
	    private By batteryStatus = By.xpath("//div[contains(@class,'subsystem') and contains(@class,'battery')]");

	    public boolean isModalDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(modal)).isDisplayed();
	    }

	    public String getMissionName() {
	        return driver.findElement(missionName).getText();
	    }

	    public String getPropulsionStatus() {
	        return driver.findElement(propulsionStatus).getText();
	    }

	    public String getBatteryStatus() {
	        return driver.findElement(batteryStatus).getText();
	    }
}
