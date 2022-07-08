package com.Zenda.TestCases;

import org.testng.annotations.Test;

import com.Zenda.PageObjects.HomePageObjects;
import com.Zenda.PageObjects.SignUpObjects;

public class HomePageTest extends SignUpTest{
	
	HomePageObjects Home;
	
	
//----redirected to the second page of signup when clicked on the submit button(TC-12)
	
	@Test(priority=3)
	public void homePage() {
		Home = new HomePageObjects(driver);
			try {			
			Home.getSidebar();
		} catch (InterruptedException e) {
			System.out.println("Parent SignUp Failed");
		}
			System.out.println("HomePage Landed successfully");
	}


}
