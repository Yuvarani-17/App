package com.Zenda.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Zenda.Base.BaseClass;

public class NewParentSignUpObjects extends BaseClass {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static Properties cred = new Properties();
	public static String NewParentEmail;
	public static String NewParentpswd;
	public String newEmail;
	public String newPaswd;
	public Properties prop;
	
//	NewParentEmail = getCredential().getProperty("NewParentEmail");
//	NewParentpswd = getCredential().getProperty("NewParentpswd");
	
	public NewParentSignUpObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*public Properties getCredential() {

		try {

			FileInputStream fis = new FileInputStream("./src/main/resources/Credentials.properties");
			prop = new Properties();

			prop.load(fis);

			newEmail = prop.getProperty("NewParentEmail");
			newPaswd = prop.getProperty("NewParentpswd");
			// String fname = prop.getProperty(&quot;firstname&quot;);

			System.out.println(newEmail);
			System.out.println(newPaswd);
			// System.out.println(fname);

			// InputStream input2 = new
			// FileInputStream("./src/main/resources/Credentials.properties");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cred;

	}*/

	@FindBy(xpath = "//*[@class='right']")WebElement ParentSignUp;
	@FindBy(xpath = "//*[@id='termsAndConditions']")WebElement termAcond;
	@FindBy(xpath = "//*[@id='agreeNotifications']")WebElement alertnotif;
	@FindBy(xpath = "//*[@id='btnSignUp']")WebElement Element;
	@FindBy(xpath = "//*[@id='email']") WebElement ParentEmail;
	@FindBy(xpath = "//*[@id='sendOTP']")WebElement sendOTP;
	@FindBy(xpath = "//*[@id='password']")WebElement Parentpswd;
	@FindBy(xpath = "//*[@id='emailErr']")WebElement Errormsg;
	@FindBy(xpath = "//*[@id='otp']")WebElement EnterOTP;
	@FindBy(xpath = "//*[@id='btnSignUp']")WebElement signupbtn;
	
	

	public boolean getParentEmail() throws InterruptedException {
		ParentEmail.sendKeys("sagar@mailinator.com");
		return true;
		
		//ParentEmail.sendKeys(newEmail);
		}

	public boolean getParentpswd() throws InterruptedException {
		Parentpswd.sendKeys("12");
		return true;
		
	}

	public boolean sendOTP() throws InterruptedException {
		sendOTP.click();
		return true;
	}

	public void enterOTP() throws InterruptedException {
		EnterOTP.sendKeys();
	}

	public WebElement getErrormsg() throws InterruptedException {
		return Errormsg;
	}

	public boolean clickParent() throws InterruptedException {
		ParentSignUp.click();
		return true;
	}

	public void termCondUnSelected() throws InterruptedException {
		alertnotif.isSelected();
	}

	public boolean notifUnSelected() throws InterruptedException {
		return termAcond.isSelected();
	}

	public void notifSelected() throws InterruptedException {
		termAcond.click();
	}

	public boolean termCondSelected() throws InterruptedException {
		alertnotif.click();
		return true;
	}

	public void scrollDown_uncheck() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.isDisplayed();
	}

	public boolean parentSignupbtn() throws InterruptedException {
		signupbtn.click();
		return true;
	}

	public void clear(WebElement ele) {
		ele.clear();

	}

	/*public boolean newParentEmail() {
		File NPE = new File(dir + getCredential().getProperty("NewParentEmail"));
		return true;
	}

	public void newParentpswd() {
		File NPP = new File(dir + getCredential().getProperty("NewParentpswd"));
	}*/
}
