package com_Medventure_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Medventure_Generic.BasePage;

public class ActitimeLoginPage extends BasePage
{
	@FindBy (id="username")
	private WebElement unTB;
	@FindBy (name="pwd")
	private WebElement pwTB;
	@FindBy (xpath="//div[.='Login ']")
	private WebElement lgBT;
	@FindBy (xpath="//span[.='Username or Password is invalid. Please try again.']")
	private WebElement error;
	@FindBy(xpath="//nobr[contains(text(),'actiTIME 2020 Online')]")
	private WebElement version;
	
	public ActitimeLoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String un)
	{
		unTB.sendKeys(un);
	}
	public void enterPassword(String pwd)
	{
		pwTB.sendKeys(pwd);
	}
	public void clickOnLogin()
	{
		lgBT.click();
	}
	public String getErrorMessage()
	{
		verifyElement(error);
		String aError=error.getText();
		return aError;
	}
	public String getVersion()
	{
		verifyElement(version);
		String aVersion=version.getText();
		return aVersion;
		
	}
}
