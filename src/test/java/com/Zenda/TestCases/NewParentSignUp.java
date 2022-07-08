package com.Zenda.TestCases;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Zenda.Base.BaseClass;
import com.Zenda.PageObjects.NewParentSignUpObjects;

public class NewParentSignUp extends BaseClass {

	NewParentSignUpObjects PSU = new NewParentSignUpObjects(driver);
	boolean NP;
	WebElement Preregemail;
	public static String dir = System.getProperty("user.dir");
//	String NewParentEmail = getCredential().getProperty("NewParentEmail");
//	String NewParentpswd = getCredential().getProperty("NewParentpswd");

	@BeforeClass
	public void browser() {
		try {
			launchBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("BrowserLaunch Failed");
		}
	}

	// --------Tries to log in with NEW Parent Credentials(TC-25,27)

/*	@Test(priority = 2)
	public void parentSignUpPage() {

		try {
			PSU.clear(ParentEmail);
			PSU.getParentEmail();
			// PSU.newParentEmail();
			PSU.sendOTP();
			PSU.enterOTP();
			// driver.get(NewParentpswd);
			PSU.getParentpswd();
			PSU.termCondSelected();
			PSU.notifUnSelected();
			System.out.println("Email does not exist in the school records go back and register");
  		} catch (InterruptedException e) {
			System.out.println("NewParentSignUp failed");
		}

	}*/

//--------Tries to log in with PreRegistered Parent Credentials(TC-28)	

@Test(priority = 1)
public void parentSignUp() {
	PSU = new NewParentSignUpObjects(driver);
	try {
		NP = PSU.clickParent();
		Preregemail = PSU.getErrormsg();
		if (NP = true) {
			PSU.getParentEmail();
			PSU.sendOTP();
			if (Preregemail != null) {
				System.out.println("Looks like you're already signed up. Please login!");
			} else {
				PSU.enterOTP();
				PSU.getParentpswd();
				PSU.termCondSelected();
				PSU.notifUnSelected();
			}
		} else {
			System.out.println("Parent didn't signUP");
		}
	} catch (InterruptedException e) {
		System.out.println("PreRegistered Parent login failed");

	}

}
}
