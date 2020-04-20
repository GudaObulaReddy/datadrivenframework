package com.test.utility;

import java.io.Reader;
import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtility {
   static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try {
			reader =new Xls_Reader("C:\\Users\\Ramakrishna\\eclipse-workspace\\datadrivenprojectframework\\HalfEbdyTestData.xlsx");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		for(int rowNum=2;rowNum<=reader.getRowCount("Sheet1");rowNum++)
		{
			String firstname=reader.getCellData("Sheet1", "firstname", rowNum);
			String lastname=reader.getCellData("Sheet1", "lastname", rowNum);
			String email=reader.getCellData("Sheet1", "email", rowNum);
			String password=reader.getCellData("Sheet1", "password", rowNum);
			Object ob[]= {firstname,lastname,email,password};
			myData.add(ob);
			
		}
		return myData;
	}

}
