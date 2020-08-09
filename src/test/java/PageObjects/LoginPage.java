package PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigFileRead;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	ConfigFileRead config;
	WebDriver driver;

	@FindBy(xpath="//a[@title='REGISTER']")
	private WebElement loginRegisterLink;

	@FindBy(xpath="//span[.='KONTO']")
	private WebElement kontoDELink;

	@FindBy(xpath="//button[normalize-space(.)='Registrieren']")
	private WebElement registrierenDEButton;

	@FindBy(xpath="//span[.='Se connecter']/..")
	private WebElement seConnecterFRlink;

	@FindBy(xpath="//a[contains(.,'Connectez-vous')]")
	private WebElement connectezVousFRLink;

	@FindBy(id="onetrust-accept-btn-handler")
	private WebElement acceptCookiesFRButton;
	
	@FindBy(id="username")
	private WebElement usernameDETextbox;

	@FindBy(id="password")
	private WebElement passwordDETextbox;
	
	@FindBy(id="login-submit")
	private WebElement loginDEButton;
	
	@FindBy(xpath="//button[contains(.,'Passwort vergessen?')]")
	private WebElement passwortVergessenDEbutton;
	
	@FindBy(id="forgotten-password-email-field")
	private WebElement forgotPasswordEmailDETextbox;
	
	@FindBy(xpath="//input[@value='PASSWORT ZURÜCKSETZEN']")
	private WebElement passwordResetDEButton;
	
	@FindBy(xpath="//p[contains(.,'Anweisung zur Zurücksetzung deines Passwortes wurden an die folgende Adresse gesendet')]")
	private WebElement passwordSuccessfullySentDELabel;
	
	@FindBy(xpath="//input[@data-key='signInEmailAddress']")
	private WebElement usernameINTextbox;
	
	@FindBy(xpath="//input[@data-key='currentPassword']")
	private WebElement passwordINTextbox;
	
	@FindBy(xpath="//a[contains(.,'SIGN IN')]")
	private WebElement signinINLink;
	
	@FindBy(xpath="//input[@value='Sign In']")
	private WebElement signInINButton;
	
	@FindBy(xpath="//h1[.='Your Registration Is Complete']")
	private WebElement registrationCompleteINLabel;
	
	@FindBy(xpath="//span[contains(.,'Welcome,')]")
	private WebElement welcomeUserINLabel;
	
	@FindBy(xpath="//a[@class='forgotpwd']")
	private WebElement forgotPasswordINLink;
	
	@FindBy(xpath="//input[@data-key='signInEmailAddress']")
	private WebElement emailAddressForgotPAsswordTextBox;
	
	@FindBy(xpath="//input[@value='Create Your New Password']")
	private WebElement createNewPasswordButton;
	
	@FindBy(xpath="//h2[.='You will receive an e-mail very shortly containing a link to reset your password.']")
	private WebElement sentEmailsuccessfulForgotPasswordINLabel;
	
	public void clickRegisterLink() throws FileNotFoundException, IOException, InterruptedException {
		config = new ConfigFileRead();
		String lang = config.readPropertyFromConfig("region");
		switch(lang) {
		case "India":
			loginRegisterLink.click();
			break;
		case "Austria":
			goToLoginDE();
			registrierenDEButton.click();
			break;
		}
	}
		
		public void goToLoginDE() {
			kontoDELink.click();
		}

	public void LoginDE(String username, String password) {
		kontoDELink.click();
		usernameDETextbox.sendKeys(username);
		passwordDETextbox.sendKeys(password);
		loginDEButton.click();
	}

	public void clickforgotPasswordDE() {
		passwortVergessenDEbutton.click();
	}
	
	public void forgotPasswordEnterEmailDE(String email) {
		forgotPasswordEmailDETextbox.sendKeys(email );
	}

	public void clickPasswordResetDE() {
		passwordResetDEButton.click();
	}
	
	public boolean isDisplayedPasswordResetSuccessfullySentDE() {
		return passwordSuccessfullySentDELabel.isDisplayed();
	}
	
	public void loginIN(String username,String password) {
		clickSignInIN();
		usernameINTextbox.sendKeys(username);
		passwordINTextbox.sendKeys(password);
		signInINButton.click();
	}
	
	public void clickSignInIN() {
		signinINLink.click();
	}
	
	public boolean isDisplayedRegistrationCompleteMessageIN() {
		return registrationCompleteINLabel.isDisplayed();
	}
	
	public boolean userLoggedinIN() {
		return welcomeUserINLabel.isDisplayed();
	}
	
	public void clickForgotPasswordLinkIN() {
		forgotPasswordINLink.click();
	}
	
	public void enteremailForgotPasswordPAge(String email) {
		emailAddressForgotPAsswordTextBox.sendKeys(email);
	}
	
	public void clickCreateNewPasswordButtonIN() {
		createNewPasswordButton.click();
	}
	
	public boolean sentEmailSuccessfulForgotPasswordIN() {
		return sentEmailsuccessfulForgotPasswordINLabel.isDisplayed();
	}
}
