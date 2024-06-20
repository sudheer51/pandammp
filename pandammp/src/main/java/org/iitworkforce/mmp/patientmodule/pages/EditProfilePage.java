package org.iitworkforce.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {
	WebDriver driver;
	public EditProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public String getFirstName()
	{
		return driver.findElement(By.id("fname")).getAttribute("value");
	}
	public HashMap<String,String> getPatientData()
	{
		HashMap<String,String> patientDataHMap = new HashMap<String,String>();
		patientDataHMap.put("name",driver.findElement(By.id("fname")).getAttribute("value")+
												driver.findElement(By.id("lname")).getAttribute("value"));
		patientDataHMap.put("ssn",driver.findElement(By.id("ssn")).getAttribute("value"));
		patientDataHMap.put("age",driver.findElement(By.id("age")).getAttribute("value"));
		patientDataHMap.put("weight",driver.findElement(By.id("weight")).getAttribute("value"));
		patientDataHMap.put("height",driver.findElement(By.id("height")).getAttribute("value"));
		patientDataHMap.put("addr",driver.findElement(By.id("addr")).getAttribute("value")+
									driver.findElement(By.id("city")).getAttribute("value")+
									driver.findElement(By.id("state")).getAttribute("value"));
		
		return patientDataHMap;
		 
	}
}
