package org.iitworkforce.mmp;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Hello world!
 *
 */
public class AgeDifference 
{
	int defaultVar;
	public static void main(String[] args) { 
		
		String month="JULY";
		System.out.println(Month.valueOf(month).getValue());//7
		 
		
		
        // Birthdate yyyy mm dd
        LocalDate birthdate = LocalDate.of(1969, 7, 19); 
  
        // Current Date 
        LocalDate currentDate = LocalDate.now(); 
  
        // Calculate Age 
        int age = calculateAge(birthdate, currentDate); 
  
        // Print Age 
        System.out.println("Age: " + age + " years"); 
    } 
  
    public static int calculateAge(LocalDate birthdate, LocalDate currentDate) { 
        // Calculate period between birthdate and current date 
          Period period = Period.between(birthdate, currentDate); 
          return period.getYears(); 
    } 
}

/**
 * 	String month="JANUARY";
		System.out.println(Month.valueOf(month).getValue());
		System.out.println(month.substring(0, 3));
**/
