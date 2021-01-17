package methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.claimGenius.qa.base.BaseClass;

public class Methods extends BaseClass
{
	
	@Test
	public void scroll_down_to_first_name_field()
	{
		WebElement text_box_labeled_with_first_name = driver.findElement(By.name("firstname"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", text_box_labeled_with_first_name);
	}
	
	@Test
	public void scroll_down_to_continent_dropdown()
	{
		WebElement dropdown = driver.findElement(By.id("continents"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dropdown);
	}
	
	@Test
	public void scroll_down_to_uppload_button()
	{
		WebElement upload_button = driver.findElement(By.id("photo"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", upload_button);
	}
	
	
	@Test
	public void scroll_down_to_radio_button()
	{
		WebElement upload_button = driver.findElement(By.id("sex-0"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", upload_button);
	}
	
	@Test
	public void get_current_date_and_time()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println("Todays Date and time ----> "+ date1);
	}
	
	@Test
	public void click_on_uppload_button()
	{
		WebElement element = driver.findElement(By.id("photo"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
}
