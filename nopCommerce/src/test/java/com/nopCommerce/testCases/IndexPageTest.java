/**
 * 
 */
package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.pageObjects.IndexPage;

/**
 * @author ZMO-WIN-HarshalW-01
 *
 */
public class IndexPageTest extends BaseClass
{
    
	
	
	      IndexPage indexPage;
	   
	
	  
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
	   public void verifyLogo()
	   {
		   
		    indexPage = new IndexPage();
		   
		  boolean result = indexPage.validateLogo();
		  Assert.assertTrue(result);
		  
	   }
	   
	   @Test(groups="Smoke")
	   public void verifyTitle()
	   {
		   String acttitle = indexPage.getNopCommerceTitle();
		   System.out.println(acttitle);
		   Assert.assertEquals(acttitle, "nopCommerce demo store");
	   }
	   
	   
	   
	   
	
}
