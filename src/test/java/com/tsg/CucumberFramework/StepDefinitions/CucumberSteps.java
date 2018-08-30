package com.tsg.CucumberFramework.StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.tsg.CucumberFramework.PageObjects.CucumberHomePage;
import com.tsg.CucumberFramework.Utility.Status;
import com.tsg.CucumberFramework.Utility.writeResult;
import com.tsg.CucumberFramework.dataProvider.ConfigFileReader;
import com.tsg.CucumberFramework.dataProvider.WebDriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps {

	WebDriver driver;
//	CucumberHomePage stepPages = new CucumberHomePage(driver);
	ConfigFileReader configfileReader = new ConfigFileReader();
	WebDriverManager webDriverManager;
	Scenario scenario;
	public writeResult Report = new writeResult();
	
	@Before
	public void beforeScenario(Scenario scenario) {
			System.out.println(scenario.getName());
			Reporter.assignAuthor("E2E Automation Using Cucumber - Rahul Shah");
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) webDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName+ ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
//				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		webDriverManager.getDriver().close();
		webDriverManager.getDriver().quit();
	}
 
	
	@Given("^User in on Mercury Tours Home Page$")
	public void user_in_on_Mercury_Tours_Home_Page() {
		webDriverManager= new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get(configfileReader.getApplicationUrl());
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.userOnHomePage();
		Report.updateTestValidation("User is on Login Page", "FlightRoundTrip", Status.PASS, driver);
	}
	
	@And("^Enter \"(.*)\" and \"(.*)\"$")
	public void enter_Username_and_Password(String userName, String Password) {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
	   stepPages.enterUsernameAndPassword(userName, Password);
	   Report.updateTestValidation("Username and Password is entered", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Click on SignIn Button$")
	public void click_on_SignIn_Button() {  
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.clickOnLoginBttn();
	}

	@When("^User navigate to mercury Reservation Page$")
	public void user_navigate_to_mercury_Reservation_Page() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
	    stepPages.verifyNavigationToFlightReseravtionPage();
	    Report.updateTestValidation("User navigate to mercury Reservation Page", "FlightRoundTrip", Status.PASS, driver);
	}

	@When("^Click on RoundTrip Radio button$")
	public void click_on_RoundTrip_Radio_button() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.clickOnRoundTripRadioBttn();
		Report.updateTestValidation("RoundTrip Radio button is Selected", "FlightRoundTrip", Status.PASS, driver);  
	}
	
	@When("^Click on OneWay Radio button$")
	public void click_on_Oneway_Radio_button() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.clickOnOnewayTripRadioBttn();
		Report.updateTestValidation("Oneway Radio button is Selected", "FlightOneWay", Status.PASS, driver);  
	}

	@Then("^Select Departing From dropdown option$")
	public void select_Departing_From_dropdown_option() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.selectDepartingFromDropdownOption();
		Report.updateTestValidation("Departing From dropdown option is Selected", "FlightRoundTrip", Status.PASS, driver);

	}

	@Then("^Select Arriving In dropdown option$")
	public void select_Arriving_In_dropdown_option() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.selectArrivingToDropdownOption();
		Report.updateTestValidation("Arriving In dropdown option is Selected", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Select Service ClassType radio button$")
	public void select_Service_ClassType_radio_button() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
	    stepPages.selectServiceClassRadioBttn();
	    Report.updateTestValidation("Service ClassType radio button is Selected", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Click on Continue button$")
	public void click_on_Continue_button() { 
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.clickOnContinueBttn();
		Report.updateTestValidation("Continue button is clicked", "FlightRoundTrip", Status.PASS, driver);
	}

	@When("^User navigate to Airline booking details Page$")
	public void user_navigate_to_Airline_booking_details_Page() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.verifyNavigationToBookingDetailsPage();
		Report.updateTestValidation("Airline booking details Page is displayed", "FlightRoundTrip", Status.PASS, driver);
	}

	@When("^Select Depart Flight details$")
	public void select_Depart_Flight_details() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.selectDepartFlightDetails();
		Report.updateTestValidation("Depart Flight details is selected", "FlightRoundTrip", Status.PASS, driver);
	}

	@When("^Select Return Flight details$")
	public void select_Return_Flight_details() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.selectReturnFlightDetails();
		Report.updateTestValidation("Return Flight details is selected", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Click Continue button$")
	public void click_Continue_Button() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.clickOnContinueBttn();
		Report.updateTestValidation("Continue button is clicked", "FlightRoundTrip", Status.PASS, driver);
	}

	@When("^User navigate to Book flight landing Page$")
	public void user_navigate_to_Book_flight_landing_Page() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.verifyNavigationToBookFlightLandingPage();
		Report.updateTestValidation("User navigate to Book flight landing Page", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Enter \"(.*)\" and \"(.*)\" of Customer$")
	public void enter_First_and_Last_name_of_Customer(String firstName, String lastName) {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.enterFirstAndLastName(firstName, lastName);
		Report.updateTestValidation("Enter Firstname and Lastname of Customer", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Enter Credit Card \"(.*)\"$")
	public void enter_Credit_Card(String cardNumber) {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.enterCreditCardNumber(cardNumber);
		Report.updateTestValidation("Enter Credit Card Number", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Click on Secure Purchase button$")
	public void click_on_Secure_Purchase_button() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.clickOnSecurePurchaseBttn();
		Report.updateTestValidation("Click on Secure Purchase button", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^User will navigate to Flight Confirmation Page$")
	public void user_will_navigate_to_Flight_Confirmation_Page() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.verifyNavigationToFlightConfirmationPage();
		Report.updateTestValidation("User navigate to Flight Confirmation Page", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^Ticket is booked Successfully$")
	public void ticket_is_booked_Successfully() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.verifyTicketBookingSucess();
		Report.updateTestValidation("Ticket is booked Successfully", "FlightRoundTrip", Status.PASS, driver);
	}

	@Then("^User Click on Back to Home button$")
	public void user_Click_on_Back_to_Home_Button() {
		CucumberHomePage stepPages = new CucumberHomePage(driver);
		stepPages.VerifyNavigationBackToHomePage();
		Report.updateTestValidation("User Click on Back to Home button", "FlightRoundTrip", Status.PASS, driver);
	}


}
