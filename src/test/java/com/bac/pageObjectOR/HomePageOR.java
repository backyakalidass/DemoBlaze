package com.bac.pageObjectOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageOR {
	
	private static HomePageOR homePageInstance;
	
	private HomePageOR() {
		
	}
	
	public static HomePageOR getInstance() {
		if(homePageInstance==null) {
			homePageInstance = new HomePageOR();
		}
		return homePageInstance;
	}

	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement homeLink;
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	private WebElement contactLink;
	@FindBy(xpath="//a[contains(text(),'About')]")
	private WebElement aboutUsLink;
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	private WebElement cartLink;
	@FindBy(xpath="//a[contains(text(),'Log in')]")
	private WebElement loginLink;
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	private WebElement signUpLink;
	@FindBy(xpath="//a[@id='nava']")
	private WebElement productStoreLink;
	@FindBy(xpath="//a[@id='nameofuser']")
	private WebElement welcomeLink;
	@FindBy(xpath="//a[@id='logout2']")
	public WebElement logOut;
	public static By previousLoc = By.xpath("//button[@id='prev2']");
	public static By nextLoc = By.xpath("//button[@id='next2']");
	@FindBy(xpath="//button[@id='prev2']")
	public WebElement previousButton;
	@FindBy(xpath="//button[@id='next2']")
	public WebElement nextButton;
	@FindBy(xpath="//a[contains(text(),'Apple monitor 24')]")
	private static WebElement secondPageFirstProduct;
	
	
	
//	public static By getPreviousLoc() {
//		return previousLoc;
//	}
//
//	public static By getNextLoc() {
//		return nextLoc;
//	}
	public WebElement getSecondPageFirstProduct() {
		return secondPageFirstProduct;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}
	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getSignUpLink() {
		return signUpLink;
	}

	public WebElement getWelcomeLink() {
		return welcomeLink;
	}
	
	public void clicklogOut() {
		logOut.click();
	}

	public void clickHomeLink() {
		homeLink.click();
	}
	public void clickContactLink() {
		contactLink.click();
	}
	public void clickAboutUsLink() {
		aboutUsLink.click();
	}
	public void clickcartLink() {
		cartLink.click();
	}
	public void clickloginLink() {
		loginLink.click();
	}
	public void clicksignUpLink() {
		signUpLink.click();
	}
	public void clickproductStoreLink() {
		productStoreLink.click();
	}
	
	public void clickPrevious() {
		previousButton.submit();
	}
	public void clickNext() {
		nextButton.click();
	}
	
}
