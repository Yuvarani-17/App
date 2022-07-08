package com.Zenda.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.Zenda.Base.BaseClass;


public class Listeners implements ITestListener{


	 public void onTestFailure(ITestResult result) {
	        try {
	            BaseClass.screenShot(result.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public void onTestSuccess(ITestResult result) {
	        try {
	            BaseClass.screenShot(result.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	    public void onTestSkipped(ITestResult result) {
	        // TODO Auto-generated method stub
	         System.out.println("Skipped Testcases are"+result.getName());  
	    }
	 
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // TODO Auto-generated method stub
	          System.out.println("FailedButWithinSuccessPercentage Testcases are : "+result.getName());  
	    }
	 
	    public void onStart(ITestContext context) {
	        // TODO Auto-generated method stub

	    }
	 
	    public void onFinish(ITestContext context) {
	        // TODO Auto-generated method stub

	    }
		@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}
}
