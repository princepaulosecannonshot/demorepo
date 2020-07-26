package PageObjects;

import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ConfigFileRead;

public class RegisterPage {
//	public RegisterPage(WebDriver driver) {
//	     PageFactory.initElements(driver, this);
//	 }
	
	public RegisterPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	ConfigFileRead config;
	
	
	@FindBy(xpath = "//span[contains(.,'Firstname')]/../input")
	private WebElement firstnameENTextbox;
	
	@FindBy(xpath = "//span[contains(.,'Last Name')]/../input")
	private WebElement lastnameENTextbox;
	
	@FindBy(xpath = "//span[contains(.,'Email')]/../input")
	private WebElement emailENTextbox;
	
	@FindBy(xpath = "(//span[contains(.,'Password')]/../input)[1]")
	private WebElement passwordENTextbox;
	
	@FindBy(xpath = "//span[contains(.,'Confirm Password')]/../input")
	private WebElement confirmPasswordENTextbox;
	
	@FindBy(xpath = "//span[contains(.,'Zip code')]/../input")
	private WebElement zipCodeENTextbox;
	
	@FindBy(xpath = "//select[contains(@data-key,'dateselect_month')]")
	private WebElement birthMonthENDropdown;
	
	@FindBy(xpath = "//select[contains(@data-key,'dateselect_year')]")
	private WebElement birthYearENDropdown;
	
	@FindBy(xpath = "//input[@value='Create your Profile']")
	private WebElement createYourProfileButton;
	
	@FindBy(xpath="//input[@name='customerName']")
	private WebElement customerNameDETextbox;
	
	@FindBy(xpath="//input[@name='customerEmail']")
	private WebElement customerEmailDETextbox;
	
	@FindBy(xpath="//input[@name='confirmCustomerEmail']")
	private WebElement confirmCustomerEmailDETextbox;
	
	@FindBy(xpath="//input[@name='customerPassword']")
	private WebElement customerPasswordDETextbox;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPasswordDETextbox;
	
	@FindBy(xpath="//label[@data-context='optOut']")
	private WebElement optOutOfEmailsDELabel;
	
	@FindBy(xpath="//button[normalize-space(.)='Registrieren']")
	private WebElement registrierenDEButton;
	
	@FindBy(xpath="//button[.='Alle Cookie akzeptieren']")
	private WebElement acceptCookiesDEbutton;
	
	@FindBy(xpath="//p[@class='myAccountSection_header_welcome']")
	private WebElement welcomeUserDELabel;
	
	@FindBy(xpath="//input[@name='email_create']")
	private WebElement emailFRTextbox;
	
	@FindBy(xpath="//button[@name='SubmitCreate']")
	private WebElement submitRegistrationFRButton;
	
	@FindBy(xpath="//input[@name='customer_firstname']")
	private WebElement firstNameFRTextbox;
	
	@FindBy(xpath="//input[@name='customer_lastname']")
	private WebElement lastNameFRTextbox;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email2FRTextbox;
	
	@FindBy(xpath="//input[@name='passwd']")
	private WebElement passwordFRTextbox;
	
	@FindBy(id="years")
	private WebElement yearFRDropdown;
	
	@FindBy(id="months")
	private WebElement monthFRDropdown;
	
	@FindBy(id="days")
	private WebElement dayFRDropdown;
	
	@FindBy(xpath="//div[@id='uniform-noThanks']/span")
	private WebElement noThanksFRRadioButton;
	
	
	public void registerDetailsEN(String fn,String ln,String email,String pwd,String cpwd,String zp,String month,String year) {
		firstnameENTextbox.sendKeys(fn);
		lastnameENTextbox.sendKeys(ln);
		emailENTextbox.sendKeys(email);
		passwordENTextbox.sendKeys(pwd);
		confirmPasswordENTextbox.sendKeys(cpwd);
		zipCodeENTextbox.sendKeys(zp);
		Select sel = new Select(birthMonthENDropdown);
		sel.selectByVisibleText(month);
		sel = new Select(birthYearENDropdown);
		sel.selectByVisibleText(year);
	}
	
	public void registerDetailsDE(String custname, String email, String confemail, String pwd, String confpwd) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver,30);
//wait.wait(5000);
synchronized(driver)
{
    driver.wait(5000);
}
		if(acceptCookiesDEbutton.isDisplayed()) {
			acceptCookiesDEbutton.click();
		}
		customerNameDETextbox.sendKeys(custname);
		customerEmailDETextbox.sendKeys(email);
		confirmCustomerEmailDETextbox.sendKeys(confemail);
		customerPasswordDETextbox.sendKeys(pwd);
		confirmPasswordDETextbox.sendKeys(confpwd);
		optOutOfEmailsDELabel.click();
	}
	
	public void clickCreateYouProfileENButton() {
		createYourProfileButton.click();
	}
	
	public void clickregistrierenDEButton() {
		registrierenDEButton.click();
	}
	

	public String getWelcomeUsermessage() {
		return welcomeUserDELabel.getText();
	}
	
	
}
