package framework;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage extends Base {
	
	WebDriver driver;
	
	private Logger log = LogManager.getLogger(HomePage.class.getName());
	
	
	@BeforeTest
	public void searchFlightsInitialize() throws IOException, InterruptedException {
		
		driver = initialize();
		driver.get(url);
		Thread.sleep(8000);
		log.info("Homepage successfully loaded");
		
	}
	
	@Test
	public void searchFlights() {
		
		HomePageObjects homeObjects = new HomePageObjects(driver);
		
		homeObjects.oneWay().click();
		log.debug("One Way radio button selected");
		
		homeObjects.departureCityBox().click();
		
		homeObjects.departartureDelhi().click();
		log.debug("Departure City Delhi Selected");
		
		homeObjects.destinationBengaluru().click();
		log.debug("Destination City Bengaluru Selected");
		
		homeObjects.departDate().click();
		log.debug("Departure Date Selected");
		
		homeObjects.passengersBox().click();
		log.debug("Passengers box clocked");
		
		Select selAdult = new Select(homeObjects.adult());
		selAdult.selectByValue("3");
		log.debug("3 Adults Selected");
		
		Select selChild = new Select(homeObjects.child());
		selChild.selectByValue("1");
		log.debug("1 Child Selected");
		
		Select selInfant = new Select(homeObjects.infant());
		selInfant.selectByValue("2");
		log.debug("2 Infants Selected");
		
		Select currency = new Select(homeObjects.currencyBox());
		currency.selectByValue("USD");
		log.debug("USD currency selected");
		
		homeObjects.search().click();
		log.debug("Clicked on search button");
		
	}
	
	@AfterTest
	public void searchFlightsEnd() {
		
		driver.close();
	}
	
}
