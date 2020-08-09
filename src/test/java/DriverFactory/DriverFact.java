package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFact {
	protected static WebDriver driver;


	public static WebDriver getDriver() {
		return (driver==null)? driver = new ChromeDriver():driver;
	}
	
	public WebDriver startDriver() {
		driver = new ChromeDriver();
		return driver;
	}
	
}
