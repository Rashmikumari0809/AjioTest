package com.ajio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.base.BaseClass;
import com.ajio.util.UtilityMethods;

public class LoginPageEmailid extends BaseClass{
	
	 @FindBy(name="username") WebElement emailid;
	 @FindBy(xpath="//input[@class='login-btn']") WebElement clkbtn;
	 @FindBy(id="error-msg") WebElement errormsg;
	 @FindBy(id="pwdInput") WebElement passwordInput;
	 
	 
	public  LoginPageEmailid()
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	public String validateLoginPageTitleEmailid()
	{
		String title =driver.getTitle();
		return title;
	}
	public void loginEmailid(String eid) 
	{
		UtilityMethods.sendKeys(driver,emailid , 10, eid);
		UtilityMethods.click(driver, clkbtn, 5);
		//Thread.sleep(20000);
		//emailid.sendKeys(eid);
		//clkbtn.click();
	}
	public String errorMsg()
	{
		String errmsg=errormsg.getAttribute("innerText");
		return errmsg;
	}
	
	public boolean PresenceOfPasswordField()
	{
		boolean b=passwordInput.isDisplayed();
		return b;
	}

}
