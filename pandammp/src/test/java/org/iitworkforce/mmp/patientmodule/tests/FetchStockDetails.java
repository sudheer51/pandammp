package org.iitworkforce.mmp.patientmodule.tests;

 
import org.iitworkforce.mmp.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchStockDetails extends BaseClass{

	static WebDriver driver;
	int i;
	public static void main(String[] args) 
	{
		 
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		FetchStockDetails fsh = new FetchStockDetails();
		String stockArray[] = {"Parnax Lab L"};
		for(int i=0;i<stockArray.length;i++)
		{
			fsh.getStockDetails(stockArray[i]);
		}
		
	}
	public void getStockDetails(String stockName)
	{ 
		System.out.println(browserName);
		FetchStockDetails fsh = new FetchStockDetails();
		System.out.println(fsh.browserName);
		
		boolean stockAvailable=driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']")).isDisplayed();

		if(stockAvailable)
		{
			String prevClose= driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[2]")).getText();
			String currPrice= driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[3]")).getText();
			String perChange= driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[4]")).getText();
			System.out.println("Previous Close:: "+prevClose);
			System.out.println("Current Price:: "+currPrice);
			System.out.println("Percentage Change:: "+perChange);
		}
		else
		{
			System.out.println("Stock Name:::" + stockName+" not available in the gainers table");
		}

	}


}
