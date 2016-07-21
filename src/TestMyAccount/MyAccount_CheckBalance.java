package TestMyAccount;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import Base.Config;
import Locators.MyAccountLocators;
import Values.MyAccountValues;

public class MyAccount_CheckBalance extends Config {

	
	MyAccountLocators 	mal = new MyAccountLocators();
	MyAccountValues 	mav = new MyAccountValues();
	
	
	@Test
	public void myAccount_CheckBalanceTest(Method method){
		String testName = method.getName();
		captureScreenshot (testName);
		APPLICATION_LOG.debug("scheenshot name is " +testName+".png");
	}
}
