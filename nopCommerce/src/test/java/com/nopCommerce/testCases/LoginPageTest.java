package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.dataProvider.DataProviders;
import com.nopCommerce.pageObjects.HomePage;
import com.nopCommerce.pageObjects.IndexPage;
import com.nopCommerce.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass
{
    
	
	    IndexPage indexPage;
	    LoginPage loginPage;
	    HomePage homePage;
	
	 @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	 @Parameters("browser")           //parameter value means browser value give in testng.xml
     public void setUp(String browser)
     {
	  launchApp(browser);
	 }
	 @AfterMethod(groups= {"Smoke","Sanity","Regression"})
     public void tearDown()
     {
    	 driver.quit();
     }
                                                      
	                                      //class name mention here
     @Test(dataProvider="credentials" , dataProviderClass=DataProviders.class ,groups={"Smoke","Sanity"})                   //from DataProviders Class
     public void login(String uname1 , String pswd1) throws InterruptedException
     {
         logger.info("Login process Start ...");

    	 indexPage = new IndexPage();
         loginPage = indexPage.clickOnSignIn();
        // homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));        configuration file data 
           homePage = loginPage.login(uname1, pswd1);                                                //DataProvider From Excel File
          String actualURL = homePage.getCurrentURL();
          System.out.println(actualURL);
          String expectedURL ="https://demo.nopcommerce.com/";
          Assert.assertEquals(actualURL, expectedURL);
          logger.info("Login Succssfull...");
          
     }




}
