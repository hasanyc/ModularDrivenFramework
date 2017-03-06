package TestMethodAndLog4j;

import org.testng.annotations.Test;

import Base.Config;

public class testAllMethodWise extends Config{

	@Test
	public void linkTest (){
		APPLICATION_LOG.debug("Test case one");
	}
	@Test
	public void linkTest1 (){
		APPLICATION_LOG.debug("Test case 2");
	}
	@Test
	public void linkTest3 (){
		APPLICATION_LOG.debug("Test case 3");
	}
}
