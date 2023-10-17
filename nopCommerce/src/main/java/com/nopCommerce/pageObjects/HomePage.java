package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class HomePage extends BaseClass
{

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
    
	@FindBy(xpath="//span[text()='Wishlist']")	
       WebElement wishlist;
    
	
	
	public boolean validateWishlist()
	{
		return Action.isDisplayed(driver, wishlist);
	}
	
	
	public String getCurrentURL()
	{
		String homePageURL = driver.getCurrentUrl();
		 return homePageURL;
	}
	
	
	
	
	
	
	
	
}
