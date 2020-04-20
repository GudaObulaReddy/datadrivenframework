package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) 
	{
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Ramakrishna\\eclipse-workspace\\datadrivenprojectframework\\HalfEbdyTestData.xlsx");
		String firstname=reader.getCellData("Sheet1", "firstname", 2);
		System.out.println(firstname);

		String lastname=reader.getCellData("Sheet1", "lastname", 2);
		System.out.println(lastname);

		String email=reader.getCellData("Sheet1", "email", 2);
		System.out.println(email);

		String password=reader.getCellData("Sheet1", "password", 2);
		System.out.println(password);

		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); WebDriver
		  driver=new ChromeDriver(); driver.get("https://reg.ebay.com/reg/PartialReg");
		 driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).click();
	
	}

}
