package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {

	WebDriver driver;

	public LoginObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")
	WebElement email;
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")
	WebElement password;

	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_ButtonLogIn")
	WebElement login;
	
	public WebElement email() {
		return email;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement login() {
		return login;
	}
	
}
