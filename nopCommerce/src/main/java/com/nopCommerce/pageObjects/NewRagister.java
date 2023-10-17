package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class NewRagister extends BaseClass
{

	
	   public NewRagister()
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	
	
	   
	   
	   @FindBy(xpath="(//div[@class='title'])[1]")
	     WebElement formTitle;
	   
	   
	   
	   public boolean validateAccountCreatePage()
	   {
		  return Action.isDisplayed(driver, formTitle);
	   }
	   
	   
	   
	
	
	
	
}
