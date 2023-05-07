package com.bac.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bac.pageObjectOR.ContactPageOR;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSteps {
	private static final Logger LOGGER = LogManager.getLogger(ContactSteps.class);

	@Given("user clicks on contact link")
	public void user_clicks_on_contact_link() {
		try {
			HomePageOR.getInstance().clickContactLink();
			LOGGER.info("user clicks on contact link");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters contact email {string} and contact name {string} and message {string}")
	public void user_enters_contact_email_and_contact_name_and_message(String contactEmail, String contactName,
			String message) {
		try {
			ContactPageOR.getInstance().enterContactEmail(contactEmail);
			LOGGER.info("user enters contact email");
			ContactPageOR.getInstance().enterContactName(contactName);
			LOGGER.info("user enters contact name");
			ContactPageOR.getInstance().enterContactMessage(message);
			LOGGER.info("user enters contact message");

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Send message button")
	public void user_clicks_on_send_message_button() {
		try {
			ContactPageOR.getInstance().clickSendMessage();
			LOGGER.info("user clicks on Send Message button");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("{string} contact alert displayed")
	public void contact_alert_displayed(String expectedalert) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				LOGGER.info("Alert not Present");
			} else {
				LOGGER.info("Alert is Present");
				CommonUtils.getInstance().alertMsgValidation(expectedalert);
			}

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("user accepts the alert")
	public void user_accepts_the_alert() {
		try {
			Alert alert = DriverManager.getDriver().switchTo().alert();
			// close or accept the Alert
			LOGGER.info("Accepting the Alert by clicking on Ok button");
			alert.accept();

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}
	
	@When("user clicks on close button in contact page")
	public void user_clicks_on_close_button_in_contact_page() {
	   try {
		   CommonUtils.getInstance().explicitWaitVisibilityofElement(ContactPageOR.getInstance().getClose(), 20);
		   Actions actions = new Actions(DriverManager.getDriver());
			actions.moveToElement(ContactPageOR.getInstance().getClose()).click(ContactPageOR.getInstance().getClose());
			actions.perform();
			LOGGER.info("user clicks on Close button in signup Page");
			//ContactPageOR.getInstance().clickClose();
		   //LOGGER.info("user clicks on close button in contact page");
		
	} catch (Exception e) {
		LOGGER.error(e);
		Assert.fail(e.getMessage());
	}
	}
	@Then("verify contact page close")
	public void verify_contact_page_close() {
		try {
			if(HomePageOR.getInstance().getHomeLink().isDisplayed()) {
				LOGGER.info("Contact page close successful");
			}else {
				LOGGER.info("Contact page close unsuccessful");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}


}
