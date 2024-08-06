package com.crm.gleantapauto.tests;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.pageobjects.loginObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class appointment extends BaseTest{
	

	@Test
	public void addappointment()  throws InterruptedException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.findElement(By.xpath(".//a/span[contains(text(),'Appointments')]")).click();
		 driver.findElement(By.xpath("//*[@id=\"add-appointment-on-page-toggle\"]")).click();
		 if(driver.findElement(By.xpath("//*[contains(text(),'Create Appointment')]")).isDisplayed())
		 {
			 //appointment title
			 driver.findElement(By.xpath("//*[@title='Appointment Title']")).click();
			 driver.findElement(By.xpath("//*[@title='Appointment Title']")).sendKeys("AppoTest");
			 
			 driver.findElement(By.xpath("//input[@title=\"Appointment Due On\"]")).sendKeys("21-12-2023");
			 driver.findElement(By.xpath(".//*[@class='start_time']")).sendKeys("10:30");
			 driver.findElement(By.xpath(".//*[@class='start_time']")).sendKeys("11:30");
			 driver.findElement(By.xpath(".//*[@list='appointment_contact_persons']")).click();
			 driver.findElement(By.xpath(".//*[@list='appointment_contact_persons']")).sendKeys("test bhargavi  personal (bhargavi.gangapeta@gmail.com)");
				
			 List<WebElement> Contactperson= driver.findElements(By.xpath(".//*[@id='appointment_contact_persons']/child::option"));
                 if (Contactperson.size()!=0)
                 {
                	 ListIterator<WebElement> itr=Contactperson.listIterator();
                	 while(itr.hasNext())
                		 
                	 {
                		 int index=itr.nextIndex();
                		 String CPmatch =itr.next().getText();
                		 if(CPmatch.equalsIgnoreCase("test bhargavi  personal (bhargavi.gangapeta@gmail.com)"))
                		 {
                			 driver.findElement(By.xpath(".//*[@id='appointment_contact_persons']/child::option[\"+(index+1)+\"]")).sendKeys(Keys.ENTER);
                		 }
                			 
                	 }
                 }
			 driver.findElement(By.xpath(".//*[@id='contact_invite']")).click();
			 Select assignedTo = new Select(driver.findElement(By.xpath(".//*[@title='Appointment Assigned To']")));
			 assignedTo.selectByVisibleText("Madhu");
			 Select appointmentType = new Select(driver.findElement(By.xpath(".//*[@title='Appointment Type']")));
			 appointmentType.selectByVisibleText("ZOOM");
			 driver.findElement(By.xpath(".//*[@title='Appointment Notes']")).sendKeys(" Testing Notes");
			 driver.findElement(By.xpath(".//*[contains(@class,'add-appointment-on-page-submit')]")).submit();
			 Thread.sleep(5000);
			 System.out.println("Appointment created sucessfully");
		 
		
		
	}
		 else {
			 System.out.println("unable to click on Add appointments button");
		 }
	}

}
