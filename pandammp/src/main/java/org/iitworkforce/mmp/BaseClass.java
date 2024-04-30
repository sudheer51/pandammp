package org.iitworkforce.mmp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	protected WebDriver driver;
	protected Properties prop;
	protected String browserName,environment;
	@BeforeTest
	public void loadProperties() throws FileNotFoundException, IOException
	{
		ProjectConfiguration projConfig = new ProjectConfiguration();
		prop =projConfig.readPropertyFile("config//mmp.properties");
		browserName= prop.getProperty("browsername");
		environment = prop.getProperty("environment");
		if(environment.equals("qa"))
		{
			prop =projConfig.readPropertyFile("config//mmp_qa.properties");
		}
		else if(environment.equals("dev"))
		{
			prop=projConfig.readPropertyFile("config//mmp_dev.properties");
		}
	}
	@BeforeClass
	public void instantiateDriver()
	{
		
		if(browserName.equals("chrome"))
		{
			//instantiate driver
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("patienturl"));
			driver.manage().window().maximize();
		}
		else if(browserName.equals("firefox"))
		{

			//instantiate driver
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("patienturl"));			
			driver.manage().window().maximize();
			
		}
	}
}
