package com_Medventure_Generic;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.google.common.io.Files;


public class GenericUtils 
{
	public static void getScreenshot(WebDriver driver,String name)
	{
		Date d=new Date(0);
		SimpleDateFormat s1=new SimpleDateFormat("DD-MM-YYYY");
		String date=s1.format(d);
		TakesScreenshot ts=(TakesScreenshot) driver;
		try
		{
		Files.copy(ts.getScreenshotAs(OutputType.FILE), new File("./Screenshots"+date+"_"+name+".png"));
		}
		catch(Exception e)
		{
			
		}
	}
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element,String visibleText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public static void deselectByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	
	public static void deselectByValue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}
	
	public static void deselectByVisibleText(WebElement element,String visibleText)
	{
		Select sel=new Select(element);
		sel.deselectByVisibleText(visibleText);
	}
	
	public static void deselectAll(WebElement element)
	{
		Select sel=new Select(element);
		sel.deselectAll();
	}
	
	public static void getFirstSelectedOption(WebElement element)
	{
		Select sel=new Select(element);
		WebElement opt=sel.getFirstSelectedOption();
		String text=opt.getText();
		Reporter.log("the first selected option is "+text, true);
	}
	public static void getAllSelectedOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allopt = sel.getAllSelectedOptions();
		int count=allopt.size();
		Reporter.log("count of selected options ="+count,true);
		Reporter.log("All selected options",true);
		for(WebElement opt : allopt)
		{
			String text=opt.getText();
			Reporter.log(text, true);
		}
	}
	public static void getOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allopt = sel.getOptions();
		int count=allopt.size();
		Reporter.log("the count of all options =", count,true);
		
		for(WebElement opt : allopt)
		{
			String text=opt.getText();
			Reporter.log(text,true);
		}
	}
	
	public static void isMultiple(WebElement element)
	{
		Select sel=new Select(element);
		boolean v=sel.isMultiple();
		if(v)
		{
			Reporter.log("ListBox is multi selected", true);
		}
		else
		{
			Reporter.log("ListBox is single Selected",true);
		}
	}
}
