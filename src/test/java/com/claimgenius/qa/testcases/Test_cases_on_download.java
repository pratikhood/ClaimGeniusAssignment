package com.claimgenius.qa.testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.claimGenius.qa.pages.HomePage;
import com.claimGenius.qa.util.ReadConfig;


import methods.Methods;

public class Test_cases_on_download 
{
	public static ReadConfig readConfig  = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String Chromepath = readConfig.getChromePath();
	
	public static WebDriverWait wait ;
	public static HomePage home ;
	public static Methods method ;
	File folder;
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		//will create a random UUID number like 13245-54111-84141-87444-54998
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir(); //It will return whether the file created or not
		
		System.setProperty("webdriver.chrome.driver","C://cucumberProject//Claim_Genius//Drivers//chromedriver.exe");
		
		//ChromeOptions options=new ChromeOptions();
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		ChromeDriverService service = new ChromeDriverService.Builder()
		                            .usingDriverExecutable(new File("C://cucumberProject//Claim_Genius//Drivers//chromedriver.exe"))
		                            .usingAnyFreePort()
		                            .build();
		
		ChromeOptions options = new ChromeOptions();
		
		options.merge(capabilities);    
		
		
		Map<String,Object> prefs =new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		

		 driver = new ChromeDriver(service, options);	
	}
	
	
	@Test
	public void downloadFile() throws Exception
	{
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

        

        //Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.xpath("//span[contains(text(),'Download File')]"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		driver.findElement(By.xpath("//a[contains(text(),'Click here to Download File')]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame("aswift_6");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		Thread.sleep(2000);
		
		//click on code menu
		driver.findElement(By.xpath("//span[contains(text(),'Code')]")).click();
		Thread.sleep(2000);
		
		//click on code button
		driver.findElement(By.xpath("//body/div[4]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/get-repo[1]/details[1]/summary[1]")).click();
		Thread.sleep(2000);
		
		//click on download zip
		driver.findElement(By.xpath("//body/div[4]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/get-repo[1]/details[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		
		File listOfFiles [] = folder.listFiles();
		
		driver.navigate().refresh();
		
		Thread.sleep(1500);
		
		Assert.assertFalse(listOfFiles.length>0);

		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		/*
		for(File file:folder.listFiles())
		{
			
			file.delete();
		}
		folder.delete();
		*/
	}
	
}











