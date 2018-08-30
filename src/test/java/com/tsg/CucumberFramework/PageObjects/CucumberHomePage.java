package com.tsg.CucumberFramework.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tsg.CucumberFramework.Utility.Status;
import com.tsg.CucumberFramework.Utility.writeResult;

public class CucumberHomePage {
	public WebDriver driver;
	public CucumberHomePage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/hdr_findflight.gif']")
	private WebElement findFlight;
	
	@FindBy(how = How.XPATH, using ="//*[@name='userName']")
	private WebElement userName;
	
	@FindBy(how = How.XPATH, using ="//*[@name='password']")
	private WebElement Password;
	
	@FindBy(how = How.XPATH, using ="//*[@name='login']")
	private WebElement LogInButton;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/masts/mast_flightfinder.gif']")
	private WebElement flightFinder;
	
	@FindBy(how = How.XPATH, using ="//*[@name='tripType' and @value='roundtrip']")
	private WebElement tripTypeRound;
	
	@FindBy(how = How.XPATH, using ="//*[@name='tripType' and @value='oneway']")
	private WebElement tripTypeOneway;
	
	@FindBy(how = How.XPATH, using ="//*[@name='fromPort']")
	private WebElement DepartingFrom;
	
	@FindBy(how = How.XPATH, using ="//*[@name='toPort']")
	private WebElement ArrivingTo;
	
	@FindBy(how = How.XPATH, using ="//*[@name='servClass' and @value='Coach']")
	private WebElement ServiceClass;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/forms/continue.gif']")
	private WebElement ContinueButton;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/masts/mast_selectflight.gif']")
	private WebElement selectFlight;
	
	@FindBy(how = How.XPATH, using ="//*[@name='outFlight' and @value='Blue Skies Airlines$360$270$5:03']")
	private WebElement departRadioBttn;
	
	@FindBy(how = How.XPATH, using ="//*[@name='inFlight' and @value='Blue Skies Airlines$630$270$12:23']")
	private WebElement ReturnRadioBttn;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/masts/mast_book.gif']")
	private WebElement flightConfirmation;
	
	@FindBy(how = How.XPATH, using ="//*[@name='passFirst0']")
	private WebElement FirstName;
	
	@FindBy(how = How.XPATH, using ="//*[@name='passLast0']")
	private WebElement LastName;
	
	@FindBy(how = How.XPATH, using ="//*[@name='creditnumber']")
	private WebElement creditCardNumber;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/forms/purchase.gif']")
	private WebElement securePurchaseBttn;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/masts/mast_confirmation.gif']")
	private WebElement flightBookingConfirmation;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/printit.gif']")
	private WebElement ticketPrint;
	
	@FindBy(how = How.XPATH, using ="//*[@src='/images/forms/home.gif']")
	private WebElement backToHomeBttn;
	
	@FindBy(how = How.XPATH, using ="//*[@href='mercurywelcome.php']")
	private WebElement homeLink;
	
	
	public void userOnHomePage() {
		if(findFlight.isDisplayed()) {
			System.out.println("User is on Login Page");
		}
		else {
			System.out.println("User is Not on Login Page");
		}
		Assert.assertTrue("User is on Login Page", findFlight.isDisplayed());
	}
	
	public void enterUsernameAndPassword(String username, String password) {
		userName.sendKeys(username);
		Password.sendKeys(password);
		System.out.println("User name and Password is entered");
	}
	
	public void clickOnLoginBttn() {
		LogInButton.click();
		System.out.println("LogIn Button is clicked");
	}
	
	public void verifyNavigationToFlightReseravtionPage() {
		if(flightFinder.isDisplayed()) {
			System.out.println("User is on Flight Finder Launch Page");
		}
		else {
			System.out.println("User is on Not Flight Finder Launch Page");
		}
		Assert.assertTrue("User is on Flight Finder Launch Page", flightFinder.isDisplayed());		
	}
	
	public void clickOnRoundTripRadioBttn() {
		if(tripTypeRound.isSelected()) {
			System.out.println("RoundTrip Radio Button is selected");
		}
		else {
			tripTypeRound.click();
			System.out.println("RoundTrip Radio Button is clicked");
		}	
		Assert.assertTrue("RoundTrip Radio Button is selected", tripTypeRound.isDisplayed());
	}
	
