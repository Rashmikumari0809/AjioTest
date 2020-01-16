package com.ajio.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajio.base.BaseClass;
import com.ajio.pages.LoginPageEmailid;
import com.ajio.pages.LoginPagePassword;
import com.ajio.util.excel_utility;

public class LoginPageTest extends BaseClass {
	LoginPageEmailid loginEmail;
	LoginPagePassword loginPassword;
	excel_utility ut;
	String SheetName=prop.getProperty("sheetName").toString();
	String CN_Testcase =prop.getProperty("CN_TestcaseName").toString();
	int row_columnHeader=Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString());
	String CN_Testdata=prop.getProperty("CN_Testdata").toString();
	String testcaseid;
	String testdata;
	String message;
	String expectederrormsg;
	String CN_Message=prop.getProperty("CN_ErrorMessage").toString();


	public LoginPageTest()
	{
		super();
		ut= new excel_utility(System.getProperty("user.dir")+prop.getProperty("path").toString());
	}
	@BeforeMethod
	public void SetUp() {
		Intialization();
		loginEmail= new LoginPageEmailid();
		loginPassword= new LoginPagePassword();

	}
	//@Test
	public void loginPageTitleTest1() 

	{
		try {

			String title=loginEmail.validateLoginPageTitleEmailid();
			Assert.assertEquals(title, "AJIO");
			ut.setCellValue(prop.getProperty("sheetName").toString(), 
					prop.getProperty("ColumnName").toString(), 9, "Successfully landed to login page",Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
			
			ut.setCellValue(prop.getProperty("sheetName").toString(), 
					"Status", 9, "pass",Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
			
		}
		catch(AssertionError e)
		{


			try {
				ut.setCellValue(prop.getProperty("sheetName").toString(), 
						prop.getProperty("ColumnName").toString(), 9, "Login failed as title do not match",
						Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
				

				ut.setCellValue(prop.getProperty("sheetName").toString(), 
						"Status", 9, "fail",Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}

		}

	}


	@Test
	public void userNameTest003() 
	{
		
		
		String actualerrormsg=loginEmail.errorMsg();
		for(int i=row_columnHeader+3;i<=ut.getRowCount(SheetName);i++)
		{
			
			testcaseid=ut.getCellValue(SheetName, CN_Testcase, i, row_columnHeader);
			if(!testcaseid.equals("no value"))
			{
				testdata=ut.getCellValueIncNull(SheetName, CN_Testdata, i, row_columnHeader);
				
				loginEmail.loginEmailid(testdata);
				message=ut.getCellValue(SheetName,CN_Message, i, row_columnHeader);
				if(message.equals("no value"))
				{
					ut.setCellValue(prop.getProperty("sheetName").toString(), 
							prop.getProperty("ColumnName").toString(), i, "same as expected",
							Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
					tearDown();
					SetUp();
					
				}
				else {
					
					expectederrormsg=ut.getCellValue(prop.getProperty("sheetName").toString(),"Expected Result",
							i, Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
					
					System.out.println(expectederrormsg);
					
					
					System.out.println(actualerrormsg);
					if(actualerrormsg.equals(expectederrormsg))
					{
						
						ut.setCellValue(prop.getProperty("sheetName").toString(), 
								prop.getProperty("ColumnName").toString(), i, "Expected and actual error messages are same",
								Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
						ut.setCellValue(prop.getProperty("sheetName").toString(), 
								"Status", i, "Pass",
								Integer.parseInt(prop.getProperty("rownumForColumnHeader").toString()));
						tearDown();
						SetUp();
					}
					tearDown();
					SetUp();
				}
				
				
								//UtilityMethods um= new UtilityMethods();
				//um.utility1(i, actualerrormsg);
				
				//loginEmail.PresenceOfPasswordField();
				
			}
		
		}
		
		
	}
	
	
	
	//Note file outstream has to be used at the end when all codes are run.even afatrtclass would also have done in this case.
	@AfterSuite
	public void fos()
	{
		ut.fileOpStrm(System.getProperty("user.dir")+prop.getProperty("path").toString());
	}

	@AfterMethod
	public void tearDown()
	{
		
		//driver.quit();
	}


}
