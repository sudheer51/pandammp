package org.iitworkforce.mmp.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesAdminPage {

	WebDriver driver;
	public SendMessagesAdminPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HashMap<String,String> fetchMessageDetails()
	{
		HashMap<String,String> sHMap = new HashMap<String,String>();


		sHMap.put("patientname", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText());
		sHMap.put("subject",  driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText());
		sHMap.put("date", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText());
		sHMap.put("message", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]")).getText().trim());

		return sHMap;

	}



}
