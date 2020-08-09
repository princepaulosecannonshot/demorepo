package StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import CommonUtils.ComUtils;
import DriverFactory.DriverFact;
import PageObjects.GoibiboPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import utils.ConfigFileRead;

public class GoibiboStepdefinition extends DriverFact {

	GoibiboPage gb = new GoibiboPage(driver);

	@And("^I navigate the browser to Goibibo site$")
	public void navigate_to_ibibo() throws InterruptedException, FileNotFoundException, IOException {

		driver.manage().window().maximize();
		driver.navigate().to("https://www.goibibo.com/");
	}

	@And("^I select one-way trip$")
	public void selectOneWayTrip() {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickOneWay();
	}
	
	@And("^I select round trip$")
	public void selectRoundTrip() {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickRoundTrip();
	}

	@And("^I select the From city as '(.*)'$")
	public void i_selecFromCity(String city) throws InterruptedException {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.selectFromCity(city);
	}

	@And("^I select the Destination city as '(.*)'$")
	public void i_selecDestCity(String city) throws InterruptedException, ParseException {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.selectDestCity(city);
	}

	@And("^I select the Departure date as '(.*)'$")
	public void selectDateDeparture(String date) throws InterruptedException, ParseException {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickdepartureCalendar();
		gb.selectCalendarDate(date);
	}
	
	@And("^I select the Return date as '(.*)'$")
	public void selectDateReturn(String date) throws InterruptedException, ParseException {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickReturnDateCalendar();
		ComUtils.driverwait(500);
		gb.selectCalendarDate(date);
	}

	@And("^I select seat class as '(.*)'$")
	public void selectSeatClass(String clas){
		GoibiboPage gb = new GoibiboPage(driver);
		gb.selectSeatAndClass();
		gb.selectClass(clas);
	}

	@And("^I book for '(.*)' number of '(.*)' passengers$")
	public void bookForNumberOfPassengers(String number, String name) {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.selectSeatAndClass();
		gb.enterSeatsForPassenger(name, number);
	}

	@And("^I click on Search button$")
	public void clickSearch() {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickSearchButton();
	}

	@And("^I sort on price$")
	public void sortPrice() throws InterruptedException {
		GoibiboPage gb = new GoibiboPage(driver);
		ComUtils.driverwait(6000);
		gb.sortPriceAscending();
	}

	@And("^I book the cheapest flight$")
	public void selectCheapestFlight(){
		GoibiboPage gb = new GoibiboPage(driver);
		gb.selectFirstFlight();
	}

	@And("^I opt out of travel insurance$")
	public void willingtoTakeRisk() throws InterruptedException {
		GoibiboPage gb = new GoibiboPage(driver);
		ComUtils.driverwait(1500);
		gb.takeRisk();
	}

	@And("^I enter the below passenger details$")
	public void enterPassengerDetails(DataTable dt) {
		GoibiboPage gb = new GoibiboPage(driver);
		List<Map<String,String>>data = dt.asMaps(String.class,String.class);
		for(Map<String,String> dat: data) {
			int number = Integer.parseInt(dat.get("Passenger number"));
			String title = dat.get("title");
			String fn = dat.get("firstname");
			String mn = dat.get("middlename");
			String ln = dat.get("lastname");
			String mobile = dat.get("mobile");
			String email = dat.get("email");
			gb.enterPassengerDetails(number,title, fn, mn, ln, mobile, email);
		}
	}

	@And("^I enter '(.*)' and '(.*)' in the email and mobile number for the ticket section respectively$")
	public void enterEmailAndMobileInTicketDetail(String email, String mobile) {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.enterEmailAndMobileTicketDetails(email, mobile);
	}

	@And("^I click on Proceed to Payment button$")
	public void proceedToPayment() {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickProceedToPayment();
	}

	@And("^I click on Proceed button$")
	public void proceed() {
		GoibiboPage gb = new GoibiboPage(driver);
		gb.clickProceed();
	}

	
}
