package com.Zenda.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.Zenda.Base.BaseClass;
import com.Zenda.PageObjects.LoginPageObjects;
import com.Zenda.Utilities.Utilities;

public class ValidationTest extends BaseClass {

	LoginPageObjects Login;
	Utilities NIK;
	SoftAssert Soft;

	@BeforeClass
	public void BaseActivity() {
		
		
		//Browser launch
		
		try {
			launchBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login = new LoginPageObjects(driver);
		NIK = new Utilities();
		Soft = new SoftAssert();
	}

	
	@Test
	public void userIDErrorValidation() throws EncryptedDocumentException, InterruptedException, IOException {

		//fetching data excelsheet
		
		Login.enterUserID(Utilities.GetExcelData("Sheet1", 1, 0));
		Login.enterPassword(Utilities.GetExcelData("Sheet1", 1, 1));
		
//    	Login.EnterUserID(Utilities.GetExcelData("Sheet1", 2, 0));
//    	Login.ClickLogin();
//        String Actual = Login.GetUserIDError();
//        String Expected = Utilities.GetExcelData("Sheet4", 1, 0);
//        Soft.assertEquals(Actual, Expected,"Test Failed");
//        Soft.assertAll();
//    }
//    public void PasswordValidation() throws EncryptedDocumentException, InterruptedException, IOException {
//    	Login.EnterPassword(Utilities.GetExcelData("Sheet1", 2, 1));
//        Login.ClickLogin();
//        String Actual = Login.GetPasswordErrorMsg();
//        String Expected = Utilities.GetExcelData("Sheet4", 1, 1);
//        Soft.assertEquals(Actual, Expected,"Test Failed");
//        Soft.assertAll();
	}

	
	// Quit browser
	@AfterClass
	private void terminateBrowser() throws InterruptedException {
		
		driver.quit();
	}

}
