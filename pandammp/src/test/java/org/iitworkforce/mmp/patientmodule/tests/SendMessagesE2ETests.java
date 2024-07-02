package org.iitworkforce.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iitworkforce.mmp.AppLibrary;
import org.iitworkforce.mmp.BaseClass;
import org.iitworkforce.mmp.MMPLibrary;
import org.iitworkforce.mmp.adminmodule.pages.SendMessagesAdminPage;
import org.iitworkforce.mmp.patientmodule.pages.EditProfilePage;
import org.iitworkforce.mmp.patientmodule.pages.SendMessagesPatientPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessagesE2ETests extends BaseClass {
	
	 
	@Test//TestNG Annotation
	public void validateSendMessages() throws InterruptedException
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);	 
		mmpLib.login(prop.getProperty("patientusername"),prop.getProperty("patientpassword"));
		mmpLib.navigateTo("Messages");
		
		SendMessagesPatientPage msgPage = new SendMessagesPatientPage(driver);
		HashMap<String,String> expectedHMap = msgPage.sendMessages("Monthly Visit", "Health Check");
		
		mmpLib.navigateTo("Profile");
		EditProfilePage profilePage = new EditProfilePage(driver);
		expectedHMap.put("patientname",  profilePage.getFirstName());
		expectedHMap.put("date",AppLibrary.getFutureDate(0, "dd-MM-YYYY"));
		
		System.out.println("##############################################Expected HashMap"+ expectedHMap);
		
		mmpLib.launchApplication(prop.getProperty("adminurl"));
		mmpLib.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
		mmpLib.navigateTo("Messages");

		SendMessagesAdminPage adminPage = new SendMessagesAdminPage(driver);
		HashMap<String,String> actualHMap = adminPage.fetchMessageDetails();
		System.out.println("#########################################Actual HashMap"+ actualHMap);
		
		Assert.assertEquals(actualHMap, expectedHMap);
 
	}

}
