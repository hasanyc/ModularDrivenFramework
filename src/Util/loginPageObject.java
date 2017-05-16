package Util;

import Base.Config;
import Locators.LoginLocators;

public class loginPageObject extends Config{
	
	LoginLocators ll = new LoginLocators ();
	
	public void logIn (String userName, String password){
		
		// this function will help me to just login to my application
		typeByXPath (ll.emailOrPhoneEditBox, userName);
		typeByXPath (ll.passwordLocator, password);
		clickByXPath (ll.loginButtonLocator);
		
	}
}