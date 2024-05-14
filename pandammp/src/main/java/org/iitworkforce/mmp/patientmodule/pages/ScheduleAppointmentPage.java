package org.iitworkforce.mmp.patientmodule.pages;

import java.time.Duration;
import java.util.HashMap;

import org.iitworkforce.mmp.AppLibrary;
import org.iitworkforce.mmp.DateEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {
	
	WebDriver driver;
	private By dateXpath = By.xpath("//table[@class='table']/tbody/tr[1]/td[1]");
	private By timeXpath = By.xpath("By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")");
	private By symPath = By.xpath("By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")");
	private By doctorXpath = By.xpath("By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")");
	private By createNewButtonXpath = By.xpath("//input[@value='Create new appointment']");
	
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HashMap<String,String> fetchPatientPortalTableData()
	{
		HashMap<String,String>  actualHMap = new HashMap<String,String>();	
		actualHMap.put("date", driver.findElement(dateXpath ).getText());
		actualHMap.put("time", driver.findElement(timeXpath ).getText());
		actualHMap.put("sym", driver.findElement(symPath ).getText());
		actualHMap.put("doctor", driver.findElement( doctorXpath).getText());
		return actualHMap;
	}
	public HashMap<String,String> bookAppointment(String doctor,String specialization,int noofDays)
	{
		HashMap<String,String>  expectedHMap = new HashMap<String,String>();

		 
		driver.findElement(createNewButtonXpath).click();
		driver.findElement(By.xpath("//h4[text()='Dr."+doctor+"']/following-sibling::div/p[contains(text(),'"+specialization+"')]/ancestor::ul/following-sibling::button")).click();
		expectedHMap.put("doctor", doctor);

		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		String expectedArr[] = DateEx.getFutureDate(noofDays, "MMMM/d/YYYY").split("/");
		String expectedMonth=expectedArr[0];
		String expectedDay=expectedArr[1];
		String expectedYear=expectedArr[2];
		String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!(actualYear.equals(expectedYear)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		while(!(actualMonth.equals(expectedMonth)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}

		driver.findElement(By.linkText(expectedDay)).click();
		expectedHMap.put("date", driver.findElement(By.id("datepicker")).getAttribute("value"));




		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByVisibleText("12Pm");
		expectedHMap.put("time",timeSelect.getFirstSelectedOption().getText());


		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='status']")), "OK"));

		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='sym']")));
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys(AppLibrary.generateRandomString("AutoTester"));
		expectedHMap.put("sym", 	driver.findElement(By.xpath("//textarea[@id='sym']")).getAttribute("value"));

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		
		return expectedHMap;

	}

}
