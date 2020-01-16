package com.ajio.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ajio.base.BaseClass;


public class UtilityMethods extends BaseClass{
	
	  public static void sendKeys(WebDriver driver,WebElement element,int timeout,	String value)
	  {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	  }
	  
	  public static void click(WebDriver driver,WebElement element,int timeout)
	  {
		  new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		  element.click();
	  }
	
}
