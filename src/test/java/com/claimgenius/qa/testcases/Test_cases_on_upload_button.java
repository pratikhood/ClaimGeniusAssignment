package com.claimgenius.qa.testcases;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.claimGenius.qa.base.BaseClass;
import com.claimGenius.qa.pages.HomePage;

import methods.Methods;

public class Test_cases_on_upload_button extends BaseClass 
{
	public String uploadPath = readConfig.getFileUploadPath();
	
	public static HomePage home ;
	public static Methods method ;
	public static WebDriverWait wait ;
	
	
	@Test (priority=3)
	public void verify_user_able_to_upload_image() throws Exception
	{
		Thread.sleep(3000);
		
		method = new Methods();
		method.scroll_down_to_uppload_button();
		
		Thread.sleep(2000);
		

		method = new Methods();
		method.scroll_down_to_first_name_field();
		

		WebElement element = driver.findElement(By.xpath("//input[@id='photo']"));
		new Actions(driver).click(element).perform();
		
		Runtime.getRuntime().exec(uploadPath);
		
	}
	

	@Test 
	public void verify_is_upload_button_active() throws Exception
	{	
		home = new HomePage(driver);

		boolean UploadButton = home.Is_upload_button_labeled_with_Upload_Image_Active();

		Assert.assertTrue(UploadButton);

		log.info("Is multiselect dropdown labeled with continents Active : "+UploadButton);
	}
	
}
