package com.tsg.CucumberFramework.Utility;

import org.openqa.selenium.WebDriver;


public interface TestValidation {
	
	//abstract method
    void updateTestValidation(String Expected, String ClassName, Status sta, WebDriver driver);
   
    public default void display() {
        
    }

}
