package DriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFact {
	protected static WebDriver driver;
	static boolean driverflag = false;

	static {
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		if(driverflag) {
			return driver;
		}else {
			driverflag=true;
			return new ChromeDriver();
		}
	}
}
