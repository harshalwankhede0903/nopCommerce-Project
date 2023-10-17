package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class ConfirmOrder extends BaseClass
{

	public ConfirmOrder()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Confirm']")
	  WebElement confirmBtn;
	
	
	public OrderPlacedSuccessfully clickConfirmBtn()
	{
		
		Action.moveToElement(driver, confirmBtn);
		
		Action.click(driver, confirmBtn);
		
		return new OrderPlacedSuccessfully();
	}
	
	
	
	
	
	
	
}
