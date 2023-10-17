package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class PaymentMethod extends BaseClass
{
 
	public PaymentMethod()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//button[@name='save'])[2]")
	  WebElement continueBtn1;
	
	
	public PaymentInformation clickContinueBtn2()
	{
		Action.click(driver, continueBtn1);
		
		return new PaymentInformation();
	}
	
	
}
