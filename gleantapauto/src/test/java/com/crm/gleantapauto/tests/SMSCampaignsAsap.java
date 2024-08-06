package com.crm.gleantapauto.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class SMSCampaignsAsap extends BaseTest {
	
	@Test
	
	public void SMSCampaignAsap() throws InterruptedException, IOException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		
		driver.findElement(By.xpath("(.//a/span[contains(text(),'Campaigns')])[1]")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'SMS Campaigns')]")).click();
		driver.findElement(By.xpath(".//*[@class='btn btn-success']/child::i")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement NewSMSCamapaign= driver.findElement(By.xpath(".//h1[contains(text(),'New SMS Campaign')]"));
		wait.until(ExpectedConditions.visibilityOf(NewSMSCamapaign));
		driver.findElement(By.xpath(".//*[@id='campaignname']")).sendKeys("AutoSMSCampaignASAP");
		String SMSMessage="Testing Auto SMS Campaign";
		driver.findElement(By.xpath(".//*[@id='messagedetails0']")).sendKeys(SMSMessage);
		driver.findElement(By.xpath(".//*[@name='images[]']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\gleantapauto\\Testdata\\FileUpload.exe");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='smssavebtn']"));
	}

}
