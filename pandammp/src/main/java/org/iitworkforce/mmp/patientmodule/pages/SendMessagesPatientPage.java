package org.iitworkforce.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPatientPage {
	
	WebDriver driver;
	public SendMessagesPatientPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HashMap<String,String> sendMessages(String subject,String message)
	{
		HashMap<String,String> sHMap = new HashMap<String,String>();
		
		driver.findElement(By.id("subject")).sendKeys(subject);
		sHMap.put("subject", driver.findElement(By.id("subject")).getAttribute("value"));
		
		driver.findElement(By.id("message")).sendKeys(message);
		sHMap.put("message", driver.findElement(By.id("message")).getAttribute("value"));
		
		driver.findElement(By.xpath("//input[@value='Send']")).sendKeys(message);
		
		Alert alrt = driver.switchTo().alert();
		System.out.println("Alert Message::"+ alrt.getText());
		alrt.accept();
		
		return sHMap;
		
	}

}
