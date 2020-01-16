package com.ajio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.base.BaseClass;

public class LoginPagePassword extends BaseClass{
	
	 @FindBy(name="password") WebElement pwd;
	 @FindBy(xpath="//input[@type='submit']") WebElement clkbtn;
	 
	public  LoginPagePassword()
	 {
		 PageFactory.initElements(driver, this);
	 }
	public void login(String password)
	{
		pwd.sendKeys(password);
		clkbtn.click();
	}

}
