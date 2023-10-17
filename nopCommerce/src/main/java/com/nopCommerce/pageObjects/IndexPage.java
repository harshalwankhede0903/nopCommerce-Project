package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class IndexPage extends BaseClass
{
       
	
	   public IndexPage()
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	
	
	
	    @FindBy(xpath="//a[@class='ico-login']")
          WebElement signInBtn;
        
        @FindBy(xpath="//img[@alt='nopCommerce demo store']")
          WebElement nopCommerceLogo;
        
        @FindBy(xpath="//input[@placeholder='Search store']")
          WebElement searchBox;
        
        @FindBy(xpath="//button[@type='submit']")
          WebElement searchBtn;
        


        
       public LoginPage clickOnSignIn()
       {
    	   Action.click(driver, signInBtn);
    	   return new LoginPage();
    	   
       }
        
       public boolean validateLogo()
       {
           return Action.isDisplayed(driver, nopCommerceLogo);
       }
        
       public String getNopCommerceTitle()
       {
    	  String EcommerceWebsiteTitle = driver.getTitle();
    	  return EcommerceWebsiteTitle;
       }
        
       public SearchResultPage searchProduct(String productName)
       {
    	   Action.type(searchBox, productName);
    	   Action.click(driver, searchBtn);
    	   return new SearchResultPage();
       }
        
        
        
        


}
