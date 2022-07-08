package com.Zenda.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Zenda.Base.BaseClass;

public class LoginPageObjects extends BaseClass{

	
	public LoginPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='txtuser']")
    private WebElement UserID;
    @FindBy(xpath = "//input[@id='txtpassword']")
    private WebElement Password;
    @FindBy(xpath = "//button[@id='log-btn']")
    private WebElement loginbutton;
    @FindBy(xpath = "//span[@text()='Password should be minimum 6 chracters']")
    private WebElement PasswordErrorMsg;
    @FindBy(xpath = "//span[@text()='User ID should be minimum 6 characters']")
    private WebElement UserIDErrorMSg;

    public void enterUserID(String Userid) throws InterruptedException {
        UserID.sendKeys(Userid);
        
    }
    public void enterPassword (String password) throws InterruptedException {
        Password.sendKeys(password);
        }
    public void clickLogin() throws InterruptedException {
        loginbutton.click();
        
    }
    public String getUserIDError() {
        return UserIDErrorMSg.getText();
    }
    public String getPasswordErrorMsg() {
        return PasswordErrorMsg.getText();
    }
    public void clearPassword() throws InterruptedException {
         Password.clear();
    }
    public void clearUserID() throws InterruptedException {
     
        UserID.clear();
     }
    public void completeLogin(String Userid,String password) throws InterruptedException {
        UserID.sendKeys(Userid);
        Password.sendKeys(password);
        loginbutton.click();
       
    }

	
}
