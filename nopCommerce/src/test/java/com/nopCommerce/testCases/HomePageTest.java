package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.pageObjects.HomePage;
import com.nopCommerce.pageObjects.IndexPage;
import com.nopCommerce.pageObjects.LoginPage;

public class HomePageTest extends BaseClass
{

	 IndexPage indexPage;
	 LoginPage loginPage;
	 HomePage  homePage;
	
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
	
	
	   @Test(groups="Smoke")
	   public void wishListTest() throws InterruptedException
	   {
		   indexPage = new IndexPage();
		   loginPage = indexPage.clickOnSignIn();
		   homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		   boolean result = homePage.validateWishlist();
		   Assert.assertTrue(result);
	   
	   }








}
