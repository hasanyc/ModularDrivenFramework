package Util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverFunctions {


	protected static WebDriver driver;
	
	public void typeByXPath (String locator, String value){
		driver.findElement(By.xpath(locator)).sendKeys (value);
	}

	public static String captureScreenshot (String screenshotName ){
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String dest  = (System.getProperty ("user.dir")+"//screenShot//"+screenshotName+".png");
			File destination = new File (dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Sceenshot taken");
			return screenshotName;

		} catch (Exception e) {
			System.err.println ("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}
	}

	
}


