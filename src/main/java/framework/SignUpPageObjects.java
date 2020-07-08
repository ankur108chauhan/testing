package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObjects {
	
	WebDriver driver;

	public SignUpPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};
	
	@FindBy(id="popup_ok")
	WebElement popup;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")
	WebElement title;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName")
	WebElement firstName;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName")
	WebElement lastName;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINTLMOBILENUMBER")
	WebElement mobileNumber;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword")
	WebElement password;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm")
	WebElement confirmPassword;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB")
	WebElement datePickerBox;
	
	@FindBy(xpath="//th[@class='datepickerGoPrev']/a")
	WebElement goPrevious;
	
	@FindBy(xpath="//tbody[@class='datepickerYears']/tr[1]/td[2]")
	WebElement birthYear;
	
	@FindBy(xpath="//tbody[@class='datepickerMonths']/tr[1]/td[1]")
	WebElement birthMonth;
	
	@FindBy(xpath="//tbody[@class='datepickerDays']/tr[2]/td[4]")
	WebElement birthDate;

	@FindBy(id="CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")
	WebElement email;
	
	@FindBy(id="chkSpiceClubTnC")
	WebElement terms;
	
	@FindBy(id="CONTROLGROUPREGISTERVIEW_ButtonSubmit")
	WebElement submit;
	
	@FindBy(id="Login")
	WebElement login;
	
	public WebElement mainBody() {
		return popup;
	}
	
	public WebElement title() {
		return title;
	}
	
	public WebElement firstName() {
		return firstName;
	}
	
	public WebElement lastName() {
		return lastName;
	}
	
	public WebElement mobileNumber() {
		return mobileNumber;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement confirmPassword() {
		return confirmPassword;
	}
	
	public WebElement datePickerBox() {
		return datePickerBox;
	}
	
	public WebElement goPrevious() {
		return goPrevious;
	}
	
	public WebElement birthYear() {
		return birthYear;
	}
	
	public WebElement birthMonth() {
		return birthMonth;
	}
	
	public WebElement birthDate() {
		return birthDate;
	}
	
	public WebElement email() {
		return email;
	}
	
	public WebElement terms() {
		return terms;
	}
	
	public WebElement submit() {
		return submit;
	}
	
	public WebElement login() {
		return login;
	}
}
