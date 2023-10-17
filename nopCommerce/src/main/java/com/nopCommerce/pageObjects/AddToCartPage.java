package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.actionDriver.Action;
import com.nopCommerce.base.BaseClass;

public class AddToCartPage extends BaseClass
{

	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@class='qty-input']")
	  WebElement quantity;
	
	@FindBy(xpath="//button[@id='add-to-cart-button-28']")
	  WebElement addToCartBtn;
	
	@FindBy(xpath="//p[text()='The product has been added to your ']")
	  WebElement addToCartMassage;
	
	@FindBy(xpath="//span[@title='Close']")
	  WebElement popupCnacelBtn;
	
	@FindBy(xpath="//span[@class='cart-label']")
	  WebElement shoppingCart;
	
	@FindBy(xpath="//select[@name='checkout_attribute_1']")
	  WebElement wrapProduct;
	
	@FindBy(xpath="//button[@id='checkout']")
	  WebElement Checkout;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	  WebElement checkBoxTermConditions;
	
	
                                                                                                                                  //validate price unit and total price
	
	@FindBy(xpath="//td[@class='unit-price']//span")
	  WebElement unitPrice;
	
	@FindBy(xpath="(//td[@class='cart-total-right'])[4]/span/strong")
	  WebElement totalPrice;
	
	
	
	
	
    public void enterQuantity(String quantity1)
    {
    	Action.type(quantity, quantity1);
    }

    public void clickOnAddToCart()
    {
    	Action.click(driver, addToCartBtn);
    }

    public boolean validateAddToCardSuccsessfullyMassagePopup() throws InterruptedException
    {
    	Thread.sleep(2000);
    	return Action.isDisplayed(driver, addToCartMassage);
    }
   
    public void clickOnPopupCancelBtn()
    {
    	Action.click(driver, popupCnacelBtn);
    }
    
     public void clickOnShoppingCart() throws Exception
    {
    	Action.JSClick(driver, shoppingCart);

    }

    public void selectWrapping(String Wrapper)
    {
    	Action.selectByVisibleText(Wrapper, wrapProduct);
    }

    public void scrollToElementStillCheckoutBtn()
    {
        Action.moveToElement(driver, Checkout);
    }
    
       
   
    
  
//price Validation
    
    
    public double getUnitPrice()                                
    {
    	String unitPrice1 = unitPrice.getText();
    	String unit2 =unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
    	double finalUnitPrice =Double.parseDouble(unit2);
    	return finalUnitPrice/100;
    	
    }
    

    public double getTotalPrice()
    {
    	String totalPrice1 =totalPrice.getText();
    	String totalP2= totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
    	double finalTotalPrice = Double.parseDouble(totalP2);
    	return finalTotalPrice/100;
    }
    
    public void clickOnTermConditionCheckBox()
    {
    	Action.click(driver, checkBoxTermConditions);
    }

    
    public LoginPage clickCheckoutBtn() throws Exception
    {
    	Action.JSClick(driver, Checkout);
    	 
    	return new LoginPage();
    }
    
    public void clickOnTermConditionCheckBox1()
    {
    	Action.click(driver, checkBoxTermConditions);
    }

    public BillingAddress clickCheckoutBtn2() throws Exception
    {
    	Action.JSClick(driver, Checkout);
    	 
    	return new BillingAddress();
    }


}
