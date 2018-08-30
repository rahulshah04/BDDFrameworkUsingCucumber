package com.tsg.CucumberFramework.TestSuites;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.tsg.CucumberFramework.dataProvider.ConfigFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		format = {"pretty", "json:target/json/output.json"}
		,features = "src/test/resources/featurefile/End2EndTest.feature"
		,glue= {"com.tsg.CucumberFramework.StepDefinitions"}
//		,tags= {"@FlightRoundTrip"}
		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)

public class TestRunner {
	
	static ConfigFileReader ConfigfileReader = new ConfigFileReader();
	
	@AfterClass
	
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(ConfigfileReader.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.11.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_131");
	}
}
