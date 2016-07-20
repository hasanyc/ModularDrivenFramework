package TestLogin;

import org.testng.annotations.Test;

import Base.Config;
import Locators.LoginLocators;
import Values.LoginValues;

public class Login_WithoutValidPass extends Config {

	
	LoginLocators 	loginLoc = new LoginLocators();
	LoginValues		loginVal = new LoginValues();
	
	@Test
	public void logIn_WithoutValidPasswordTest(){
		
	}
}
