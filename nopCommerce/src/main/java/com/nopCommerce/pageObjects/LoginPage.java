/**
 * 
 */
package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

/**
 * @author ZMO-WIN-HarshalW-01
 *
 */
public class LoginPage extends BaseClass
{
             
	     
	    public LoginPage()
	   {
		PageFactory.initElements(driver, this);
	   }
	
	
	
	   @FindBy(xpath="//input[@id='Email']")
	     WebElement userName;
	
	   @FindBy(xpath="//input[@id='Password']")
	     WebElement password;
	
       @FindBy(xpath="(//button[@type='submit'])[2]")
         WebElement signInBtn;

       @FindBy(xpath="//button[@class='button-1 register-button']")
         WebElement newRagisterBtn;

      public HomePage login(String uname ,String pswd)
      {
    	  Action.type(userName, uname);
    	  Action.type(password, pswd);
    	  Action.click(driver, signInBtn);
    	  
    	  return new HomePage();
      }

      public AddToCartPage login1(String uname ,String pswd)
      {
    	  Action.type(userName, uname);
    	  Action.type(password, pswd);
    	  Action.click(driver, signInBtn);
    	  
    	  return new AddToCartPage();
      }

      
      
      public NewRagister newUserRagister()
      {
    	  Action.click(driver, newRagisterBtn);
    	  
    	  return new NewRagister();
      }






}
