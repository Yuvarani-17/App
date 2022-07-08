package com.Zenda.TestCases;



import org.testng.annotations.Test;

import com.Zenda.Base.BaseClass;


public class LoginTest extends BaseClass {
	@Test
	private void login() {
	 try {
		launchBrowser();
	} catch (Exception e) {
		System.out.println("Regression browser open");
		
	}
	}
}
