package framework;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Base {
	
	private Logger log = LogManager.getLogger(Login.class.getName());
	WebDriver driver;
	
	@BeforeTest
	public void loginInitialize() throws IOException, InterruptedException {
		
		driver = initialize();
		driver.get(loginUrl);
		Thread.sleep(5000);
		log.info("Login page successfully loaded");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] object = {{"abc@gmail.com", "123456"}, {"xyz@gmail.com", "qwerty12345"}};
		return object;
	}
	
	@Test(dataProvider="getData")
	public void login(String email, String password) {
		
		LoginObjects loginObject = new LoginObjects(driver);
		
		loginObject.email().click();
		loginObject.email().sendKeys(email);	
		log.debug("Successfully added email");
		
		loginObject.password().click();
		loginObject.password().sendKeys(password);
		log.debug("Successfully added password");
		
		loginObject.login().click();
		log.debug("Clicked on login");
		
	}
	
	@AfterTest
	public void loginEnd() {
		
		driver.close();
	}
}