package com.claimgenius.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.claimGenius.qa.base.BaseClass;
import com.claimGenius.qa.pages.HomePage;
import com.claimGenius.qa.util.XLUtils;

import methods.Methods;

public class Test_cases_on_textbox extends BaseClass
{
	public static HomePage home ;
	public static Methods method ;

	@Test 
	public void verify_textbox_labeled_with_First_Name_is_present()
	{
		boolean First_Name = home.Is_Textbox_labeled_with_First_Name_Available();

		Assert.assertTrue(First_Name);
		
		log.info("Is Textbox labeled with First Name Available : "+First_Name);
	}

	
	
	@Test 
	public void verify_textbox_labeled_with_First_Name_is_enabled()
	{
		home = new HomePage(driver);

		boolean First_Name = home.Is_Textbox_labeled_with_First_Name_Active();

		Assert.assertTrue(First_Name);
		
		log.info("Is Textbox labeled with First Name Active : "+First_Name);
	}

	
	
	@Test(dataProvider="DDT_data")
	public void verify_user_able_to_enter_value_in_textbox_labeled_with_First_Name(String firstname) throws Exception
	{
		home = new HomePage(driver);
		
		method = new Methods();
		method.scroll_down_to_first_name_field();
		
		home.set_First_Name(firstname);
		Thread.sleep(2000);
		String value_in_first_name_text_box = home.capture_value_of_text_box_labeled_with_First_Name();
		
		Assert.assertEquals(value_in_first_name_text_box, "Pratik");
	}
	
	
	
	@Test(dataProvider="DDT_data_new_name")
	public void verify_user_able_to_re_enter_value_in_textbox_labeled_with_First_Name(String name) throws Exception
	{
		home = new HomePage(driver);
		
		method = new Methods();
		method.scroll_down_to_first_name_field();
		
		home.set_First_Name(name);
		Thread.sleep(1500);
		
		home.clear_value_of_text_box_labeled_with_First_Name();
		
		home.set_First_Name(name);
		Thread.sleep(1500);
		
		String value_in_first_name_text_box = home.capture_value_of_text_box_labeled_with_First_Name();
		
		Assert.assertEquals(value_in_first_name_text_box, "Raj");
	}

	
	@DataProvider(name="DDT_data")
	String [][] getData() throws Exception
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/claimGenius/qa/testdata/Assignment_Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet2");
		int colcount=XLUtils.getCellCount(path,"Sheet2",1);
		
		String data[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				data[i-1][j]=XLUtils.getCellData(path,"Sheet2", i,j);//1 0
			}
		}	
		return data;
	}
	
	@DataProvider(name="DDT_data_new_name")
	String [][] getData_new_name() throws Exception
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/claimGenius/qa/testdata/Assignment_Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet3");
		int colcount=XLUtils.getCellCount(path,"Sheet3",1);
		
		String data[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				data[i-1][j]=XLUtils.getCellData(path,"Sheet3", i,j);//1 0
			}
		}	
		return data;
	}
}
