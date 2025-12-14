package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	protected  WebDriver driver;

	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		
        // ASSUMED application URL 
        driver.get("http://localhost:3000/dashboard");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
