package com_Medventure_Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public String getData(String file_path,String sheet_name,int rn,int cn) 
	{
		try
		{
			File f=new File(file_path);
			FileInputStream file=new FileInputStream(f);
			String data=WorkbookFactory.create(file).getSheet(sheet_name).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public int getRowCount(String file_path,String sheet_name) 
	{
		try
		{
			File f=new File(file_path);
			FileInputStream file=new FileInputStream(f);
			int rc=WorkbookFactory.create(file).getSheet(sheet_name).getLastRowNum();
			return rc;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	public int getCellcount(String file_path,String sheet_name,int rn)
	{
		try
		{
			File f=new File(file_path);
			FileInputStream file=new FileInputStream(f);
			int cc=WorkbookFactory.create(file).getSheet(sheet_name).getRow(rn).getLastCellNum();
			return cc;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
