package ExtendsReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Util.WebDriverFunctions;

public class Reports {
	ExtentReports report = new ExtentReports(System.getProperty ("user.dir")+"//Report//talentTEK.html");
	ExtentTest logger; 
	WebDriver driver;

	@BeforeMethod
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.taltekc.com");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String screenshot_path=WebDriverFunctions.captureScreenshot(result.getName());
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);
		}
		report.endTest(logger);
		report.flush();
		driver.close();
	}
	
	@AfterSuite
	public void atEnd (){
		driver.quit();
	}



} // class end