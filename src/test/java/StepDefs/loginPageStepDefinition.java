package StepDefs;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import DriverFactory.DriverFact;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import utils.ConfigFileRead;

public class loginPageStepDefinition extends DriverFact {

	PageObjectManager pom;
	LoginPage login;
	ConfigFileRead config;
	RegisterPage register = new RegisterPage(driver);

	@Given("^I want to write a step with precondition$")
	public void demo() {
		System.out.println("Demo");
	}

	@And("^I navigate the browser to Gillette '(.*)' site$")
	public void navigate_to_site(String lang) throws InterruptedException, FileNotFoundException, IOException {
		config = new ConfigFileRead();
		String url = null;

		switch(lang){
		case "India":
			config.writeToPropertyFile("region", lang);
			System.out.println(config.readPropertyFromConfig("region"));
			url="https://www.gillette.co.in/en-in";
			break;

		case "Austria":
			config.writeToPropertyFile("region", lang);
			System.out.println(config.readPropertyFromConfig("region"));
			url="https://www.gillette.de/";
			break;

		default:
			System.out.println("Null value provided");
			break;
		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	@And("^I click on Register link$")
	public void clickRegisterLink() throws FileNotFoundException, IOException, InterruptedException {
		pom = new PageObjectManager(driver);
		login = pom.getLoginPage();

		login.clickRegisterLink();
	}

	@And("^I login into the site with valid credentials$")
	public void clickOnLogin() throws FileNotFoundException, IOException {
		pom = new PageObjectManager(driver);
		login = pom.getLoginPage();
		config = new ConfigFileRead();
		String lang = config.readPropertyFromConfig("region");
		String username=config.readPropertyFromConfig("Username"+lang);
		String password = config.readPropertyFromConfig("pwd"+lang);
		switch(lang){
		case "India":
			login.loginIN(username, password);
			assertTrue(login.userLoggedinIN());
			break;
		
		case "Austria":
			login.LoginDE(username, password);
			System.out.println(username);
			System.out.println(password);
			assertTrue(register.getWelcomeUsermessage().contains("Willkommen "));
			break;
	}
	}


@And("^I click on forgot password and verify that mail is sent successfully$")
public void forgotPasswordVerifyMailSentSuccess() throws FileNotFoundException, IOException, InterruptedException {
	pom = new PageObjectManager(driver);
	login = pom.getLoginPage();
	config = new ConfigFileRead();
	String lang = config.readPropertyFromConfig("region");
	switch(lang){
	case "Austria":
		login.goToLoginDE();
		login.clickforgotPasswordDE();
		login.forgotPasswordEnterEmailDE(config.readPropertyFromConfig("Username"+lang));
		login.clickPasswordResetDE();
		synchronized (driver) {
		driver.wait(2000);	
		}
		assertTrue(login.isDisplayedPasswordResetSuccessfullySentDE());
		break;
		
	case "India":
			login.clickSignInIN();
			synchronized (driver) {
			driver.wait(2000);	
			}
			login.clickForgotPasswordLinkIN();
			login.enteremailForgotPasswordPAge(config.readPropertyFromConfig("Username"+lang));
			login.clickCreateNewPasswordButtonIN();
			synchronized (driver) {
				driver.wait(2000);	
				}
			assertTrue(login.sentEmailSuccessfulForgotPasswordIN());
	}
}



}
