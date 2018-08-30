package com.tsg.CucumberFramework.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2ETest {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Projects//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		
		WebElement findFlight = driver.findElement(By.xpath("//*[@src='/images/hdr_findflight.gif']"));
		if(findFlight.isDisplayed()) {
			System.out.println("User is on Login Page");
			driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("rahulshah1092@gmail.com");
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("rahul@1992");
			driver.findElement(By.xpath("//*[@name='login']")).click();
			WebElement flightFinder = driver.findElement(By.xpath("//*[@src='/images/masts/mast_flightfinder.gif']"));
			if(flightFinder.isDisplayed()) {
				System.out.println("User is on Flight Finder Launch Page");
				WebElement tripTypeRound = driver.findElement(By.xpath("//*[@name='tripType' and @value='roundtrip']"));
				if(tripTypeRound.isSelected()) {
					System.out.println("Round Trip is selected");
					WebElement passengerCount = driver.findElement(By.xpath("//*[@name='passCount']"));
					Select oselectPassCounty = new Select(passengerCount);
					oselectPassCounty.selectByIndex(0);
					
				}
				else {
					tripTypeRound.click();
				}
			}
			else {
				System.out.println("User is not Flight Finder Launch Page");
			}
		}
		else {
			System.out.println("User is not on Login Page");
		}
		
//		driver.quit();
	}

}
