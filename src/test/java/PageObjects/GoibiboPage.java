package PageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ConfigFileRead;

public class GoibiboPage {

	public GoibiboPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	ConfigFileRead config;
	WebDriver driver;


	@FindBy(xpath="//span[.='One way']")
	private WebElement oneWayButton;
	
	@FindBy(xpath="//span[.='Round trip']")
	private WebElement roundTripButton;

	@FindBy(id="gosuggest_inputSrc")
	private WebElement fromCity;

	@FindBy(id="gosuggest_inputDest")
	private WebElement destCity;

	@FindBy(xpath="//div[@class='DayPicker-Caption']")
	private WebElement calendarMonthHeader;

	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	private WebElement calendarNextMonthbutton;

	@FindBy(id="departureCalendar")
	private WebElement departureCalendar;

	@FindBy(id="pax_link_common")
	private WebElement seatClass;

	@FindBy(id="gi_class")
	private WebElement classDropdown;

	@FindBy(id="gi_search_btn")
	private WebElement searchButton;
	
	@FindBy(xpath="//span[contains(.,'PRICE')][@class='fb ico11 ']")
	private WebElement priceHeaderSearchResults;
	
	@FindBy(xpath="(//input[@value='BOOK'])[1]")
	private WebElement bookButtonFirst;
	
	@FindBy(xpath="//label[.='I am willing to risk my trip']/preceding-sibling::input")
	private WebElement takeRiskRadioButton;
	
	@FindBy(xpath="//div[@class='fl width100 padLR10 greyBg borderBtm marginB5']")
	private List<WebElement> passengerDetailsSection;
	
	@FindBy(xpath="//i[@class='fl ico8 greyLter iconflt-dwnarrowln padT5 padR45']/../..//*[@data-fieldname='Title']")
	private WebElement titlePassengerDetailsDropdown;
	
	@FindBy(xpath="//i[@class='fl ico8 greyLter iconflt-dwnarrowln padT5 padR45']/../..//*[@data-fieldname='First Name']")
	private WebElement firstNamePassengerDetailsTextbox;

	@FindBy(xpath="//i[@class='fl ico8 greyLter iconflt-dwnarrowln padT5 padR45']/../..//*[@data-fieldname='Middle Name']")
	private WebElement middleNamePassengerDetailsTextbox;
	
	@FindBy(xpath="//i[@class='fl ico8 greyLter iconflt-dwnarrowln padT5 padR45']/../..//*[@data-fieldname='Last Name']")
	private WebElement lastNamePassengerDetailsTextbox;
	
	@FindBy(xpath="//i[@class='fl ico8 greyLter iconflt-dwnarrowln padT5 padR45']/../..//*[@data-fieldname='Mobile Number']")
	private WebElement mobilePassengerDetailsTextbox;
	
	@FindBy(xpath="//i[@class='fl ico8 greyLter iconflt-dwnarrowln padT5 padR45']/../..//*[@data-fieldname='Email']")
	private WebElement emailPassengerDetailsTextbox;
	
	@FindBy(xpath="//*[@id='cont_email']//input[@id='email']")
	private WebElement emailTicketDetails;
	
	@FindBy(xpath="//*[@id='cont_mobile']//input[@id='mobile']")
	private WebElement mobileTicketDetails;
	
	@FindBy(xpath="//button[.='Proceed To Payment']")
	private WebElement proceedToPaymentButton;
	
	@FindBy(xpath="//button[contains(.,'Proceed')]")
	private WebElement proceedButton;
	
	@FindBy(id="returnCalendar")
	private WebElement returnDateCalendar;
	
	private WebElement getCalendarDay(String date) {
		return driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div[@id='fare_"+date+"']"));
	}

	private WebElement selectCityautoSuggest(String city) {
		return driver.findElement(By.xpath("//ul[@id='react-autosuggest-1']//*[contains(.,'"+city+"')]"));
	}

	private WebElement enterSeats(String name) {
		return driver.findElement(By.xpath("//label[@class='ico14 db padB5'][contains(.,'"+name+"')]/following-sibling::div/input"));
	}



	public void clickOneWay() {
		oneWayButton.click();
	}
	
	public void clickRoundTrip() {
		roundTripButton.click();
	}


	public void selectFromCity(String city) {
		fromCity.sendKeys(city);
		selectCityautoSuggest(city).click();
	}

	public void selectDestCity(String city) {
		destCity.sendKeys(city);
		selectCityautoSuggest(city).click();
	}

	public void clickdepartureCalendar() {
		departureCalendar.click();
	}

	public void selectCalendarDate(String date) throws InterruptedException, ParseException {
		String[] indiv = date.split("/");
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fm = new SimpleDateFormat("MMMM yyyy",Locale.US);
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyyMMdd");
		Date dt = fmt.parse(date);
		String newdt = fm.format(dt);
		String daydt = fmt2.format(dt);
		while(!newdt.contentEquals(calendarMonthHeader.getText())) {
			calendarNextMonthbutton.click();
			synchronized (driver) {
				driver.wait(500);	
			}
		}
		getCalendarDay(daydt).click();
	}

	public void selectSeatAndClass() {
		seatClass.click();
	}

	public void selectClass(String cla) {
		Select sel = new Select(classDropdown);
		sel.selectByVisibleText(cla);
	}

	public void enterSeatsForPassenger(String name, String number) {
		enterSeats(name).clear();
		enterSeats(name).sendKeys(number);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void sortPriceAscending() {
		priceHeaderSearchResults.click();
	}
	
	public void selectFirstFlight() {
		bookButtonFirst.click();
	}
	
	public void takeRisk() {
		takeRiskRadioButton.click();
	}
	
	public void enterPassengerDetails(int passengernumber, String title,String firstname,String middlename,String lastname,String mobile, String email) {
		
		
		List<WebElement> ipass = passengerDetailsSection;
		WebElement pass = ipass.get(passengernumber-1);
		
			pass.click();
			Select sel = new Select(titlePassengerDetailsDropdown);
			sel.selectByVisibleText(title);
			
			firstNamePassengerDetailsTextbox.sendKeys(firstname);
			middleNamePassengerDetailsTextbox.sendKeys(middlename);
			lastNamePassengerDetailsTextbox.sendKeys(lastname);
			mobilePassengerDetailsTextbox.sendKeys(mobile);
			emailPassengerDetailsTextbox.sendKeys(email);
	}
	
	public void enterEmailAndMobileTicketDetails(String email, String mobile) {
		emailTicketDetails.sendKeys(email);
		mobileTicketDetails.sendKeys(mobile);
	}
	
	public void clickProceedToPayment() {
		proceedToPaymentButton.click();
	}
	
	public void clickProceed() {
		proceedButton.click();
	}
	
	public void clickReturnDateCalendar() {
		returnDateCalendar.click();
	}
}
