package org.iitworkforce.mmp.patientmodule.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExampleConfig {
	  DesiredCapabilities caps1,caps2;
	@Test
	public void executeTest6() throws MalformedURLException {
		System.out.println("in test 6");
		caps1 = new DesiredCapabilities();
		caps1.setBrowserName("chrome");
		caps1.setVersion("86");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps1);
		driver.get("http://www.google.com");
		driver.quit();
	}
	@Test
	public void executeTest2() throws MalformedURLException {
		System.out.println("in test 2");
		caps2 = new DesiredCapabilities();
		caps2.setBrowserName("MicrosoftEdge");
		caps2.setVersion("126");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps2);
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

