package com.bac.pageObjectOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPageOR {
	
	private static SignupPageOR signupPageInstance;

	private SignupPageOR() {

	}
	
	public static SignupPageOR getInstance() {
		if(signupPageInstance==null) {
			signupPageInstance = new SignupPageOR();
		}
		return signupPageInstance;
	}

	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement password;
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	private WebElement signUp;
	@FindBy(xpath = "//button[contains(text(),'Sign up')]//preceding::button[1]")
	private WebElement close;
	@FindBy(xpath = "//input[@id='sign-username']//preceding::span[1]")
	private WebElement closeIcon;
	
	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getClose() {
		return close;
	}

	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickSignUp() {
		signUp.click();
	}

	public void clickClose() {
		close.click();
	}
	public void clickCloseIcon() {
		closeIcon.click();
	}

}
