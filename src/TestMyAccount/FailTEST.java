package TestMyAccount;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.Config;
import Locators.MyAccountLocators;
import Values.MyAccountValues;

public class FailTEST extends Config {

	
	MyAccountLocators 	mal = new MyAccountLocators();
	MyAccountValues 	mav = new MyAccountValues();
	
	
	@Test
	public void failTestTesting(Method method){
		String testName = method.getName();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Google"));
		captureScreenshot (testName);
		APPLICATION_LOG.debug("scheenshot name is " +testName+".png");
	}
}