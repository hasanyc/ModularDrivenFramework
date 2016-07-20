package Util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverFunctions {


	protected WebDriver driver;

	public void typeByXPath (String locator, String value){
		driver.findElement(By.xpath(locator)).sendKeys (value);
	}

	public static String captureScreenshot (WebDriver driver, String screenshotName ){
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String dest  = ("C:\\Users\\hassan.bhuiyan\\workspace\\ModularDriverFramework\\screenShot\\"+screenshotName+".png");
			File destination = new File (dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Sceenshot taken");
			return screenshotName;

		} catch (Exception e) {
			System.err.println ("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}
	}

	public void startTime (){
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter= new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a"); //format it as per your requirement
		t = formatter.format(date);
		System.out.println("Test start at: ==>>  " + t);
	}
	public static void endTime (){
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter= new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a"); //format it as per your requirement
		t = formatter.format(date);
		System.out.println("Test end at: ==>>  " + t);
	}

}


