package StepDefs;

import DriverFactory.DriverFact;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverFact {

	@Before
	public void startDriver1() {
		startDriver();
	}
//	
//	@After
//	public void stopDriver() {
//		driver.quit();
//	}	
}
