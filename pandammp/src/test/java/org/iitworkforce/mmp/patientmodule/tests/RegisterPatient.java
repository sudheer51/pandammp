package org.iitworkforce.mmp.patientmodule.tests;

import java.time.Duration;
import java.util.HashMap;

import org.iitworkforce.mmp.AppLibrary;
import org.iitworkforce.mmp.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPatient extends BaseClass {
	
	@Test//TestNG Annotation
	public void validateRegisterPatient() throws InterruptedException
	{
		 
 
		//RegisterPatient
		String randomString = AppLibrary.generateRandomString("AUTQA");
		HashMap<String,String> expectedHMap = registerPatient("Given"+randomString,"Middle"+randomString,"Surname"+randomString);
		HashMap<String,String> actualHMap = findAPatientRecordByID(expectedHMap.get("patientID"));
		Assert.assertTrue(expectedHMap.equals(actualHMap));

	}
	
	public HashMap<String, String> findAPatientRecordByID(String patientID)
	{
		//click on findA patient record
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
		//I search with expectedGiven name
		driver.findElement(By.id("patient-search")).sendKeys(patientID);

		HashMap<String,String> patientRecordDetails = new HashMap<String,String>();
		patientRecordDetails.put("patientID", driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[1]")).getText().replace("Recent",""));
		patientRecordDetails.put("name",driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[2]")).getText());
		patientRecordDetails.put("gender",driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[3]")).getText());
		patientRecordDetails.put("age",driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[4]")).getText());
		patientRecordDetails.put("birthDate",driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[5]")).getText().trim());
		return patientRecordDetails;
	}
	public HashMap<String, String> registerPatient(String givenName,String middleName,String surname)
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();

		//Register a patient
		driver.findElement(By.
				id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();


		driver.findElement(By.name("givenName")).sendKeys(givenName);
		String expected = driver.findElement(By.name("givenName")).getAttribute("value");
		driver.findElement(By.name("middleName")).sendKeys(middleName);
		driver.findElement(By.name("familyName")).sendKeys(surname);

		//name="Silly SD se"
		expectedHMap.put("name",
									driver.findElement(By.name("givenName")).getAttribute("value")+" "+
									driver.findElement(By.name("middleName")).getAttribute("value")+" "+
									driver.findElement(By.name("familyName")).getAttribute("value"));

		driver.findElement(By.id("next-button")).click();
		
		Select genderSelect = new Select(driver.findElement(By.id("gender-field")));
		String genderValue="Male";
		genderSelect.selectByVisibleText(genderValue);
		//gender="M"
		if(genderSelect.getFirstSelectedOption().equals("Male"))
		{
			expectedHMap.put("gender","M");
		}
		else
		{
			expectedHMap.put("gender","F");
		}
		driver.findElement(By.id("next-button")).click();
		
		
		driver.findElement(By.id("birthdateDay-field")).sendKeys("01");
		String day = driver.findElement(By.id("birthdateDay-field")).getAttribute("value");

		WebElement birthMonthWE = driver.findElement(By.id("birthdateMonth-field"));
		Select monthSelect = new Select(birthMonthWE);
		int monthTobeSelected = AppLibrary.generateRandomMonth();
		monthSelect.selectByIndex(monthTobeSelected);
		String month = monthSelect.getFirstSelectedOption().getText();

		driver.findElement(By.id("birthdateYear-field")).click();
		driver.findElement(By.id("birthdateYear-field")).sendKeys(AppLibrary.generateRandomYear(1980));
		String year = driver.findElement(By.id("birthdateYear-field")).getAttribute("value");
		//birthdate="18.Jan.1982"
		expectedHMap.put("birthDate",day+"."+month.substring(0,3)+"."+year );
		
		//age=25
		expectedHMap.put("age",AppLibrary.calculateAge(year,month,day));
		driver.findElement(By.id("next-button")).click();
		
		
		
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("Address1");
		driver.findElement(By.id("address2")).sendKeys("Addres2");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("1231231231");
		driver.findElement(By.id("next-button")).click();

		WebElement dropdown = driver.findElement(By.id("relationship_type"));
		Select relationShipSelect = new Select(dropdown);
		relationShipSelect.selectByVisibleText("Doctor");

		driver.findElement(By.cssSelector(".person-typeahead")).click();
		driver.findElement(By.cssSelector(".person-typeahead")).sendKeys("123awdgsa");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).submit();//click on confirm
		

		//		//Navigate to homePage
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/em[text()='Patient ID']/following-sibling::span")));
		expected =driver.findElement(By.xpath("//div/em[text()='Patient ID']/following-sibling::span")).getText();
		//patientID="10001E"
		expectedHMap.put("patientID",expected);
		System.out.println(expectedHMap);
		driver.findElement(By.cssSelector("ul#breadcrumbs>li")).click();
		return expectedHMap;

	}
	 
	 

}