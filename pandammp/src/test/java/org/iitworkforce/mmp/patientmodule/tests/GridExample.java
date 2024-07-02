package org.iitworkforce.mmp.patientmodule.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GridExample {
	RemoteWebDriver driver;
	DesiredCapabilities caps;
	@BeforeClass
	public void instantiateDriver() throws MalformedURLException
	{
		caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WINDOWS);
		 
	}

	@Test
	public void executeTest() throws MalformedURLException
	{
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	@Test
	public void executeTest1() throws MalformedURLException
	{
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}

	@Test
	public void executeTest3() throws MalformedURLException
	{
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	@Test
	public void executeTest4() throws MalformedURLException
	{
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	@Test
	public void executeTest2() throws MalformedURLException
	{
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		 

	}
	 
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
