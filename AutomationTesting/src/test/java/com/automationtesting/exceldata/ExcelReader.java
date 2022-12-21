package com.automationtesting.exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {

		File file = new File(
				"C:\\Users\\gurum\\Desktop\\Cloud Sep Batch\\Demo\\MyProject\\AutomationTesting\\EmpData.xlsx");

		FileInputStream fi = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet sh = wb.getSheet("Data1");

		String mname = sh.getRow(1).getCell(1).getStringCellValue();

		System.out.println(mname);

		String fname = sh.getRow(4).getCell(0).getStringCellValue();

		System.out.println(fname);
		
		DataFormatter format= new DataFormatter();

		String empid = format.formatCellValue(sh.getRow(3).getCell(3));
		
		System.out.println(empid);

	}

}
