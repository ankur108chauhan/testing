package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateText extends Base {
	
	private Logger log = LogManager.getLogger(ValidateText.class.getName());
	WebDriver driver;
	
	@BeforeTest
	public void	validateTextInitialize() throws IOException, InterruptedException {
		
		driver = initialize();
		driver.get(url);
		Thread.sleep(2000);
		log.info("Homepage successfully loaded");

	}
	
	@Test
	public void checkText() {
		
		HomePageObjects homeObjects = new HomePageObjects(driver);
		
		String logoText = homeObjects.logoText().getText();
		Assert.assertEquals(logoText, "Spicejet123456");
		log.debug("Logo text is correct");
	}
	
	@AfterTest
	public void validateTextEnd() {
		
		driver.close();
	}
}
