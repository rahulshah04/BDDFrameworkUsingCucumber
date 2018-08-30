package com.tsg.CucumberFramework.MultiScreenshot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class multipleScreenshot {
	
	//screenshot number	
	int screenShotNumber;
		
		//element screenshot number
	int elementPart;
		
		//screen shot path
	String screenShotPathAndFileName=null;
		
		//element path
	String elementPath=null;
		
		//element file name
	String elementFileName=null;
		
		//full screenshot path
	String screenShotPath=null;
		
	public void MultiScreenShot(String path,String className)
	{
			
		//save the path to elementPath
	elementPath=path+className+"_Screenshots\\";
			
		//add element as subname
	elementFileName=elementPath+"element";
			
	screenShotPath=path+className+"_Screenshots\\";
			//path and filename
			screenShotPathAndFileName = screenShotPath+"screenShot";
			
			//create the directory with classname
			new File(screenShotPathAndFileName).mkdir();
		}
		
			//method to take screenshot of the whole webpage
			public void multiScreenShot(WebDriver driver) throws IOException
			{
				//increase the screenshot number
				screenShotNumber++;
			
				//screenshot taking lines this line is to capture screenshot
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
				//to save the screenshot
				FileUtils.copyFile(scrFile, new File(screenShotPathAndFileName+screenShotNumber+".jpg"));
		}
		
			//method to take screenshot of the element of the  webpage
			public void elementScreenShot( WebDriver driver,WebElement element) throws IOException  
		    {
				//increase the element number so that you can take screenshot name as 1,2,3
				elementPart++;
				
				//call the screenshot function so it takes the screenshot as image
		        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        //get location of the element
		        Point point = element.getLocation();
		        
		        //get the height of the element
		        int width = element.getSize().getWidth();
		        
		        //get the width of the element
		        int height = element.getSize().getHeight();
		        	        
		 	    //read the image
		        BufferedImage img = ImageIO.read(screen);
		        
		        //crop the image
		        BufferedImage dest = img.getSubimage(point.getX(), point.getY(), width, height);
		 
		        
		        ImageIO.write(dest, "png", screen);
		        
		        //save the image on specific path
		        FileUtils.copyFile(screen, new File(elementFileName+elementPart+".png"));
		 	    	 
		    }
		  
			//method to mininmize the browser
			public void minimize() throws AWTException
			{
			
				Robot rr=new Robot();
			
				//press the robot key with help of robot class
				rr.keyPress(KeyEvent.VK_WINDOWS);
			
				//press down arrow key
				rr.keyPress(KeyEvent.VK_DOWN);
	    	
				//realease the down arrow key
				rr.keyRelease(KeyEvent.VK_DOWN);
	   	
				//release the windows key
				rr.keyRelease(KeyEvent.VK_WINDOWS);
			}

}
