package com.claimgenius.qa.testcases;


import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Test_cases_on_multi_select_box extends BaseClass
{
	public static WebDriverWait wait ;
	public static HomePage home ;
	public static Methods method ;

	@Test (priority=1)
	public void verify_multiselectbox_labeled_with_Selenium_Commands_is_present_on_webpage()
	{	
		home = new HomePage(driver);
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Selenium Commands')]")));
		
		boolean multi_selectbox = home.Is_multi_selectbox_labeled_with_continents_Available();

		Assert.assertTrue(multi_selectbox);

		log.info("Is multiselectbox labeled with Selenium Commands is present on webpage : "+multi_selectbox);
	}

	
	@Test (priority=2)
	public void verify_multiselectbox_labeled_with_Selenium_Commands_is_Active()
	{
		home = new HomePage(driver);

		boolean multi_selectbox = home.Is_multi_selectbox_labeled_with_continents_Active();

		Assert.assertTrue(multi_selectbox);

		log.info("IS multiselectbox labeled with Selenium Commands is Active : "+multi_selectbox);
	}
	 
	
	
	@Test (priority=3)
	public void get_total_counts_of_commands_present_in_selectbox_labeled_with_Selenium_Commands()
	{
		method = new Methods();
		method.scroll_down_to_continent_dropdown();
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Selenium Commands')]")));

		WebElement selenium_commands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));

		Select select = new Select(selenium_commands);

		List<WebElement> list_of_commands = select.getOptions();

		int total_commands = list_of_commands.size();
		
		System.out.println("Total counts of commands present in selectbox are : "+total_commands);
	}

	@Test (priority=4)
	public void get_name_of_each_command_of_total_count_present_in_selectbox_labeled_with_Selenium_Commands()
	{
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Selenium Commands')]")));

		WebElement selenium_commands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));

		Select select = new Select(selenium_commands);

		List<WebElement> list_of_commands = select.getOptions();

		int total_commands = list_of_commands.size();
		System.out.println("Total counts of commands present in selectbox are : "+total_commands);

		for (int i = 0; i < list_of_commands.size(); i++) 
		{
			String command_name= list_of_commands.get(i).getText();

			System.out.println(command_name);
		}
	}
	
	

	@Test (priority=5)
	public void select_any_particular_command_present_in_multiselectbox_labeled_with_Seenium_commands()
	{
		method = new Methods();
		method.scroll_down_to_continent_dropdown();
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Selenium Commands')]")));

		WebElement selenium_commands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));

		Select select = new Select(selenium_commands);

		List<WebElement> list_of_ccommands = select.getOptions();

		int total_continents = list_of_ccommands.size();
		System.out.println("Total continents are : "+total_continents);

		for (int i = 0; i < list_of_ccommands.size(); i++) 
		{
			String command_name= list_of_ccommands.get(i).getText();

			if (command_name.equals("Browser Commands")) 
			{
				list_of_ccommands.get(i).click();
				break;
			}
		}
		
		
	}
	
	@Test (priority=6)
	public void select_multiple_command_present_in_multiselectbox_labeled_with_Seenium_commands() throws Exception
	{
		Robot robot = new Robot();
		
		method = new Methods();
		method.scroll_down_to_continent_dropdown();
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Selenium Commands')]")));

		WebElement selenium_commands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));

		Select select = new Select(selenium_commands);
		select.selectByVisibleText("Browser Commands");
		
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		
		select.selectByVisibleText("Navigation Commands");
		
		List<WebElement> selected_commands = select.getAllSelectedOptions();
		for (int i = 0; i < selected_commands.size(); i++)
		{
			String command_name= selected_commands.get(i).getText();
			System.out.println(command_name);			
		}		
	}
}
