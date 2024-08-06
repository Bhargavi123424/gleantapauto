package com.crm.gleantapauto.tests;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class Pages extends BaseTest {
	
	
	@Test
	public void createPage() throws InterruptedException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(".//span[contains(text(),'Forms & Pages')]")).click();
		driver.findElement(By.xpath(".//a[@class='animsition-link']/child::span[contains(text(),'Pages')]")).click();
		driver.findElement(By.xpath(".//button[@id='fromscratchbtn']")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'Pick a Template to Continue')]")));
		if(driver.findElement(By.xpath(".//*[contains(text(),'Pick a Template to Continue')]")).isDisplayed())
		{
			WebElement page= driver.findElement(By.xpath("(.//figcaption)[1]"));
			Actions action=new Actions(driver);
			action.moveToElement(page);
			driver.findElement(By.xpath("(//a[contains(text(),'Start')])[1]")).click();
			
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page']")));
			Thread.sleep(3000);
			WebElement frame=driver.findElement(By.xpath(".//*[@id='editor-container']/iframe"));
			
			if(element.isDisplayed())
			{
				driver.switchTo().frame(frame);
			List<WebElement> components=driver.findElements(By.xpath(".//div[@class='blockbuilder-content-tool']/div[2][@class='blockbuilder-content-tool-name']"));
			int length=components.size();
			System.out.println("Size is "+length);
		
			for(int j=1;j<=length;j++)
	        {
 
	       	   WebElement pagetype= driver.findElement(By.xpath("(.//div[@class='blockbuilder-content-tool']/div[2][@class='blockbuilder-content-tool-name'])["+j+"]"));
	       	   WebElement destination=driver.findElement(By.xpath(".//div[@class='blockbuilder-placeholder-empty']"));
	       	   String  pagetext =pagetype.getText();
	       	   //not completed with page module
	       	if (pagetext.contains("ADVANCED"))
			{
				action.dragAndDrop(pagetype,destination);
			}
			
	        }    
	       		
			
		
		}
		
	}
	}
	 
	
}
