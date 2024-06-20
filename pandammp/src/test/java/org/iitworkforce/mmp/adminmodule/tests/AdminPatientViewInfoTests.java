package org.iitworkforce.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iitworkforce.mmp.BaseClass;
import org.iitworkforce.mmp.MMPLibrary;
import org.iitworkforce.mmp.patientmodule.pages.EditProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPatientViewInfoTests extends BaseClass {


	@Test
	public void validateViewPatientData()
	{


		MMPLibrary mmpLib = new MMPLibrary(driver);	 
		mmpLib.login(prop.getProperty("patientusername"),prop.getProperty("patientpassword"));
		mmpLib.navigateTo("Profile");
		EditProfilePage editProfilePage = new EditProfilePage(driver);
		HashMap<String,String> expectedHMap = editProfilePage.getPatientData();
		expectedHMap.put("weight",expectedHMap.get("weight")+"kg");
		System.out.println("Expected HMap"+ expectedHMap);

		//############################################################
		mmpLib.launchApplication(prop.getProperty("adminurl"));
		mmpLib.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
		mmpLib.navigateTo("Patients");
		AdminPatientsPage adminPatientsPage = new AdminPatientsPage(driver);
		adminPatientsPage.searchPatient(expectedHMap.get("ssn"));
		HashMap<String,String> actualHMap = adminPatientsPage.fetchPatientDetails();
		System.out.println("Actual HMap"+ actualHMap);
		
		
		Assert.assertEquals(actualHMap, expectedHMap);

	}
}
