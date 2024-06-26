package org.iitworkforce.mmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppLibrary {

	public static String getDifferenceinYears(Integer dobYear)
	{
		Calendar cal = Calendar.getInstance();
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String currentYear = sdf.format(d);
		Integer output = Integer.parseInt(currentYear)-dobYear;
		return output+"";

	}
	/**
	 * Calculate period between birthdate and current date 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String calculateAge(String year,String month,String day) { 
		LocalDate birthDate = LocalDate.of(Integer.parseInt(year),Month.valueOf(month.toUpperCase()).getValue(),
				Integer.parseInt(day));
		Period period = Period.between(birthDate, LocalDate.now()); 
		return period.getYears()+""; 
	} 
	public static String generateRandomString(String text)
	{
		Random rand = new Random();
		int i = rand.nextInt(100);
		System.out.println(i);

		int j = 65+rand.nextInt(26);
		System.out.println(j);
		char upperCaseCh = (char)j;
		System.out.println(upperCaseCh);

		int k = 97+rand.nextInt(26);
		System.out.println(k);
		char lowerCaseCh = (char)k;
		System.out.println(lowerCaseCh);

		String randomString=text+upperCaseCh+""+lowerCaseCh+""+i+"";

		System.out.println(randomString);
		return randomString;
	}
	public static String generateRandomYear(int startYear)
	{

		Random rand = new Random();
		int year = startYear+rand.nextInt(10);
		//Integer i = new Integer(year);
		return year+"";
	}
	// LL + rand.nextInt(UL-LL+1)
	public static int generateRandomMonth()
	{
		Random rand = new Random();
		int i = 1 + rand.nextInt(12);//0 to 12// UL - LL+1 = 12-1+1=12
		System.out.println(i);
		return i;
	}
	public static String[][] readXLSX(String fileName,String sheetName) throws IOException  
	{
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		wb.getNumberOfSheets();
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of rows" + rows);
		System.out.println("number of cols" + cols);
		String inputData[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				inputData[i][j]= cell.getStringCellValue();
				System.out.print(inputData[i][j]);
			}
			System.out.println();
		}
		return inputData;

	}
	public static int calculateAge(LocalDate birthdate, LocalDate currentDate) { 
		// Calculate period between birthdate and current date 
		Period period = Period.between(birthdate, currentDate); 
		return period.getYears(); 
	} 
	public static String[][] getDBValues(String uname,String pword,String dbname,String tableName,String hostip) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//	Driver driver = new Driver();
		/*
		 * url a database url of the form jdbc:subprotocol:subnameuser 
		 * the database user on whose behalf the connection is being madepassword 
		 * the user's password
		 */
		String url="jdbc:mysql://"+hostip+":3306/"+dbname;
		String username=uname;
		String password=pword;

		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		//int  value = stmt.executeUpdate("INSERT INTO `mmp`.`patient_data` VALUES (11,'James','22/11/2021');");
		//System.out.println("The rows are updated "+ value);

		ResultSet rs =  stmt.executeQuery("Select * from "+dbname+"."+tableName);
		rs.last();

		int rows = rs.getRow();
		System.out.println("Number of rows " + rows);
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println("Number of cols: "+ cols);

		String data[][]= new String[rows][cols];
		int i=0;
		rs.beforeFirst();
		///System.out.println(rs.getMetaData());
		
		while(rs.next())
		{
			for(int j=0;j<cols;j++)
			{

				data[i][j]=rs.getString(j+1);
				System.out.print(data[i][j]+"--");
				System.out.print("i :::"  + i +"@@@@"+"j:::::" + j);

			}
			System.out.println();
			i++;
		} 
		return data;
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
