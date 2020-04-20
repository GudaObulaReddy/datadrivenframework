package com.tables;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WritingTablsIntoExcel {

	public static void main(String[] args) 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/");
		//*[@id="post-2924"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[1]/th[1]
		//*[@id="post-2924"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[1]
		//*[@id="post-2924"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[3]/td[1]
		 String beforeXpath="//*[@id=\"post-2924\"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[";
	      String afterXpath="]/td[1]";
	    //*[@id="post-2924"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[2]
       String beforeXpathlicense="//*[@id=\"post-2924\"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr[";
       String afterXpathlicense="]/td[2]";
       Xls_Reader reader=new Xls_Reader("C:\\Users\\Ramakrishna\\eclipse-workspace\\datadrivenprojectframework\\copyTables.xlsx");
       if(!reader.isSheetExist("TableData2"))
       {
       reader.addSheet("TableData2");
       }
       else
       {
    	   System.out.println("table already exists");
       }
       reader.addColumn("TableData2", "name");
       reader.addColumn("TableData2", "licence");
       
       java.util.List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"post-2924\"]/div[1]/div/div[2]/div/div/div/div/table/tbody/tr"));
       for(int i=2;i<=rows.size();i++)
       {
    	   String actualXpath=beforeXpath+i+afterXpath;
    	   String name=driver.findElement(By.xpath(actualXpath)).getText();
    	   System.out.println(name);
    	   reader.setCellData("TableData2", "name", i, name);
    	   String actualXpathlicence=beforeXpathlicense+i+afterXpathlicense;
    	   String namelice=driver.findElement(By.xpath(actualXpathlicence)).getText();
    	   reader.setCellData("TableData2", "licence", i, namelice);
    	   System.out.println(namelice);
       }
	}

}
