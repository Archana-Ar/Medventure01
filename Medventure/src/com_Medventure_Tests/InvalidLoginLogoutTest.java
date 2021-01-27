package com_Medventure_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com_Medventure_Generic.BaseTest;
import com_Medventure_Generic.BaseTestCompatibility;
import com_Medventure_Generic.ExcelData;
import com_Medventure_Pages.ActitimeLoginPage;


public class InvalidLoginLogoutTest extends BaseTestCompatibility
{
	@Test
	public void invlaidLoginLogoutTest() throws InterruptedException
	{

		ExcelData data=new ExcelData();
		String lptitle=data.getData(file_path, "TC01", 1, 2);
		
		ActitimeLoginPage lp=new ActitimeLoginPage(driver);
		lp.verifyTitle(lptitle);
		
		int rc=data.getRowCount(file_path, "TC02");
		
		for(int i=1;i<=rc;i++)
		{
			String un=data.getData(file_path, "TC02", i, 0);
			String pwd=data.getData(file_path, "TC02", i, 1);
			lp.enterUserName(un);
			lp.enterPassword(pwd);
			lp.clickOnLogin();
			String aError=lp.getErrorMessage();
			String eError=data.getData(file_path, "TC02", 1, 2);
			Assert.assertEquals(aError, eError);
			
			Reporter.log("----------------------------", true);
			Thread.sleep(1000);
		}
		
	}
}
