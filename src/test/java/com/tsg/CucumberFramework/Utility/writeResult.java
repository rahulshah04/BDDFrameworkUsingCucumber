package com.tsg.CucumberFramework.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.tsg.CucumberFramework.MultiScreenshot.multipleScreenshot;


public class writeResult implements TestValidation {
	
	multipleScreenshot takeScreenShot = new multipleScreenshot();
	public String path = "..//CucumberFramework//Result//TS_";
	
	private static List<Result> details = new ArrayList<Result>();
	private static final String templatePath = "..\\CucumberFramework\\HTMLReports";
			
	public writeResult() {
	}
	
	@Override
	public void updateTestValidation(String expected, String className, Status status, WebDriver driver) {
		if(status == Status.PASS || status == Status.FAIL || status == Status.SCREENSHOT) {
//			System.out.println(expected+", "+className+", "+status);
			takeScreenShot.MultiScreenShot(path, className);
			try {
				takeScreenShot.multiScreenShot(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println(expected+", "+className+", "+status);
		}

//		System.out.println(details);
		if(status == Status.PASS) {
			Result r = new Result(expected, "PASS", path);
			details.add(r);			
		} 
		else if(status.equals(Status.FAIL)) {
			Result r = new Result(expected, "FAIL", path);
			details.add(r);
		}
		else if(status.equals(Status.SCREENSHOT)) {
			Result r = new Result(expected, "SCREENSHOT", path);
			details.add(r);
		}
		else if(status.equals(Status.NA)) {
			Result r = new Result(expected, "NA", "");
			details.add(r);
		}

//		System.out.println();
		File file = new File("HTMLTestReport.html");

		//Create the file
		try {
			if (file.createNewFile()){
				System.out.println("\n" +"File is created!");

			}else{
//				System.out.println("\n" +"File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String filename = "HTMLTestReport.html";
		StringBuilder html = new StringBuilder("");
		String dataString = "";

		//Write Content
		try {
			FileWriter fwr = new FileWriter(filename);
			fwr.flush();
			fwr.close();
			File filepathName = new File(filename);
			FileWriter fw = new FileWriter(filepathName.getName(), true); // the true will append the new data
			String filePath = filepathName.getAbsolutePath();
//			System.out.println("File Path = " + filePath);

			String tmp = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \r\n"
					+ "\"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + "<html>\r\n" + "<head>\r\n"
					+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
					+ "<title>TestReport</title>\r\n" + "</head>\r\n" + "<body><header>E2EAutomation_TestSuite_"+className+"</header><table width ='90%' border=\"1\"><tr><th bgcolor=\"#9999cc\">S.No.</th><th bgcolor=\"#9999cc\">Expected Result</th><th bgcolor=\"#9999cc\">Status</th><th bgcolor=\"#9999cc\">ScreenShot</th></tr>$table$</table>\r\n"
					+ "</body>\r\n" + "</html>";

			for (int i = 0;i < details.size();i++) {
				String colorStyle ="";
				if((details.get(i).getResultText()).equals("FAIL")){
					colorStyle ="#FF0000";	
				}
				else {
					colorStyle ="#32CD32";	
				}
				dataString = "<tr>" + "<td withd='5%'>" + (i + 1) + "</td>" + "<td width ='25%'>" + details.get(i).getResult()
						+ "</td>" + "<td width='10%' style='color:"+colorStyle+";'>" + details.get(i).getResultText() + "</td>" + "<td width='60%'><img src="+details.get(i).getPath()+className+"_Screenshots"
						+ "/screenShot"+(i + 1)+".jpg alt=\"Screenshot face\" height='40%' width='100%'></td></tr>";

//				System.out.println(details.get(i).getPath());

				html.append(dataString);
				dataString = "";
			}
//			System.out.println("dataString**********");
//			System.out.println(html);
			String replaceString = tmp.replace("$table$", html);
//			System.out.println("Final**********");
//			System.out.println(replaceString);
			fw.write(replaceString);// appends the string to the file
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
}
