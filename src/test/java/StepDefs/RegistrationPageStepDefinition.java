package StepDefs;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonUtils.ComUtils;
import DriverFactory.DriverFact;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import junit.framework.Assert;
import managers.PageObjectManager;
import utils.ConfigFileRead;

public class RegistrationPageStepDefinition extends DriverFact {
	PageObjectManager pom;
	ConfigFileRead config;

	@And("^I register the user with following details in the registration page$")
	public void registerWithDetails(DataTable dt) throws FileNotFoundException, IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		RegisterPage register = new RegisterPage(driver);
		List<Map<String,String>> m = dt.asMaps(String.class, String.class);
		String fn = m.get(0).get("Firstname");
		String ln = m.get(0).get("Lastname");
		String email =m.get(0).get("Email");
		String pwd = m.get(0).get("Password");
		String zipcode = m.get(0).get("Zipcode");
		String month = m.get(0).get("Birthmonth");
		String year = m.get(0).get("Birthyear");

		config = new ConfigFileRead();
		String lang = config.readPropertyFromConfig("region");
		switch(lang) {
		case "India":
			register.registerDetailsEN(fn, ln, email, pwd, pwd,zipcode, month, year);
			register.clickCreateYouProfileENButton();
			break;

		case "Austria":
			register.registerDetailsDE(fn+" "+ln, email, email, pwd, pwd);
			register.clickregistrierenDEButton();
			break;

		default:
			System.out.println("No countries specified");
			break;
		}
		config.writeToPropertyFile("Username"+lang, email);
		config.writeToPropertyFile("pwd"+lang, pwd);
	}
	
	
	
	@And("^I verify user is created successfully$")
	public void verifySuccessRegistration() throws InterruptedException, FileNotFoundException, IOException {
		LoginPage login = new LoginPage(driver);
		RegisterPage register = new RegisterPage(driver);
		config = new ConfigFileRead();
		String lang = config.readPropertyFromConfig("region");
		switch(lang) {
		case "India":
			ComUtils.driverwait(2000);
			login.isDisplayedRegistrationCompleteMessageIN();
			break;

		case "Austria":
			ComUtils.driverwait(2000);
			assertTrue(register.getWelcomeUsermessage().contains("Willkommen "));
			break;

		default:
			System.out.println("No countries specified");
			break;
		}
	}


}
