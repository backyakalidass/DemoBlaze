package com.bac.pageObjectOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageOR {
	
	private static CartPageOR cartPageInstance;
	
	private CartPageOR() {
		
	}
	
	public static CartPageOR getInstance() {
		if(cartPageInstance==null) {
			cartPageInstance = new CartPageOR();
		}
		
		return cartPageInstance;
	}
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	private WebElement placeOrder;	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	private WebElement addToCart;	
	@FindBy(xpath="//tr[@class='success']/td[2]")
	private WebElement addedProductTitle;
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	private WebElement deleteLink;
	@FindBy(xpath="//h2[contains(text(),'Total')]")
	private WebElement total;
	
	
	public WebElement getDeleteLink() {
		return deleteLink;
	}
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	public WebElement getAddedProductTitle() {
		return addedProductTitle;
	}
	public void clickPlaceOrder() {
		placeOrder.click();
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}
	public void clickDeleteLink() {
		deleteLink.click();
	}

}
