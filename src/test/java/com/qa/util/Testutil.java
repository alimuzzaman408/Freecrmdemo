package com.qa.util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class Testutil  {
	public static FileInputStream fileinput;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet wsheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfilepath,String xlsheet) throws IOException 
	{
		fileinput=new FileInputStream(xlfilepath);
		workbook=new XSSFWorkbook(fileinput);
		wsheet=workbook.getSheet(xlsheet);
		int rowcount=wsheet.getLastRowNum();
		workbook.close();
		fileinput.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fileinput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileinput);
		wsheet=workbook.getSheet(xlsheet);
		row=wsheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fileinput.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfilepath,String xlsheet,int rownum,int colnum) throws IOException
	{
		fileinput=new FileInputStream(xlfilepath);
		workbook=new XSSFWorkbook(fileinput);
		wsheet=workbook.getSheet(xlsheet);
		row=wsheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fileinput.close();
		return data;
	}
	
	public static void setCellData(String xlfilepath,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fileinput=new FileInputStream(xlfilepath);
		workbook=new XSSFWorkbook(fileinput);
		wsheet=workbook.getSheet(xlsheet);
		row=wsheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfilepath);
		workbook.write(fo);		
		workbook.close();
		fileinput.close();
		fo.close();
	}
	
	
}
