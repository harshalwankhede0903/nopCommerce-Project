package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.base.BaseClass;

public class OrderPlacedSuccessfully extends BaseClass
{
   
	  public OrderPlacedSuccessfully()
	  {
		  PageFactory.initElements(driver, this);
	  }
	
	 
	  @FindBy(xpath="//strong[text()='Your order has been successfully processed!']")
	    WebElement confirmMassage;
	
	
     public String validateConfirmMassage()
     {
	    String confirmMsg = confirmMassage.getText();
	  
	     return confirmMsg;
     }







}
