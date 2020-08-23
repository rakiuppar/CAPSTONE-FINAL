package com.capstone.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.base.BaseClass;

public class LoginPage extends BaseClass
{
	// Webelements or elements repository of the application page
	@FindBy(xpath="//input[@name='userName']")
	WebElement userName1;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password1;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	
	@FindBy (xpath="//*[contains(text(),'REGISTER')]")
	WebElement registerLink;
	
	
	// Methods or actions performed on the above elements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loadURL()
	{
		driver.get(prop.getProperty("url"));
	}
	
	public void clickOnRegister()
	{
		registerLink.click();
	}
	
	public void login()
	{
		userName1.sendKeys(prop.getProperty("userName"));
		password1.sendKeys(prop.getProperty("password"));
		loginButton.click();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
