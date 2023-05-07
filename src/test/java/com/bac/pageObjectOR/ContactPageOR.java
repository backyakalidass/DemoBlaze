package com.bac.pageObjectOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageOR {

	private static ContactPageOR contactPageInstance;
	
	private ContactPageOR() {
		
	}
	
	public static ContactPageOR getInstance() {
		if(contactPageInstance==null) {
			contactPageInstance = new ContactPageOR();
		}
		
		return contactPageInstance;
	}
	
	@FindBy(xpath="//input[@id='recipient-email']")
	private WebElement contactEmail;
	@FindBy(xpath="//input[@id='recipient-name']")
	private WebElement contactName;
	@FindBy(xpath="//textarea[@id='message-text']")
	private WebElement message;
	@FindBy(xpath="//button[contains(text(),'Send message')]")
	private WebElement sendMessage;
	@FindBy(xpath="//button[contains(text(),'Send message')]//preceding::button[1]")
	private WebElement close;
	
	
	
	public WebElement getClose() {
		return close;
	}

	public void enterContactEmail(String conEmail) {
		contactEmail.sendKeys(conEmail);
	}
	public void enterContactName(String conName) {
		contactName.sendKeys(conName);
	}
	public void enterContactMessage(String conMessage) {
		message.sendKeys(conMessage);
	}
	public void clickSendMessage() {
		sendMessage.click();
	}
	public void clickClose() {
		close.click();
	}
}
