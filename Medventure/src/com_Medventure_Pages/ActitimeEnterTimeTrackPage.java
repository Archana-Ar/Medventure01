package com_Medventure_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Medventure_Generic.BasePage;

public class ActitimeEnterTimeTrackPage extends BasePage
{
	
	@FindBy (id="logoutLink")
	private WebElement logout;

	public ActitimeEnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}

}
