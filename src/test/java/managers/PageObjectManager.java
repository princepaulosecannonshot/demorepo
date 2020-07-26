package managers;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFact;
import PageObjects.GoibiboPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class PageObjectManager extends DriverFact {
private WebDriver driver;
private LoginPage login;
private RegisterPage register;
private GoibiboPage goib;

public PageObjectManager(WebDriver driver) {
	 this.driver = driver;
	 }

public LoginPage getLoginPage(){
	 return (login == null) ? login = new LoginPage(driver) : login;
	 }
	 
public RegisterPage getRegisterPage(){
	 return (register == null) ? register = new RegisterPage(driver) : register;
	 }

public GoibiboPage getgoibiboPage(){
	 return (goib == null) ? goib = new GoibiboPage(driver) : goib;
	 }
}
