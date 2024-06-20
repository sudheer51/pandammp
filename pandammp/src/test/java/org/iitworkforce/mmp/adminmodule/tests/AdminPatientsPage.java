package org.iitworkforce.mmp.adminmodule.tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPatientsPage {

	String s="Selenium";
	
	WebDriver driver;
	public AdminPatientsPage(WebDriver driver)
	{
		this.driver = driver;
		 
	}
	public void searchPatient(String ssn)
	{
		driver.findElement(By.id("search")).sendKeys(ssn);
		driver.findElement(By.xpath("//input[@value='search']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='"+ssn+"']/preceding-sibling::td[1]/a")));
		driver.findElement(By.xpath("//td[normalize-space()='"+ssn+"']/preceding-sibling::td[1]/a")).click();
				

	}
	public HashMap<String, String> fetchPatientDetails() 
	{
		HashMap<String,String> patientDataHMap = new HashMap<String,String>();
		patientDataHMap.put("name",driver.findElement(By.xpath("//td[contains(text(),'Patient Name:')]")).getText().split(":")[1]);										 
		patientDataHMap.put("ssn",driver.findElement(By.xpath("//td[normalize-space()='SSN:']/following-sibling::td[1]")).getText());
		patientDataHMap.put("age",driver.findElement(By.xpath("//td[normalize-space()='AGE:']/following-sibling::td[1]")).getText());
		patientDataHMap.put("weight",driver.findElement(By.xpath("//td[normalize-space()='Weight:']/following-sibling::td[1]")).getText());
		patientDataHMap.put("height",driver.findElement(By.xpath("//td[normalize-space()='Height :']/following-sibling::td[1]")).getText());
		patientDataHMap.put("addr",driver.findElement(By.xpath("//td[normalize-space()='Address:']/following-sibling::td[1]")).getText());
		return patientDataHMap;
		
		
	}
}
