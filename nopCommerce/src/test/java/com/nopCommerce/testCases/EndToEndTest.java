package com.nopCommerce.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopCommerce.base.BaseClass;
import com.nopCommerce.pageObjects.AddToCartPage;
import com.nopCommerce.pageObjects.BillingAddress;
import com.nopCommerce.pageObjects.ConfirmOrder;
import com.nopCommerce.pageObjects.IndexPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.OrderPlacedSuccessfully;
import com.nopCommerce.pageObjects.PaymentInformation;
import com.nopCommerce.pageObjects.PaymentMethod;
import com.nopCommerce.pageObjects.SearchResultPage;
import com.nopCommerce.pageObjects.ShippingMethod;

public class EndToEndTest extends BaseClass
{

	
	   IndexPage indexPage;
	   SearchResultPage searchResultPage;
	   AddToCartPage addToCartPage;
	   LoginPage loginPage;
	   BillingAddress billingAddress;
	   ShippingMethod shippingMethod;
	   PaymentMethod paymentMethod;
	   PaymentInformation paymentInformation;
	   ConfirmOrder confirmOrder;
	   OrderPlacedSuccessfully orderPlacedSuccessfully;
	
	  @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	  @Parameters("browser")
      public void setUp(String browser)
	  {
		launchApp(browser);
	  }
	
	  @AfterMethod(groups= {"Smoke","Sanity","Regression"})
	  public void tearDown()
	  {
		  //driver.quit();
	  }
	
	  @Test
	  public void endToEndTest() throws Exception
	  {
		  indexPage = new IndexPage();
		  searchResultPage = indexPage.searchProduct("t-shirt");
		  addToCartPage = searchResultPage.clickOnProduct();
		  addToCartPage.enterQuantity("2");
		  addToCartPage.clickOnAddToCart();
		  boolean result = addToCartPage.validateAddToCardSuccsessfullyMassagePopup();
		  Assert.assertTrue(result);
		  addToCartPage.clickOnPopupCancelBtn();
		  addToCartPage.clickOnShoppingCart();
		  addToCartPage.selectWrapping("Yes [+$10.00]");
		  
		  addToCartPage.clickOnTermConditionCheckBox();
		  loginPage = addToCartPage.clickCheckoutBtn();
		  addToCartPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		  addToCartPage.clickOnTermConditionCheckBox1();
		  
		  billingAddress= addToCartPage.clickCheckoutBtn2();
		  
		 
		  billingAddress.countryName("India");
		  billingAddress.city("Pune");
		  billingAddress.Address(" Royal Emirates PG Viman nagar Pune ");
		  billingAddress.PostCode("411114");
		  billingAddress.PhoneNumber("7878990987");
		  shippingMethod = billingAddress.clickOnContinueBtn();
		  
		 // shippingMethod=billingAddress.continueBtnBillingAddress();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		  driver.findElement(By.xpath("(//button[text()='Continue'])[3]")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		  driver.findElement(By.xpath("(//button[text()='Continue'])[4]")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		  driver.findElement(By.xpath("(//button[text()='Continue'])[5]")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		  driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		  
		 String order = orderPlacedSuccessfully.validateConfirmMassage();
		  System.out.println(order);
		
		 
	  }
	
	
	
	
	
	
	
	
	
}
