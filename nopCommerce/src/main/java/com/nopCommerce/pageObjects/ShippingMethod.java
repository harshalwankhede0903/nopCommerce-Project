package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class ShippingMethod extends BaseClass
{
    
	    public ShippingMethod()
	    {
	      PageFactory.initElements(driver, this);
	    }
	                  
	  
   	 @FindBy(xpath="(//button[text()='Continue'])[3]") 
   	   WebElement continueBtn;
	
	    
	    public PaymentMethod clickContinueBtnShipping() throws Exception
	    {
	    	Action.JSClick(driver, continueBtn);
	    	
	    	return new PaymentMethod();
	    }
	    
	    
	    
	    
}
