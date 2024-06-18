package org.iitworkforce.mmp.patientmodule.pages;

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
}
