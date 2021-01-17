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

public class Test_cases_on_radio_button extends BaseClass
{
	public static WebDriverWait wait ;
	public static HomePage home ;
	public static Methods method ;



	@Test (priority=1)
	public void verify_radio_buttons_are_active_on_webpage()
	{
		home = new HomePage(driver);
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sex-0")));
		
		boolean Male = home.Is_radio_button_labeled_with_Male_Active();
		boolean Female = home.Is_radio_button_labeled_with_Female_Active();
		
		Assert.assertTrue(Male);
		Assert.assertTrue(Female);
		
		log.info("Is radio button labeled with Male Active : "+Male);
		log.info("Is radio button labeled with Female Active : "+Female);
	}


	
	@Test (priority=2)
	public void verify_user_able_to_select_Radio_button_labeled_with_Male()
	{
		home = new HomePage(driver);
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sex-0")));

		home.select_male_radio_button();

		boolean Male = home.Is_radio_button_labeled_with_Male_selected();

		Assert.assertTrue(Male);

		log.info("Is user able to select Radio button labeled with Male : "+Male);
	}

	
	
	@Test (priority=3)
	public void verify_user_able_to_select_Radio_button_labeled_with_Female()
	{
		home = new HomePage(driver);
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sex-1")));

		home.select_Female_radio_button();

		boolean Female = home.Is_radio_button_labeled_with_Female_selected();

		Assert.assertTrue(Female);
		
		log.info("Is user able to select Radio button labeled with Female : "+Female);
	}
	
	
	
	@Test (priority=4)
	public void get_labe_of_each_radio_button()
	{
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio'][@name='sex']"));
		
		for (int i = 0; i < radio.size(); i++)
		{	
			WebElement radio_button = radio.get(i);
			
			String radio_button_name = radio_button.getAttribute("value");
			
			System.out.println("radio button name is : "+radio_button_name);		
		}
	}
	
	
	
	@Test (priority=5)
	public void get_labe_of_each_radio_button_and_select_specific_one()
	{
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio'][@name='sex']"));
		
		for (int i = 0; i < radio.size(); i++)
		{
			method = new Methods();
			method.scroll_down_to_first_name_field();
			
			WebElement radio_button = radio.get(i);
			
			String radio_button_name = radio_button.getAttribute("value");	
			
			//Now select Male radio button
			
			if (radio_button_name.equals("Male")) 
			{
				radio_button.click();
				break;
			}
		}
	}

}
