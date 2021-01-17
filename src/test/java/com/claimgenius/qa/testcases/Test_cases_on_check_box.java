package com.claimgenius.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.claimGenius.qa.base.BaseClass;
import com.claimGenius.qa.pages.HomePage;

import methods.Methods;

public class Test_cases_on_check_box extends BaseClass 
{
	public static WebDriverWait wait ;
	public static HomePage home ;
	public static Methods method ;

	


	
	@Test (priority=1)
	public void verify_checkboxes_labeled_with_profession_are_active_on_webpage()
	{
		home = new HomePage(driver);
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profession-1")));
		
		boolean manual = home.Is_checkbox_labeled_with_Manual_Tester_Active();
		boolean automation = home.Is_checkbox_labeled_with_Automation_Tester_Active();
		
		Assert.assertTrue(manual);
		Assert.assertTrue(automation);
		
		log.info("Is checkbox labeled with Manual Tester Active : "+manual);
		log.info("Is checkbox labeled with Automation Tester Active : "+automation);
	}



	@Test (priority=2)
	public void verify_checkboxe_labeled_with_Manual_Tester_is_selected()
	{
		home = new HomePage(driver);
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profession-1")));

		home.select_Manual_Tester_checkbox();

		boolean manual = home.Is_checkbox_labeled_with_Manual_Tester_selected();

		Assert.assertTrue(manual);

		log.info("Is user able to select checkbox labeled with Manual Tester : "+manual);
	}

	

	@Test (priority=3)
	public void get_label_of_checkboxes_present_on_webpage()
	{
		List<WebElement> radio = driver.findElements(By.xpath("//input[@name='profession'][@type='checkbox']"));

		for (int i = 0; i < radio.size(); i++)
		{
			WebElement checkbox = radio.get(i);

			String checkbox_name = checkbox.getAttribute("value");

			System.out.println("checkbox name is : "+checkbox_name);		
		}
	}


	@Test (priority=4)
	public void get_label_of_checkboxes_and_check_on_checkbox_label_with_Automation_Tester()
	{
		List<WebElement> radio = driver.findElements(By.xpath("//input[@name='profession'][@type='checkbox']"));

		for (int i = 0; i < radio.size(); i++)
		{
			WebElement checkbox = radio.get(i);

			String checkbox_name = checkbox.getAttribute("value");

			if (checkbox_name.equals("Automation Tester")) 
			{
				checkbox.click();
				break;
			}		
		}
		
		
	}
}
