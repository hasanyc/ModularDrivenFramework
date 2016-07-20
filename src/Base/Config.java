package Base;

import java.lang.reflect.Method;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import Util.WebDriverFunctions;


public class Config extends WebDriverFunctions{

	@BeforeSuite
	public void beforeSuite(){
		startTime();
		System.out.println("");
	}

	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String browser, Method method){
		if(browser.equalsIgnoreCase("FF")){
			driver=new FirefoxDriver();
		} else 
			System.out.println("Chrome driver");
		
		driver.manage().window().maximize();
		driver.get ("http://www.facebook.com");
		String testName = method.getName();
//		Log4j.APPLICATION_LOG.debug("==========================================================================================================");
//		Log4j.APPLICATION_LOG.debug("Test Method is: ==> " +testName+ " Just S-T-A-R-T-E-D");
//		Log4j.APPLICATION_LOG.debug("==========================================================================================================");
	}

	@AfterMethod
	public void browserClose(Method method){
		String testName = method.getName();
//		Log4j.APPLICATION_LOG.debug("==========================================================================================================");
//		Log4j.APPLICATION_LOG.debug("Test Method is: ==> " +testName+ " Just E-N-D-E-D");
//		Log4j.APPLICATION_LOG.debug("==========================================================================================================");
		driver.close();
	}

	@AfterSuite
	public void tearDown(){
		System.out.println("");
		endTime();
		driver.quit();
	}

}
