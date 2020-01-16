package com.ajio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;

public class excel_utility {
	FileOutputStream fos;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell cell;

	public excel_utility(String path)

	{
		try {
			fis= new FileInputStream(new File(path));
		
			wb= new XSSFWorkbook(fis);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public int getRowCount(String Sheetname)
	{
		int rowcount=-1;
		sh=wb.getSheet(Sheetname);
		rowcount=sh.getPhysicalNumberOfRows();
		return rowcount;
			
		
	}
	
	public int getLastRowCount(String SheetNmae)
	{
		int rowcount=-1;
		sh=wb.getSheet(SheetNmae);
		rowcount=sh.getLastRowNum();
		return rowcount;
	}

	public int getColCount(String Sheetname)
	{
		int colcount=-1;
		sh=wb.getSheet(Sheetname);
		colcount=sh.getRow(0).getPhysicalNumberOfCells();
		return colcount;
	}
	
	public String getCellValue(String SheetName,String ColName,int rowNum, int RownumforColumnHeader)
	{
		String cellValue=null;
		int ColNum=-1;
		sh=wb.getSheet(SheetName);
		row=sh.getRow(RownumforColumnHeader);
		
		for(int i=0;i<row.getPhysicalNumberOfCells();i++)
		{
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase(ColName))
			{
				ColNum=i;
				
			}
		}
		
	 
		row=sh.getRow(rowNum-1);
		
		cell=row.getCell(ColNum);
		if(cell==null)
		{
			String x="no value";
			return x;
		}
		else {
      

		if(cell.getCellType()==CellType.STRING)
		{
			cellValue=cell.getStringCellValue();
		}
		if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
		{
			cellValue= String.valueOf(cell.getNumericCellValue());
		}
		/*  if(HSSFDateUtil.isCellDateFormatted(cell))
        {
        	Date dt=cell.getDateCellValue();
        	SimpleDateFormat sd= new SimpleDateFormat("dd/mm/yy");
        	cellValue=sd.format(dt);

        }*/
		if(cell.getCellType()==CellType.BOOLEAN)
		{
			cellValue=String.valueOf(cell.getBooleanCellValue());
		}
		if(cell.getCellType()==CellType.BLANK) {
			cellValue="";
		}
		return cellValue;
		}
	}
	
	
	public String getCellValueIncNull(String SheetName,String ColName,int rowNum, int RownumforColumnHeader)
	{
		String cellValue=null;
		int ColNum=-1;
		sh=wb.getSheet(SheetName);
		row=sh.getRow(RownumforColumnHeader);
		
		for(int i=0;i<row.getPhysicalNumberOfCells();i++)
		{
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase(ColName))
			{
				ColNum=i;
				
			}
		}
		
	 
		row=sh.getRow(rowNum-1);
		
		cell=row.getCell(ColNum);
		
      

		if(cell.getCellType()==CellType.STRING)
		{
			cellValue=cell.getStringCellValue();
		}
		if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
		{
			cellValue= String.valueOf(cell.getNumericCellValue());
		}
		/*  if(HSSFDateUtil.isCellDateFormatted(cell))
        {
        	Date dt=cell.getDateCellValue();
        	SimpleDateFormat sd= new SimpleDateFormat("dd/mm/yy");
        	cellValue=sd.format(dt);

        }*/
		if(cell.getCellType()==CellType.BOOLEAN)
		{
			cellValue=String.valueOf(cell.getBooleanCellValue());
		}
		if(cell.getCellType()==CellType.BLANK) {
			cellValue="";
		}
		return cellValue;
		
	}
	

	public void setCellValue(String SheetName,String ColName,int rowNum,String value,int RownumforColumnHeader) 
	{
		try {
		sh=wb.getSheet(SheetName);
		
		int ColNum=-1;
		sh=wb.getSheet(SheetName);
		row=sh.getRow( RownumforColumnHeader);
		for(int i=0;i<row.getPhysicalNumberOfCells();i++)
		{
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase(ColName))
			{
				ColNum=i;
			}
		}
		sh.getRow(rowNum-1).createCell(ColNum).setCellValue(value);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void fileOpStrm(String path)
	{
		try {
		fos= new FileOutputStream(new File(path));
		wb.write(fos);
		wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	



}
