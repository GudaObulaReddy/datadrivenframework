package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); WebDriver
		  driver=new ChromeDriver(); driver.get("https://reg.ebay.com/reg/PartialReg");
		 driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Ramakrishna\\eclipse-workspace\\datadrivenprojectframework\\HalfEbdyTestData.xlsx");
        int rowcount=reader.getRowCount("Sheet1");
        // parametarization 
        reader.addColumn("Sheet1", "status");
        for(int rowNum=2;rowNum<=rowcount;rowNum++)
        {
        	String firstname=reader.getCellData("Sheet1", "firstname", rowNum);
        	System.out.print(firstname);
        	String lastname=reader.getCellData("Sheet1", "lastname", rowNum);
    		System.out.print(lastname);

    		String email=reader.getCellData("Sheet1", "email", rowNum);
    		System.out.print(email);

    		String password=reader.getCellData("Sheet1", "password", rowNum);
    		System.out.print(password);
       System.out.println();
    
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).click();
        Thread.sleep(5000);
        reader.setCellData("Sheet1", "status", rowNum, "pass");
        }
        
        
	}

}
