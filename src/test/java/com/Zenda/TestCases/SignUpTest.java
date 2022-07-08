package com.Zenda.TestCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Zenda.Base.BaseClass;
import com.Zenda.PageObjects.HomePageObjects;
import com.Zenda.PageObjects.NewParentSignUpObjects;
import com.Zenda.PageObjects.SignUpObjects;

public class SignUpTest extends BaseClass {

	SignUpObjects SignUp;
	HomePageObjects Home;
	NewParentSignUpObjects PSU;
	public static String dir = System.getProperty("user.dir");
	public static Properties Data;
	
	@BeforeClass
	public void browser() {
		try {
			launchBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("BrowserLaunch Failed");
		}
	}	
	
	
//-----Navigates to login page if the user already logged in using same Email Id(TC-22,24)
	//---PSU : ParentSignUp Object class
	
	@Test(priority=1)
	public void parentSignUp() {
		PSU = new NewParentSignUpObjects(driver);
		try {
			PSU.clickParent();
			PSU.getParentEmail();
			PSU.sendOTP();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='emailErr']")));
			Thread.sleep(5000);
			String error = PSU.getErrormsg().getText();
			System.out.println("Error message : " + error );
			PSU.scrollDown_uncheck();
			System.out.println("Scrolled down to Terms and conditions and its not selected");
			PSU.termCondUnSelected();
			PSU.notifSelected();
			System.out.println("Couldn't login because of not selecting the T&C button - PASSED");
			driver.navigate().back();
			driver.navigate().forward();
			} catch (InterruptedException e) {
				System.out.println("ParentSignUp done");
			}
		
	}	
	

//------User login using Pre registered parent credentials (TC-23)
	
	@Test(priority=2)
	public void signUpValidation() {
		SignUp = new SignUpObjects(driver);
			try {			
			SignUp.schoolLogo();
			System.out.println("SignUp Page displayed");
			SignUp.emailID();
			SignUp.enterPassword();
			SignUp.clickLogin();
		} catch (InterruptedException e) {
			System.out.println("Parent SignUp Failed");
		}
			System.out.println("ParentSignUp done successfully");
	}
	
		

}




