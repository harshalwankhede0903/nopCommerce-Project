package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class PaymentInformation extends BaseClass
{

	public PaymentInformation()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//button[text()='Continue'])[5]")
	  WebElement continueBtn3;
	
	public ConfirmOrder clickContinueBtn3()
	{
		Action.click(driver, continueBtn3);
		
		return new ConfirmOrder();
	}
	
	
	
	
	
}
