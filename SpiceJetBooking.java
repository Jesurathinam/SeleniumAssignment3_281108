package com.ibm.seleniumassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetBooking {
	public static void main(String[] args){
		System.out.println("This program will book a round trip in SpiceJet");
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver chrdriver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(chrdriver, 60); //Explicit Wait
		chrdriver.manage().window().maximize();
		chrdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		chrdriver.get("https://spicejet.com");
		String url=chrdriver.getCurrentUrl();
		System.out.println("Application URL: "+url);
		String title=chrdriver.getTitle();
		System.out.println("Initial Page Title: "+title);
		
		//To verify and click Round Trip radio button
		WebElement roundtripEle=chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"));
		roundtripEle.click();
		System.out.println("Round Trip button clicked");
		//To verify whether the Return Date field is enabled when Round Trip is clicked
		boolean rtndtck=chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled();
		if (rtndtck=true)
		System.out.println("Return date is enabled when Round Trip is selected");
		//To position to Departure City drop down
		WebElement posfromEle = chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		posfromEle.click();
		//To select Chennai from Departure City drop down
		WebElement depcityEle = chrdriver.findElement(By.xpath("//a[@value='MAA']"));
		depcityEle.click(); 
		System.out.println("Chennai selected");
		//To position to Arrival City drop down
		WebElement postoEle = chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		postoEle.click();
/*		//To select Bengaluru from Arrival City drop down
		WebElement arrcityEle = chrdriver.findElement(By.xpath("//a[@value='BLR']"));
		arrcityEle.click(); 
		System.out.println("Bengaluru selected"); 

		//To position to Depart Date
		WebElement dptdateEle = chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
		dptdateEle.click();
		
		//To position to Return Date
		WebElement rtndateEle = chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));
		rtndateEle.click();
		
		//To position to Passengers
		WebElement passengerEle = chrdriver.findElement(By.xpath(""));
		passengerEle.click(); */
		
		//To postion Currency
		WebElement currencyEle = chrdriver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		currencyEle.click();
		//To select USD
		WebElement currencyddEle = chrdriver.findElement(By.xpath("//option[@value='USD']"));
		currencyddEle.click();
		System.out.println("Currency value USD selected");
		
		//To click Search
		WebElement searchEle = chrdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
		searchEle.click();
		System.out.println("Search button clicked");
		
		System.out.println("End of the program");
		
	}

}
