package com.ajio.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public BaseClass()
	{
		try {
		prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ajio\\config\\config.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
		public void Intialization()
		{
			ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");	
			String BrowserName=prop.getProperty("browser");
			System.out.println(BrowserName);
			if(BrowserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources1\\chrome_exe\\chromedriver.exe");
				driver=new ChromeDriver(options);
				
			}
			if(BrowserName.equalsIgnoreCase("Ie"))
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\IE_exe\\IEDriverServer.exe");
				driver=new InternetExplorerDriver(options);
				
			}
			if(BrowserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resources\\gecko_exe\\GeckoDriver.exe");
				driver=new FirefoxDriver(options);
				
			}
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		}
	
	

}
