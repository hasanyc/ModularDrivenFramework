package TestMyAccount;

import org.testng.SkipException;
import org.testng.annotations.Test;
import Base.Config;
import Locators.MyAccountLocators;
import Values.MyAccountValues;

public class SkipATest extends Config {


	MyAccountLocators 	mal = new MyAccountLocators();
	MyAccountValues 	mav = new MyAccountValues();


	@Test 
	public void skippingTEST(){

		String actTitle = driver.getTitle();
		String expTtile = "talentTEK";
		if (actTitle.equals(expTtile)){
			System.out.println ("dont skip");
		} else 
			throw new SkipException ("Skipping test");
	}
}
