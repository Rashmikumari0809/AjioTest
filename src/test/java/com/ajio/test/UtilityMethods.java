package com.ajio.test;



public class UtilityMethods extends LoginPageTest{
	

	public  void utility1(int i,String actualerrormsg)
	{
	
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
	}


}
