package com.crm.gleantapauto.testscomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.pageobjects.loginObjects;
import com.crm.gleantapauto.tests.loginTest;



public class BaseTest {
	
	public WebDriver driver;
	public loginObjects logOb;
	public loginTest logverify;
	
	
	public WebDriver initializeDriver()
	{
		System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\HP\\OneDrive\\Documents\\chromedriver-win64");
		 driver= new ChromeDriver();
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
   public loginObjects LaunchApplication() throws InterruptedException
   {
	    driver =initializeDriver();
	    logOb = new loginObjects(driver);
		logOb.Navigate();
		return logOb;
	}
  
   @AfterMethod(alwaysRun=true)
	
	public void tearDown()
	{
		driver.close();
	}
  
}
