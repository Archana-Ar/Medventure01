package com_Medventure_Tests;



import org.testng.annotations.Test;

import com_Medventure_Generic.BaseTest;
import com_Medventure_Generic.BaseTestCompatibility;
import com_Medventure_Pages.ActitimeEnterTimeTrackPage;
import com_Medventure_Pages.ActitimeLoginPage;

public class ValidLoginLogoutTest extends BaseTestCompatibility
{
	@Test
	public void validLoginLogout()
	{
		ActitimeLoginPage lp=new ActitimeLoginPage(driver);
		lp.verifyTitle("actiTIME - Login");
		lp.enterUserName("admin");
		lp.enterPassword("manager");
		lp.clickOnLogin();
		lp.verifyTitle("actiTIME - Enter Time-Track");
		ActitimeEnterTimeTrackPage hp=new ActitimeEnterTimeTrackPage(driver);
		hp.clickOnLogout();
		hp.verifyTitle("actiTIME - Login");
	}
	
}