	public void clickOnOnewayTripRadioBttn() {
		if(tripTypeOneway.isSelected()) {
			System.out.println("Oneway Radio Button is selected");
		}
		else {
			tripTypeOneway.click();
			System.out.println("Oneway Radio Button is clicked");
		}	
		Assert.assertTrue("Oneway Radio Button is selected", tripTypeOneway.isDisplayed());
	}
	
	public void selectDepartingFromDropdownOption() {
		Select oselectDepartingCountry = new Select(DepartingFrom);
		oselectDepartingCountry.selectByIndex(1);
		System.out.println("Departing From dropdown is selected");
	}
	
	public void selectArrivingToDropdownOption() {
		Select oselectArrivingCountry = new Select(ArrivingTo);
		oselectArrivingCountry.selectByIndex(2);
		System.out.println("Arriving In dropdown is selected");
	}
	
	public void selectServiceClassRadioBttn() {
		if(ServiceClass.isSelected()) {
			System.out.println("Economy Class Radio Button is selected");
		}
		else {
			ServiceClass.click();
			System.out.println("Economy Class Radio Button is clicked");
		}
		Assert.assertTrue("Economy Class Radio Button is selected", ServiceClass.isDisplayed());
	}
	
	public void clickOnContinueBttn() {
		ContinueButton.click();
		System.out.println("Continue Button is clicked");
	}
	
	public void verifyNavigationToBookingDetailsPage() {
		if(selectFlight.isDisplayed()) {
			System.out.println("User on Flight Selection Page");
		}
		else{
			System.out.println("User on Not Flight Selection Page");
		}
		Assert.assertTrue("User on Flight Selection Page", selectFlight.isDisplayed());
	}
	
	public void selectDepartFlightDetails() {
		if(departRadioBttn.isSelected()) {
			System.out.println("BlueSkies Airlines Radio Button is selected");	
		}
		else {
			departRadioBttn.click();
			System.out.println("BlueSkies Airlines Radio Button is clicked");
		}
		Assert.assertTrue("BlueSkies Airlines Radio Button is selected", departRadioBttn.isDisplayed());
	}
	
	public void selectReturnFlightDetails() {
		if(ReturnRadioBttn.isSelected()) {
			System.out.println("BlueSkies Airlines Radio Button is selected");	
		}
		else {
			ReturnRadioBttn.click();
			System.out.println("BlueSkies Airlines Radio Button is clicked");
		}
		Assert.assertTrue("BlueSkies Airlines Radio Button is selected", ReturnRadioBttn.isDisplayed());
	}
	
	public void verifyNavigationToBookFlightLandingPage() {
		if(flightConfirmation.isDisplayed()) {
			System.out.println("User navigate to Book flight Confirmation Page");
		}
		else {
			System.out.println("User Not able to navigate to Book flight Confirmation Page");
		}
		Assert.assertTrue("User navigate to Book flight Confirmation Page", flightConfirmation.isDisplayed());
	}
	
	public void enterFirstAndLastName(String firstname, String lastname) {
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		System.out.println("First Name and Last Name is entered");
	}
	
	public void enterCreditCardNumber(String cardnumber) {
		creditCardNumber.sendKeys(cardnumber);
		System.out.println("Credit Card Number is entered");
	}
	
	public void clickOnSecurePurchaseBttn() {
		securePurchaseBttn.click();
		System.out.println("Secure Purchase button is clicked");
	}
	
	public void verifyNavigationToFlightConfirmationPage() {
		if(flightBookingConfirmation.isDisplayed()) {
			System.out.println("Flight Confirmation Page is displayed");
		}
		else {
			System.out.println("Flight Confirmation Page is Not displayed");
		}
		Assert.assertTrue("Flight Confirmation Page is displayed", flightBookingConfirmation.isDisplayed());
	}
	
	public void verifyTicketBookingSucess() {
		if(ticketPrint.isDisplayed()) {
			System.out.println("Ticket is booked Successfully");
		}
		else {
			System.out.println("Ticket is Not booked");
		}
		Assert.assertTrue("Ticket is booked Successfully", ticketPrint.isDisplayed());
	}
	
	public void VerifyNavigationBackToHomePage() {
		backToHomeBttn.click();

		if(homeLink.isDisplayed()) {
			System.out.println("User navigate back to home Page ");
		}
		else {
			System.out.println("User Not able to navigate back to home Page ");
		}
	}
	
}
