package CommonUtils;

import DriverFactory.DriverFact;

public class ComUtils extends DriverFact {

	public static void driverwait(int time) throws InterruptedException {
		synchronized (driver) {
		driver.wait(time);	
		}
	}
	
}
