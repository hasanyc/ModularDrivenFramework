package TestMyAccount;

import org.testng.annotations.Test;

import Base.Config;
import Locators.MyAccountLocators;
import Values.MyAccountValues;

public class MyAccount_CheckBalance extends Config {

	
	MyAccountLocators 	mal = new MyAccountLocators();
	MyAccountValues 	mav = new MyAccountValues();
	
	
	@Test
	public void myAccount_CheckBalanceTest(){
		String url = System.getProperty("user.dir");
		System.out.println(url);
	}
}
