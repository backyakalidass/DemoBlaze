package com.bac.pageObjectOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPageOR {
	
	private static AboutUsPageOR aboutusPageInstance;
	
	private AboutUsPageOR() {
		
	}
	
	public static AboutUsPageOR getInstance() {
		if(aboutusPageInstance==null) {
			aboutusPageInstance = new AboutUsPageOR();
		}
		return aboutusPageInstance;
	}

	@FindBy(xpath="//button[@title='Play Video']")
	private WebElement playVideoIcon;
	@FindBy(xpath="//h5[contains(text(),'About us')]//following::button[16]")
	private WebElement close;
	@FindBy(xpath="//button[@title='Play']")
	private WebElement play;
	@FindBy(xpath="//button[@title='Pause']")
	private WebElement pause;
	@FindBy(xpath="//button[@title='Mute']")
	private WebElement mute;
	@FindBy(xpath="//button[@title='Unmute']")
	private WebElement unmute;
	@FindBy(xpath="//button[@title='Picture-in-Picture']")
	private WebElement pictureinPicture;
	@FindBy(xpath="//button[@title='Exit Picture-in-Picture']")
	private WebElement unPictureinPicture;
	@FindBy(xpath="//button[@title='Fullscreen']")
	private WebElement fullScreen;
	@FindBy(xpath="//button[@title='Non-Fullscreen']")
	private WebElement nonFullScreen;
	
	
	
	public WebElement getFullScreen() {
		return fullScreen;
	}

	public WebElement getNonFullScreen() {
		return nonFullScreen;
	}

	public WebElement getPlay() {
		return play;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getPause() {
		return pause;
	}

	public WebElement getPlayVideoIcon() {
		return playVideoIcon;
	}

	public void clickPlayVideoIcon() {
		playVideoIcon.click();
	}
	public void clickClose() {
		close.click();
	}
	public void clickPlay() {
		play.click();
	}
	public void clickPause() {
		pause.click();
	}
	public void clickMute() {
		mute.click();
	}
	public void clickUnMute() {
		unmute.click();
	}
	public void clickPictureinPicture() {
		pictureinPicture.click();
	}
	public void clickUnPictureinPicture() {
		unPictureinPicture.click();
	}
	public void clickFullScreen() {
		fullScreen.click();
	}
	public void clickNonFullScreen() {
		nonFullScreen.click();
	}
	
	
	
	
}
