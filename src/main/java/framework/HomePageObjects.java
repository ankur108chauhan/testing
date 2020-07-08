package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};
	
	@FindBy(css="a[class='spicejet_logo']")
	WebElement logoText;
			
	@FindBy(id="ctl00_mainContent_rbtnl_Trip_0")
	WebElement oneWay;
	
	@FindBy(id="ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement departureCityBox;
	
	@FindBy(xpath="//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL']")
	WebElement departartureDelhi;
	
	@FindBy(xpath="//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")
	WebElement destinationBengaluru;
	
	@FindBy(css="a[class*='ui-state-highlight']")
	WebElement departDate;
	
	@FindBy(id="divpaxinfo")
	WebElement passengersBox;
	
	@FindBy(id="ctl00_mainContent_ddl_Adult")
	WebElement adult;
	
	@FindBy(id="ctl00_mainContent_ddl_Child")
	WebElement child;
	
	@FindBy(id="ctl00_mainContent_ddl_Infant")
	WebElement infant;
	
	@FindBy(id="ctl00_mainContent_DropDownListCurrency")
	WebElement currencyBox;
	
	@FindBy(id="ctl00_mainContent_btn_FindFlights")
	WebElement search;
	
		
	public WebElement oneWay() {
		return oneWay;
	}
	
	public WebElement departureCityBox() {
		return departureCityBox;
	}
	
	public WebElement departartureDelhi() {
		return departartureDelhi;
	}
	
	public WebElement destinationBengaluru() {
		return destinationBengaluru;
	}
	
	public WebElement departDate() {
		return departDate;
	}
	
	public WebElement passengersBox() {
		return passengersBox;
	}
	
	public WebElement adult() {
		return adult;
	}
	
	public WebElement child() {
		return child;
	}
	
	public WebElement infant() {
		return infant;
	}
	
	public WebElement currencyBox() {
		return currencyBox;
	}
	
	public WebElement search() {
		return search;
	}

	public WebElement logoText() {
		return logoText;
	}
}
