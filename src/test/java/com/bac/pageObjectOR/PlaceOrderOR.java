package com.bac.pageObjectOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bac.constants.Constants;

public class PlaceOrderOR {
	private static PlaceOrderOR placeOrderInstance;
	
	private PlaceOrderOR() {
		
	}
	
	public static PlaceOrderOR getInstance() {
		if(placeOrderInstance==null) {
			placeOrderInstance = new PlaceOrderOR();
		}
		
		return placeOrderInstance;
	}
	
	@FindBy(xpath="//h5[contains(text(),'Place order')]")
	private WebElement placeOrderFormHeading;
	@FindBy(xpath="//label[@id='totalm']")
	private WebElement total ;
	@FindBy(xpath="//input[@id='name']")
	private WebElement name ;
	@FindBy(xpath="//input[@id='country']")
	private WebElement country ;
	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	@FindBy(xpath="//input[@id='card']")
	private WebElement creditCard;
	@FindBy(xpath="//input[@id='month']")
	private WebElement month;
	@FindBy(xpath="//input[@id='year']")
	private WebElement year;
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	private WebElement purchase;
	@FindBy(xpath="//button[contains(text(),'Purchase')]//preceding::button[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'Purchase')]//preceding::button[2]")
	private WebElement closeIcon;
	@FindBy(xpath="//h2[contains(text(),'Thank you for your purchase!')]")
	private WebElement thankYouPurchase;
	@FindBy(xpath="//p[contains(text(),'Id:')]")
	private WebElement tyId;
	@FindBy(xpath="//br//following::text()[contains(.,'Amount:')]")
	private WebElement tyAmount;
	@FindBy(xpath="//br//following::text()[contains(.,'Card')]")
	private WebElement tyCardNumber;
	@FindBy(xpath="//br//following::text()[contains(.,'Name:')]")
	private WebElement tyName;
	@FindBy(xpath="//br//following::text()[contains(.,'Date:')]")
	private WebElement tyDate;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement tyOk;
	@FindBy(xpath="//p[@class='lead text-muted ']")
	private WebElement tyParagraph;
	
	public WebElement getTyParagraph() {
		return tyParagraph;
	}
	
	public WebElement getTyId() {
		return tyId;
	}

	public WebElement getTyAmount() {
		return tyAmount;
	}

	public WebElement getTyCardNumber() {
		return tyCardNumber;
	}

	public WebElement getTyName() {
		return tyName;
	}

	public WebElement getTyDate() {
		return tyDate;
	}

	public WebElement getTyOk() {
		return tyOk;
	}

	public WebElement getPlaceOrderFormHeading() {
		return placeOrderFormHeading;
	}
	public WebElement getThankYouPurchase() {
		return thankYouPurchase;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getCreditCard() {
		return creditCard;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getPurchase() {
		return purchase;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}
	
	public void placeOrderFormFill() {
		name.sendKeys(Constants.PLACEORDERFORMNAME);
		country.sendKeys(Constants.COUNTRY);
		city.sendKeys(Constants.CITY);
		creditCard.sendKeys(Constants.CREDITCARD);
		month.sendKeys(Constants.MONTH);
		year.sendKeys(Constants.YEAR);
		purchase.click();
	}
	
	public void clickTyOk() {
		tyOk.click();
	}
	public void clickPurchase() {
		purchase.click();
	}
	public void enterName(String purchasename) {
		name.sendKeys(purchasename);
	}
	public void enterCreditCard(String purchasecard) {
		creditCard.sendKeys(purchasecard);
	}
	public void clearName() {
		name.clear();
	}
	public void clearCreditCard() {
		creditCard.clear();
	}
	public void clickCloseButton() {
		closeButton.click();
	}
	public void clickCloseIcon() {
		closeIcon.click();
	}
	
	
	
}
