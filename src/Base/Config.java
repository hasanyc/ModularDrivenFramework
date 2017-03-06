package Base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Util.WebDriverFunctions;


public class Config extends WebDriverFunctions{

	public static Logger APPLICATION_LOG = Logger.getLogger("devpinoyLogger");
	protected static  String baseUrl = "http://wwww.taltekc.com/";


	@BeforeSuite
	public void beforeSuite(){
		startTime();
		System.out.println("");
	}

	@Parameters("Browser")
	@BeforeClass
	public void setUp(String browserName) throws MalformedURLException{
		if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe"));
			driver=new FirefoxDriver();
			APPLICATION_LOG.debug ("Firefox has been selected");
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",(System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe"));
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  
			driver = new InternetExplorerDriver(dc);
			driver.manage().deleteAllCookies();
			APPLICATION_LOG.debug ("IE has been selected");
		} else if (browserName.equalsIgnoreCase("ch")){
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();
			APPLICATION_LOG.debug("Google Chrome is selected");
		} else if (browserName.equalsIgnoreCase("Safari")){
			driver = new SafariDriver();
			APPLICATION_LOG.debug("Safari has been selected");
		} else if (browserName.equalsIgnoreCase("iOS")){
			new RemoteWebDriver(new URL("http://localhost:3001/driver/hub"), DesiredCapabilities.ipad());
			APPLICATION_LOG.debug("iOS is selected To do the Cross Browser Test");
		} else {      
			throw new IllegalArgumentException("The Browser Type is Undefined");  
		}

		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod()
	public void beforeEachMethod(Method method){
		String testName = method.getName();
		APPLICATION_LOG.debug("==========================================================================================================");
		APPLICATION_LOG.debug("Test Method is: ==> " +testName+ " Just S-T-A-R-T-E-D");
		APPLICATION_LOG.debug("==========================================================================================================");
	}


	@AfterMethod
	public void afterEachMethod(Method method){
		String testName = method.getName();
		APPLICATION_LOG.debug("==========================================================================================================");
		APPLICATION_LOG.debug("Test Method is: ==> " +testName+ " Just E-N-D-E-D");
		APPLICATION_LOG.debug("==========================================================================================================");

	}

	@AfterClass
	public void closeConn (){
		driver.close();
	}
	@AfterSuite
	public static void tearDown (){
		System.out.println("");
		endTime();
		try{
			driver.quit();

		} catch (Exception e) {
			APPLICATION_LOG.debug(e);
		}
	}


	// SUITE STARTE TIME AND END TIME METHOND
	public void startTime (){
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter= new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a"); //format it as per your requirement
		t = formatter.format(date);
		System.out.println("Test start at: ==>>  " + t);
		APPLICATION_LOG.debug("Test Suite started at: ==>>  " + t);
		APPLICATION_LOG.debug("");
	}

	public static void endTime (){
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter= new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a"); //format it as per your requirement
		t = formatter.format(date);
		System.out.println("Test end at: ==>>  " + t);
		APPLICATION_LOG.debug("Test Suite Ended at: ==>>  " + t);
	}
}
