package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args)
	{
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Ramakrishna\\eclipse-workspace\\datadrivenprojectframework\\HalfEbdyTestData.xlsx");
	    
   if(!reader.isSheetExist("HomePage"))
   {
	   reader.addSheet("HomePage");
	   System.out.println("added");
   }
	 int colCount=reader.getColumnCount("Sheet1");
	 System.out.println(colCount);
	 System.out.println();
	 System.out.println(reader.getCellRowNum("Sheet1", "firstname", "tom"));
	}

}
