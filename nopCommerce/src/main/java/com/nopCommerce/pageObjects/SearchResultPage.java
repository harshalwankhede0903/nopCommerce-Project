package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class SearchResultPage extends BaseClass
{

	
	
	  public SearchResultPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	
	
	@FindBy(xpath="//img[@alt='Picture of Oversized Women T-Shirt']")
	   WebElement productResult;
	
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		Action.click(driver, productResult);
		
		return new AddToCartPage();
	}
	
	








}
