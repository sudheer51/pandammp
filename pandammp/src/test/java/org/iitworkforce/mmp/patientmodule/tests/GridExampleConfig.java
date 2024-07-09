package org.iitworkforce.mmp.patientmodule.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GridExampleConfig {
	  DesiredCapabilities caps;

	@BeforeMethod
	public   void init()
	{
		caps = new DesiredCapabilities();
		 
	}
	@Test
	public void executeTest6() throws MalformedURLException {
		System.out.println("in test 6");
		caps.setBrowserName("chrome");
		caps.setVersion("113");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
		driver.get("http://www.google.com");
		driver.quit();
	}
	@Test
	public void executeTest2() throws MalformedURLException {
		System.out.println("in test 2");

		caps.setBrowserName("MicrosoftEdge");
		caps.setVersion("126");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
		driver.get("http://www.google.com");
		driver.quit();
	}
//	@Test
//	public void executeTest3() throws MalformedURLException {
//
//	 
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
//		driver.get("http://www.google.com");
//		driver.quit();
//	}
//	@Test
//	public void executeTest4() throws MalformedURLException {
//
//		 
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
//		driver.get("http://www.google.com");
//		driver.quit();
//	}

}

