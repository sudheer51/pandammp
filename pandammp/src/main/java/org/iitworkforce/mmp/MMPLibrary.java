package org.iitworkforce.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {

	public WebDriver driver;
	public MMPLibrary(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void login(String username,String password)
	{
		//login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
	}
	public String fetchLoginSuccessfulMsg()
	{
		return driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
	}
	public void navigateTo(String moduleName)
	{
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();
	}
	public void launchApplication(String url)
	{
		driver.get(url);
	}



}
