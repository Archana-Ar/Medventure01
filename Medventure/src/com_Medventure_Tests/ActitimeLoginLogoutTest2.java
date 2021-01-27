package com_Medventure_Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com_Medventure_Generic.BaseTest;
import com_Medventure_Generic.BaseTestCompatibility;
import com_Medventure_Generic.ExcelData;
import com_Medventure_Pages.ActitimeEnterTimeTrackPage;
import com_Medventure_Pages.ActitimeLoginPage;

public class ActitimeLoginLogoutTest2 extends BaseTestCompatibility
{
	@Test
	public void actitimeLoginLogout()
	{
		ExcelData data=new ExcelData();
		String un=data.getData(file_path, "TC01", 1, 0);
		String pwd=data.getData(file_path, "TC01", 1, 1);
		String lptitle=data.getData(file_path, "TC01", 1, 2);
		String hptitle=data.getData(file_path, "TC01", 1, 3);
		
		ActitimeLoginPage lp=new ActitimeLoginPage(driver);
		lp.verifyTitle(lptitle);
		lp.enterUserName(un);
		lp.enterPassword(pwd);
		lp.clickOnLogin();
		lp.verifyTitle(hptitle);
		
		ActitimeEnterTimeTrackPage hp=new ActitimeEnterTimeTrackPage(driver);
		hp.clickOnLogout();
		hp.verifyTitle(lptitle);
		
	}
}
