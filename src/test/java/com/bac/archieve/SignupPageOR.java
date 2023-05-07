package com.bac.archieve;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPageOR {
    @FindBy(xpath="//input[@id='sign-username']")
	public static WebElement username;
    @FindBy(xpath="//input[@id='sign-password']")
	public static WebElement password;
    @FindBy(xpath="//button[contains(text(),'Sign up')]")
	public static WebElement signUp;
    @FindBy(xpath="//button[contains(text(),'Log in')]//preceding::button[4]")
	public static WebElement close;
    

	
}
