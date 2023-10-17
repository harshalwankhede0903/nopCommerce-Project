package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.pageObjects.IndexPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.NewRagister;

public class NewRagisterTest extends BaseClass
{
   
	   IndexPage indexPage;
	   LoginPage loginPage;
	   NewRagister newRagister;
	   
	   @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	   @Parameters("browser")
       public void setUp(String browser)
	   {
		 launchApp(browser);
	   }
	
	   @AfterMethod(groups= {"Smoke","Sanity","Regression"})
	   public void tearDown()
	   {
		   driver.quit();
	   }
	  
	
	  @Test(groups="Sanity")
      public void verifyAccountCreationPage()
      {
    	  indexPage = new IndexPage();
    	  loginPage = indexPage.clickOnSignIn();
    	  newRagister = loginPage.newUserRagister();
    	  boolean result = newRagister.validateAccountCreatePage();
    	  Assert.assertTrue(result);
    	  
    	  
    	  
      }










}
