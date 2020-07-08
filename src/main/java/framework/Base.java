package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public String url;
	public String loginUrl;
	public String signUpUrl;
	private Logger log = LogManager.getLogger(Base.class.getName());
	
	public WebDriver initialize() throws IOException {
		
		Properties prop = new Properties();
		String filePath = "C:\\Users\\Ankur Chauhan\\Eclipse\\Spicejet\\src\\main\\java\\framework\\data.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		url = prop.getProperty("homeurl");
		loginUrl = prop.getProperty("loginurl");
		signUpUrl = prop.getProperty("signupurl");
		
		String browserName = prop.getProperty("browser");
		String chromedriverlocation = prop.getProperty("chromedriverlocation");
		String firefoxdriverlocation = prop.getProperty("firefoxdriverlocation");
		String iedriverlocation = prop.getProperty("iedriverlocation");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromedriverlocation);
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxdriverlocation);
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", iedriverlocation);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
			
	}
	
	public String takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		log.info("Successfully took a screenshot");
		
		return destinationFile;

	}
	
}
