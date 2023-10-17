package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.dataProvider.DataProviders;
import com.nopCommerce.pageObjects.AddToCartPage;
import com.nopCommerce.pageObjects.BillingAddress;
import com.nopCommerce.pageObjects.IndexPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchResultPage;

public class AddToCartTest extends BaseClass
{
      
	
	   IndexPage indexPage;
	   SearchResultPage searchResultPage;
	   AddToCartPage addToCartPage;
	   LoginPage loginPage;
	   BillingAddress billingAddress;
	  
	
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
	
	  @Test(dataProvider="product",dataProviderClass=DataProviders.class,groups={"Regression","Sanity"})
	  public void addToCartTest(String ProductName,String Qty) throws Exception 
	  {
		  indexPage = new IndexPage();
		  searchResultPage = indexPage.searchProduct(ProductName);
		  addToCartPage = searchResultPage.clickOnProduct();
		  addToCartPage.enterQuantity(Qty);
		  addToCartPage.clickOnAddToCart();
		  boolean result = addToCartPage.validateAddToCardSuccsessfullyMassagePopup();
		  Assert.assertTrue(result);
		  addToCartPage.clickOnPopupCancelBtn();
		  addToCartPage.clickOnShoppingCart();
		  addToCartPage.selectWrapping("Yes [+$10.00]");
		 
		  double unitPrice = addToCartPage.getUnitPrice();
		  System.out.println(unitPrice);                           //24$ for each
		  double totalPrice = addToCartPage.getTotalPrice();
		  System.out.println(totalPrice);                         //48$
		  double totalPriceWithWrapping = totalPrice+10;          //48$ + 10$ wapping =58$
		  double totalExpectedPrice = unitPrice*Double.valueOf(Qty)+10;           //(24$*2)+10$= 58$
		  System.out.println(totalExpectedPrice);
		  Assert.assertEquals(totalPriceWithWrapping, totalExpectedPrice);
		  
		  addToCartPage.clickOnTermConditionCheckBox();
		  loginPage = addToCartPage.clickCheckoutBtn();
		  addToCartPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		  addToCartPage.clickOnTermConditionCheckBox1();
		  billingAddress= addToCartPage.clickCheckoutBtn2();
		  
	  }









}
