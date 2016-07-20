package ExtendsReports;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase1 extends Reports{
	
	@Test
	public void taltekcTEST(){
		logger=report.startTest("TalTek");
		logger.log(LogStatus.INFO, "Application is up and running");
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Google")); 
		logger.log(LogStatus.PASS, "Title verified");
	}

	@Test
	public void taltekcTest2(){
		logger=report.startTest("TalTek 2");
		logger.log(LogStatus.INFO, "Application is up and running");
		logger.log(LogStatus.PASS, "Title verified");
	}

}
