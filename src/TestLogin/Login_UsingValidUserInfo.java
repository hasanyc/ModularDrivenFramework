package TestLogin;

import org.testng.annotations.Test;
import Base.Config;
import Util.loginPageObject;
import Values.LoginValues;

public class Login_UsingValidUserInfo extends Config {

	LoginValues		loginVal = new LoginValues();
	loginPageObject	lpageObject = new loginPageObject ();
	
	
	@Test
	public void logIn_validUserInfoTest(){
		lpageObject.logIn ("HASAN@", loginVal.passwordValue);
		
	}
}
