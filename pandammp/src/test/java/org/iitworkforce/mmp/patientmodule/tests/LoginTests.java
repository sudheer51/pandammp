package org.iitworkforce.mmp.patientmodule.tests;

import java.io.IOException;

import org.iitworkforce.mmp.AppLibrary;
import org.iitworkforce.mmp.BaseClass;
import org.iitworkforce.mmp.MMPLibrary;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass{

	@DataProvider(name = "loginDP")
	public String[][] fetchExcelData() throws IOException
	{
		return AppLibrary.readXLSX("Login.xlsx","data");
	}
	
	@Test(dataProvider = "loginDP")
	public void verifyData1(String username, String password,String expected) 
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
	 	mmpLib.login(username, password);
		String actual = mmpLib.fetchLoginSuccessfulMsg();
		Assert.assertEquals(actual, expected);
	}
}
