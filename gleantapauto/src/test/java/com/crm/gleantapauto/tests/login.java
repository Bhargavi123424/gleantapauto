package com.crm.gleantapauto.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.pageobjects.loginObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;



public class login  extends BaseTest{
	

	@Test
	public void Verifylogin() throws InterruptedException {
		
		
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		String title = driver.findElement(By.xpath(".//*[contains(@class,'avatar')]/div")).getText();
		System.out.println("Title is " + title);
		if (title != null) {
			System.out.println("login successfull");
			
			Wobj.FindWorkrooms();
			
		} else {
			System.out.println("Not able to login");
		}
		
		
	}
	
	
	
}
