package com.claimgenius.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.claimGenius.qa.base.BaseClass;
import com.claimGenius.qa.pages.HomePage;
import methods.Methods;

public class Test_cases_on_dropdown extends BaseClass
{
	public static WebDriverWait wait ;
	public static HomePage home ;
	public static Methods method ;

	@Test (priority=1)
	public void verify_selectbox_labeled_with_continents_is_present_on_webpage()
	{	
		home = new HomePage(driver);

		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='continents']")));

		boolean Continents = home.Is_selectbox_labeled_with_continents_Available();

		Assert.assertTrue(Continents);

		log.info("Is multiselect dropdown labeled with continents Available : "+Continents);
	}

	@Test (priority=2)
	public void verify_selectbox_labeled_with_continents_is_active()
	{
		home = new HomePage(driver);

		boolean Continents = home.Is_selectbox_labeled_with_continents_Active();

		Assert.assertTrue(Continents);

		log.info("Is multiselect dropdown labeled with continents Active : "+Continents);
	}


	@Test (priority=3)
	public void get_total_counts_of_Continents_present_in_selectbox_labeled_with_Continents()
	{
		method = new Methods();
		method.scroll_down_to_continent_dropdown();

		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='continents']")));

		WebElement Continents = driver.findElement(By.xpath("//select[@id='continents']"));

		Select select = new Select(Continents);

		List<WebElement> list_of_continents = select.getOptions();

		int total_continents = list_of_continents.size();

		System.out.println("Total continents are : "+total_continents);
	}



	@Test (priority=4)
	public void get_name_of_total_counts_of_Continents_present_in_selectbox_labeled_with_Continents()
	{
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='continents']")));

		WebElement Continents = driver.findElement(By.xpath("//select[@id='continents']"));

		Select select = new Select(Continents);

		List<WebElement> list_of_continents = select.getOptions();

		int total_continents = list_of_continents.size();
		System.out.println("Total continents are : "+total_continents);

		for (int i = 0; i < list_of_continents.size(); i++) 
		{
			String continent_name= list_of_continents.get(i).getText();

			System.out.println(continent_name);
		}
	}



	@Test (priority=5)
	public void select_any_particular_Continent_present_in_selectbox_labeled_with_Continents()
	{
		wait=new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='continents']")));

		WebElement Continents = driver.findElement(By.xpath("//select[@id='continents']"));

		Select select = new Select(Continents);

		List<WebElement> list_of_continents = select.getOptions();

		int total_continents = list_of_continents.size();
		System.out.println("Total continents are : "+total_continents);

		for (int i = 0; i < list_of_continents.size(); i++) 
		{
			String continent_name= list_of_continents.get(i).getText();

			if (continent_name.equals("South America")) 
			{
				list_of_continents.get(i).click();
				break;
			}
		}

		List<WebElement> selected_commands = select.getAllSelectedOptions();
		for (int i = 0; i < selected_commands.size(); i++)
		{
			String continent_name= selected_commands.get(i).getText();
			System.out.println(continent_name);

			Assert.assertEquals(continent_name, "South America");

		}
	}
}


