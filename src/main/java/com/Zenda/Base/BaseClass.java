package com.Zenda.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;
	public static String dir = System.getProperty("user.dir");
	public static Properties Path = new Properties();
	public static Properties Data = new Properties();;
	public static String browser;
	public static String URL;

	//Launch the browser based on the properties
	
	public static void launchBrowser() throws Exception {

		browser = getData().getProperty("browser");
		URL = getData().getProperty("URL");

		if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.out.println(dir + getPath().getProperty("chromepath"));
			try {
				System.setProperty("webdriver.chrome.driver", dir + getPath().getProperty("chromepath"));
				// create chrome instance
				driver = new ChromeDriver();
			} catch (Exception e) {
				System.out.println("Chromedriver not found");
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance

			try {
				System.setProperty("webdriver.gecko.driver", dir + getPath().getProperty("firefoxpath"));
				driver = new FirefoxDriver();
			} catch (Exception e) {
				System.out.println("Firefox not found");

			}
		} else if (browser.equalsIgnoreCase("Edge")) {
			// set path to IE.exe

			try {
				System.setProperty("webdriver.edge.driver", dir + getPath().getProperty("edgepath"));

				driver = new EdgeDriver();
			} catch (Exception e) {
				System.out.println("Edge is not found");
			}
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

//	System.setProperty("webdriver.chrome.driver", chromepath);
//	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	//Load the path properties
	
	public static Properties getPath() {

		try {
			InputStream input = new FileInputStream(dir + "\\src\\main\\resources\\Path.properties");
			Path.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Path;

	}
	//Load the Data properties
	public static Properties getData() {

		try {

			InputStream input1 = new FileInputStream(dir + "\\src\\main\\resources\\Data.properties");
			Data.load(input1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Data;

	}

	//Take screenshot based on the TC name
	public static void screenShot(String Name) throws IOException {
		Date D = new Date();
		DateFormat Df = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String FD = Df.format(D);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(dir + getPath().getProperty("Screenshotpath") + Name + FD + ".png");
		FileHandler.copy(src, dest);
	}

}
