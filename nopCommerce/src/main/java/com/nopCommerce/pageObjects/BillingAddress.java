package com.nopCommerce.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class BillingAddress extends BaseClass
{
     
	
	public BillingAddress()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	  WebElement country;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	  WebElement cityName;

    @FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	  WebElement address;

    @FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	  WebElement pincode;

    @FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
      WebElement MobileNumber;

    @FindBy(xpath="(//button[@name='save'])[1]")
      WebElement continueBtn;
    
    
    @FindBy(xpath="//button[@onclick='Billing.save()']")
      WebElement ContinueBtnForAddress;


  public void countryName(String Country)
  {
	  Action.selectByVisibleText(Country, country);
  }


  public void city(String City)
  {
	  Action.type(cityName, City);
  }

  
  public void Address(String ads)
  {
	  Action.type(address, ads);
  }
  
  public void PostCode(String code)
  {
	  Action.type(pincode, code);
  }

  public void PhoneNumber(String number)
  {
	  Action.type(MobileNumber, number);
  }

  public ShippingMethod clickOnContinueBtn() throws Exception
  {
	  Action.JSClick(driver, continueBtn );
	  
	  return new ShippingMethod();
  }

   
  
  
  public ShippingMethod continueBtnBillingAddress() throws Exception
  {
	  Action.JSClick(driver, ContinueBtnForAddress);
	return new ShippingMethod();
  }
  
  
  
  
  
  
  
  
  
  
  
}

