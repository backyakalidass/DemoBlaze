package com.bac.pageObjectOR;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;

public class LoginPageOR {

	
    private static final Logger LOGGER = LogManager.getLogger(LoginPageOR.class);
	private static LoginPageOR loginPageInstance;

	private LoginPageOR() {

	}

	public static LoginPageOR getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new LoginPageOR();
		}

		return loginPageInstance;
	}

	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement password;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement login;
	@FindBy(xpath = "//button[contains(text(),'Log in')]//preceding::button[1]")
	private WebElement close;
	@FindBy(xpath="//button[contains(text(),'Log in')]//preceding::span[1]")
	private WebElement closeIcon;
	
	

	public WebElement getLogin() {
		return login;
	}
	
	public WebElement getClose() {
		return close;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		login.click();
	}

	public void clickClose() {
		close.click();
	}
	public void clickCloseIcon() {
		closeIcon.click();
	}
	
	public void login(String uname,String pwd) {
		HomePageOR.getInstance().clickloginLink();
		LOGGER.info("User clicks on Login Link in Home Page");
		CommonUtils.getInstance().explicitWaitVisibilityofElement(username, 20);
		username.sendKeys(uname);
		LOGGER.info("User enters username");
		password.sendKeys(pwd);
		LOGGER.info("User enters password");
		CommonUtils.getInstance().explicitWaitVisibilityofElement(login, 20);
		login.click();
		LOGGER.info("User clicks on Login button in Login Page");
		//PageFactory.initElements(DriverManager.getDriver(), HomePageOR.getInstance());
	}

}
