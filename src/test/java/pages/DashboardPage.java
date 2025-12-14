package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

		WebDriver driver;
		WebDriverWait wait;
		
	public DashboardPage(WebDriver driver)
	{
		  this.driver = driver;
	      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  PageFactory.initElements(driver, this);	
	}
	
	//getting all cards
	@FindBy(name="vessel-cards")
	List<WebElement> cards;
	
	
	
	//vessel count
	public int getCardsCount()
		{
        	wait.until(ExpectedConditions.visibilityOfAllElements(cards));
			return cards.size();
		}
	
	
	//vessel card basic info
    public List<String> getAllVesselData() {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        List<String> vessels = new ArrayList<>();
	
	        for (WebElement card : cards) {
	            String name = card.findElement(By.cssSelector(".name")).getText();
	            String status = card.findElement(By.cssSelector(".status")).getText();
	            String battery = card.findElement(By.cssSelector(".battery")).getText();
	            String location = card.findElement(By.cssSelector(".location")).getText();
	
	            String vesselInfo =
	                    "Name=" + name +
	                    ", Status=" + status +
	                    ", Battery=" + battery +
	                    ", Location=" + location;

	            vessels.add(vesselInfo);	     
	            
	        }
	        
        return vessels;
    }
	
    // Click Details button for a specific vessel by name
    public void clickDetailsButton(String vesselName) {
        //
        for (WebElement card : cards) {
            String name = card.findElement(By.xpath(".//span[contains(@class,'name')]")).getText();
            if (name.equalsIgnoreCase(vesselName)) {
                card.findElement(By.xpath(".//button[contains(text(),'Details')]")).click();
                return;
            }
        }
        
    }
	
		
	
}
