package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.pageObjects.IndexPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchResultPage;

public class SerachResultPageTest extends BaseClass
{

	   IndexPage indexPage;
	   LoginPage loginPage;
	   SearchResultPage searchResultPage;
	
	
	
	  @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	  @Parameters("browser")
      public void setUp(String browser)
	  {
		launchApp(browser);
	  }
	  
	  @AfterTest(groups= {"Smoke","Sanity","Regression"})
	  public void tearDown()
	  {
		  driver.quit();
	  }
	
	  @Test(groups="Smoke")
	  public void productAvilabilityTest() 
	  {
		  indexPage = new IndexPage();
		  searchResultPage = indexPage.searchProduct("t-shirt");
		  boolean result = searchResultPage.isProductAvailable();
		  Assert.assertTrue(result);
	  }
	
	
	
	
}
