package com.crm.gleantapauto.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class Task extends BaseTest{

	@Test
public void addTask() throws InterruptedException, IOException

{
	WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
	Wobj.FindWorkrooms();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 driver.findElement(By.xpath(".//a/span[contains(text(),'Tasks')]")).click();
	 driver.findElement(By.xpath("//*[@id=\"add-task-on-page-toggle\"]")).click();
	 if(driver.findElement(By.xpath("//span[contains(text(),'Add a Task') and @class='popup-center-title']")).isDisplayed())
	 {
		 //appointment title
		 driver.findElement(By.xpath("//*[@title='Task Title']")).click();
		 driver.findElement(By.xpath("//*[@title='Task Title']")).sendKeys("Task");
		 
		 driver.findElement(By.xpath("//input[@title='Due On']")).sendKeys("24-12-2023");
		 driver.findElement(By.xpath(".//*[@list='task_contact_persons']")).click();
		 driver.findElement(By.xpath(".//*[@list='task_contact_persons']")).sendKeys("test bhargavi  personal (bhargavi.gangapeta@gmail.com)");
			
		 List<WebElement> Contactperson= driver.findElements(By.xpath(".//*[@id='task_contact_persons']/child::option"));
             if (Contactperson.size()!=0)
             {
            	 ListIterator<WebElement> itr=Contactperson.listIterator();
            	 while(itr.hasNext())
            		 
            	 {
            		 int index=itr.nextIndex();
            		 String CPmatch =itr.next().getText();
            		 if(CPmatch.equalsIgnoreCase("test bhargavi  personal (bhargavi.gangapeta@gmail.com)"))
            		 {
            			 driver.findElement(By.xpath(".//*[@id='task_contact_persons']/child::option[\"+(index+1)+\"]")).sendKeys(Keys.ENTER);
            		 }
            			 
            	 }
             }
		 Select TaskType = new Select(driver.findElement(By.xpath(".//*[@title='Task Type']")));
		 TaskType.selectByVisibleText("Follow Up");
		 driver.findElement(By.xpath(".//*[@title='Task Description']")).sendKeys(" Testing Task Notes");
		driver.findElement(By.xpath(".//*[@title='Task Attachment']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\gleantapauto\\Testdata\\FileUpload.exe");
		Thread.sleep(5000);
		 driver.findElement(By.xpath(".//*[contains(@class,'add-task-on-page-submit')]")).submit();
		 Thread.sleep(5000);
		 System.out.println("Task added sucessfully");
	  
	
	
}
	 else {
		 System.out.println("unable to click on Add Task button");
	 }
}

}

