package com.claimgenius.qa.testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.claimGenius.qa.base.BaseClass;
import com.claimGenius.qa.pages.HomePage;
import com.claimGenius.qa.util.XLUtils;

import methods.Methods;


public class DDT_Test_case_on_text_box extends BaseClass
{
	@Test(dataProvider="DDT_data")
	public void verify_user_able_to_enter_value_in_text_fields(String first_name, String last_name)
	{
		HomePage homepage = new HomePage(driver);

		Methods scrolling = new Methods();	
		scrolling.scroll_down_to_first_name_field();

		homepage.set_First_Name(first_name);

		homepage.set_Last_Name(last_name);	
	}


	@DataProvider(name="DDT_data")
	String [][] getData() throws Exception
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/claimGenius/qa/testdata/Assignment_Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String data[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				data[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
		}	
		return data;
	}
}
