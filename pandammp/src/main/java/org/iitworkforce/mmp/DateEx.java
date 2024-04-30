package org.iitworkforce.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEx {

	public static void main(String args[])
	{ 
		AgeDifference ageDiff = new AgeDifference();
		System.out.println(ageDiff.defaultVar);
		
		String output = getFutureDate(10,"MM/dd/YYYY");
		System.out.println(output);
		String expectedArr[]=output.split("/");
		System.out.println("Expected Month " + expectedArr[0]);
		System.out.println("Expected Day " + expectedArr[1]);
		System.out.println("Expected Year " + expectedArr[2]);
		 
	}
	 
	
	public static String getFutureDate(int noofdays,String format)
	{

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String expected = sdf.format(d);
		return expected;
	}
	
	
}
