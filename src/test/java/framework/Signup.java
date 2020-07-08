package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Signup extends Base{
	
	private Logger log = LogManager.getLogger(Signup.class.getName());
	WebDriver driver;
	
	@BeforeTest
	public void	signupInitialize() throws IOException, InterruptedException {
		
		driver = initialize();
		driver.get(signUpUrl);
		Thread.sleep(3000);
		log.info("Signup page successfully loaded");
	}
	
	@DataProvider
	public Object[][] getSignUpData() {
		
		Object[][] object = {{"Ankur", "Chauhan", "9455785685", "@Qwerty123456", "@Qwerty123456", "ankur@gmail.com"}};
		return object;
	}
	
	@Test(dataProvider="getSignUpData")
	public void signup(String firstName, String lastName, String mobile, String password, String confirmPassword, String email) {
		
		SignUpPageObjects signUpPageObject = new SignUpPageObjects(driver);
		
		Select title = new Select(signUpPageObject.title());
		title.selectByIndex(1);
		log.debug("Title selected successfully");
		
		signUpPageObject.firstName().click();
		signUpPageObject.firstName().sendKeys(firstName);
		log.debug(firstName + " added successfully");

		signUpPageObject.lastName().click();
		signUpPageObject.lastName().sendKeys(lastName);
		log.debug(lastName + " added successfully");
		
		signUpPageObject.mobileNumber().click();
		signUpPageObject.mobileNumber().sendKeys(mobile);
		log.debug(mobile + " added successfully");
		
		signUpPageObject.password().click();
		signUpPageObject.password().sendKeys(password);
		log.debug(password + " added successfully");
		
		signUpPageObject.confirmPassword().click();
		signUpPageObject.confirmPassword().sendKeys(confirmPassword);
		log.debug(confirmPassword + " added successfully");
		
		signUpPageObject.datePickerBox().click();
		log.debug("Datepicker box clicked");
		
		signUpPageObject.goPrevious().click();
		log.debug("Previous year button clicked");
		
		signUpPageObject.birthYear.click();
		log.debug("Birth year selected");
		
		signUpPageObject.birthMonth().click();
		log.debug("Birth month selected");
		
		signUpPageObject.birthDate().click();
		log.debug("Birth date selected");
		
		signUpPageObject.email().click();
		signUpPageObject.email().sendKeys(email);
		log.debug(email + " added successfully");
		
		signUpPageObject.terms().click();
		log.debug("Terms Selected Successfully");
		
		signUpPageObject.submit().click();
		log.debug("Submit button clicked successfully");
	}
	
	@AfterTest
	public void signupEnd() {
		driver.close();
	}
}
