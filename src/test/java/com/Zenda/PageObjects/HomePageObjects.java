package com.Zenda.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

	public HomePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	@FindBy(xpath = "//*[@id='sidebar']")WebElement sidebar;

	 public void getSidebar() throws InterruptedException {
		 sidebar.isDisplayed();
	    }

}
