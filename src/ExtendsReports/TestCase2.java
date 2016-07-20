package ExtendsReports;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase2 extends Reports{

	
	@Test
	public void hasanBhuiyan(){
		logger=report.startTest("Hasan");
		logger.log(LogStatus.INFO, "Application is up and running");
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Google")); 
		logger.log(LogStatus.PASS, "Title verified");
	}
}
