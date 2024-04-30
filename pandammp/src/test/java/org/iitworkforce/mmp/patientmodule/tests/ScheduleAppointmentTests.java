package org.iitworkforce.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iitworkforce.mmp.BaseClass;
import org.iitworkforce.mmp.MMPLibrary;
import org.iitworkforce.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * https://total-qa.com/automation-framework-modulardatadrivenkeywordhybrid/
 * https://testng.org/
 * DataDriven Fwk via Data Provider
 * Property File
 * @author sudhe
 *
 */

public class ScheduleAppointmentTests extends BaseClass { 
 
	@Parameters({"doctor","specialization"})
	@Test//TestNG Annotation
	public void validateScheduleAppointment(String doctor,String specialization) throws InterruptedException
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);	 
		mmpLib.login(prop.getProperty("patientusername"),prop.getProperty("patientpassword"));
		mmpLib.navigateTo("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap = sPage.bookAppointment(doctor,specialization,50);
		HashMap<String,String> actualHMap = sPage.fetchPatientPortalTableData();
		Assert.assertEquals(actualHMap, expectedHMap);
	}
}
/**

//h4[text()='Dr.Beth']/following-sibling::div/p[contains(text(),'Pediatrician')]/ancestor::ul/following-sibling::button

Take the input from the user and print the date the below format 
noofDays :10 => 14/April/2024 => Expected 
noofDays: 30 => 04/May/2024 => Expected 
noofDays: 365 => 04/April/2025=>Expected 

Fetch the expectedDay 
Fetch the expectedMonth
Fetch the expectedYear 

actualYear=driver.findElement(By.className("")).getText() - > 2024
while(actualYear!=expectedYear)
{
	click on next button 
	actual = driver.findElement(By.className("")).getText();
}

actualMonth= driver.findElement(By.className("")).getText() - > 2024
while(actualMonth!=expectedMonth)
{
	click on next button 
	actual = driver.findElement(By.className("")).getText();
}
driver.findElement(By.linkText(day)).click();

 */