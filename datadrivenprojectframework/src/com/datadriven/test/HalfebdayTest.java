package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtility;

public class HalfebdayTest 
{
WebDriver driver=null;
@BeforeMethod 
public void setUp()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); 
	driver=new ChromeDriver();
	driver.get("https://reg.ebay.com/reg/PartialReg");
	 driver.manage().window().maximize(); 
	 driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	
}
@DataProvider
public Iterator<Object[]> getTestData()
{
	ArrayList<Object[]> testData = TestUtility.getDataFromExcel();
	return testData.iterator();
}

@Test(dataProvider = "getTestData")
public void HalfEbdyTestPage(String firstname,String lastname,String email,String password) throws InterruptedException
{
	
	System.out.println(firstname);
	driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
	System.out.println(password);
	driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).click();
Thread.sleep(5000);
}

}
