package org.iitworkforce.mmp.patientmodule.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGParalellTests {
	
	WebDriver driver;
 
	@BeforeMethod
	public void instantiateDriver() throws MalformedURLException
	{
		 
		driver = new ChromeDriver();
		 
	}

	@Test
	public void executeTest() throws MalformedURLException
	{
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	@Test
	public void executeTest1() throws MalformedURLException
	{
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}

	@Test
	public void executeTest3() throws MalformedURLException
	{
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	@Test
	public void executeTest4() throws MalformedURLException
	{
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	@Test
	public void executeTest2() throws MalformedURLException
	{
		
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	 
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
