package com.Zenda.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Zenda.Base.BaseClass;


public class SignUpObjects extends BaseClass {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	

	public SignUpObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
//
//	String filePath = "./Datasheet.xlsx";
//	ExcelDataHandler readDataFromExcel = new ExcelDataHandler();
//
//	String parent = readDataFromExcel.getCellData(filePath,"Exam_Assessment",1,0); 
//	
	
	
	//--------SignUp page Elements--------//	
	
	@FindBy(xpath = "//input[@id='txtuser']")WebElement UserID;
	@FindBy(xpath = "//input[@id='txtpassword']")WebElement Password;
    @FindBy(xpath = "//button[@id='log-btn']")WebElement loginbutton;
    @FindBy(xpath = "//*[@class='school-logo']")WebElement schoollogo;
    @FindBy(xpath = "//*[@id='btn-login-microsoft']")WebElement Microsoft;
    @FindBy(xpath = "//*[@id='btn-login-google']")WebElement Google;
    @FindBy(xpath = "//*[@id='btn-login-linkedIn']")WebElement Linkedin;
   
    

    public void emailID() throws InterruptedException {
        UserID.sendKeys("sagar@mailinator.com");
        
    }
    public void enterPassword () throws InterruptedException {
        Password.sendKeys("12");
        }
    public void clickLogin() throws InterruptedException {
        loginbutton.click();
        
    }
    
    public void schoolLogo() throws InterruptedException {
        schoollogo.isDisplayed();
    }
    
    public void getMicrosoft() throws InterruptedException {
    	Microsoft.isDisplayed();
    }
    
    public void getGoogle() throws InterruptedException {
    	Google.isDisplayed();
    }
    public void getLinkedin() throws InterruptedException {
    	Linkedin.isDisplayed();
    }
    
    
}
