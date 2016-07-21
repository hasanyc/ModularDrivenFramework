package Util;

import org.testng.IExecutionListener;

import Base.Config;

public class ExecutionListener1 extends Config implements IExecutionListener {

	 private long startTime;

	@Override
	public void onExecutionStart() {
		startTime = System.currentTimeMillis();
		System.out.println("Hasan, Your Automation Test is going to start.....");  
		System.out.println("");
		
		APPLICATION_LOG.debug ("Hasan, Your Automation Test is going to start.....");
		APPLICATION_LOG.debug ("");
		
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("");
		System.out.println("Automation Test took around " + (System.currentTimeMillis() - startTime) + " ms");
			
		APPLICATION_LOG.debug ("");
		APPLICATION_LOG.debug ("Automation Test took around " + (System.currentTimeMillis() - startTime) + " ms");
		
		
	}

}
