package com.nopCommerce.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
      
	     
	     public static Properties prop;
		 public static WebDriver driver;
	     public static Logger logger;

                 
		 
		 
		 @BeforeSuite(groups= {"Smoke","Sanity","Regression"})
		 public void loadConfig()
		 {
	    	   logger = Logger.getLogger("nopCommerce");
               PropertyConfigurator.configure("log4j.properties");
              
              ExtentManager.setExtent();                 //for Extent Report
              
              
             
              
              File src = new File("./Configuration/Config.properties");
 			 
 			 try{
 		          FileInputStream ip = new FileInputStream(src);
 		          prop = new Properties();
 		          prop.load(ip);
 		        }
 	         catch(Exception e)
 	            {
 	    	      System.out.println("Exception is " +e.getMessage());
              
 	            }
              
              
		 }
		 	
		 
		 public static WebDriver getDriver() 
		 {
				// TODO Auto-generated method stub
				return driver;
		 }
		 
	    
	    
		public static void launchApp(String browserName)
		{
			
			//String browserName = prop.getProperty("browser");         //data from configuration file
	    	
	    	
	    	if(browserName.equalsIgnoreCase("Chrome"))
	    	{
	            driver = new ChromeDriver();
	    	}
	    	else if (browserName.equalsIgnoreCase("Edge"))
	    	{
	    		driver = new EdgeDriver();
	    	}
	    	else if (browserName.equalsIgnoreCase("Firefox"))
	    	{
	    		driver = new FirefoxDriver();
	    	}
	    
	    	    driver.manage().window().maximize();
		        Action.implicitWait(driver, 10);
                Action.pageLoadTimeOut(driver, 30);
		        driver.get(prop.getProperty("url"));
		        
		
		}
		
		
		
		@AfterSuite
		public void afterSuite()
		{
			ExtentManager.endReport();                 //for end the report
		}




		



























}
