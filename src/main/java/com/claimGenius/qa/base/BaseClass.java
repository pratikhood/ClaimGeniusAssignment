package com.claimGenius.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.claimGenius.qa.util.ReadConfig;
import com.claimGenius.qa.util.Wait;

import methods.Methods;


public class BaseClass 
{
	
	
	public static ReadConfig readConfig  = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String Chromepath = readConfig.getChromePath();
	public String Firefoxpath = readConfig.getFirefoxPath();
	public String IEpath = readConfig.getIEPath();

	
	public static WebDriver driver;
	public static Logger log;
	public static Methods method;
	
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws Exception
	{
		 
		
		log = Logger.getLogger("BaseClass");

		PropertyConfigurator.configure("Log4j.properties");
		 

		if(br.equals("chrome"))
		{	
			method = new Methods();
			
			System.setProperty("webdriver.chrome.driver",Chromepath);
			driver = new ChromeDriver();
			
			method.get_current_date_and_time();
			log.info("Chrome browser launched");


			/*
			//-----------To run the test cases in headless mode---------------//

			System.setProperty("webdriver.chrome.driver", Chromepath);

			// Create Object of ChromeOption Class
			ChromeOptions option=new ChromeOptions();

			//Set the setHeadless is equal to true which will run test in Headless mode
			option.setHeadless(true);

			// pass the option object in ChromeDriver constructor
			driver = new ChromeDriver(option);
			log.info("Chrome browser launched");
			 */



			/*------------Handle Proxy in Selenium Webdriver----------------*/
			/*
			// Create proxy class object
			Proxy p=new Proxy();

			// Set HTTP Port to 7777
			p.setHttpProxy("localhost:7777");

			// Create desired Capability object
			DesiredCapabilities cap=new DesiredCapabilities();

			// Pass proxy object p
			cap.setCapability(CapabilityType.PROXY, p);
			
			System.setProperty("webdriver.chrome.driver", Chromepath);
			driver = new ChromeDriver(cap);
			log.info("Chrome browser launched");
			*/
		}	
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", Firefoxpath);
			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", IEpath);
			driver = new InternetExplorerDriver();
			log.info("IE browser launched");
		}

		driver.get(baseURL);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Wait.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Wait.IMPLICIT_WAIT, TimeUnit.SECONDS);

		if(driver.getTitle().equals("Selenium Practice Form"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"setup");
			Assert.assertTrue(false);
		}
	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	 	

	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
