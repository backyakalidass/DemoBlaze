package com.bac.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bac.constants.Constants;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.pageObjectOR.SignupPageOR;
import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps {
	private static final Logger LOGGER = LogManager.getLogger(SignUpSteps.class);

	@Given("user is entering DemoBlaze url")
	public void user_is_entering_demo_blaze_url() {
		try {
			LOGGER.info("Launching DemoBlaze URL");
			DriverManager.getDriver().get(Constants.APP_URL);
			DriverManager.getDriver().manage().window().maximize();
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Given("user clicks on SignUp button")
	public void user_clicks_on_sign_up_button() throws InterruptedException {
		try {
			HomePageOR.getInstance().clicksignUpLink();
			LOGGER.info("user clicks on SignUp Link");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		try {
			LOGGER.info("User enters username: " + username);
			SignupPageOR.getInstance().enterUsername(username);
			LOGGER.info("User enters password: " + password);
			SignupPageOR.getInstance().enterPassword(password);
			CommonUtils.getInstance().takeScreenshot();
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}

	}

	@When("user enters existing {string} and {string}")
	public void user_enters_existing_and(String username, String password) {
		try {
			LOGGER.info("User enters existing username: " + username);
			SignupPageOR.getInstance().enterUsername(username);
			LOGGER.info("User enters existing password: " + password);
			SignupPageOR.getInstance().enterPassword(password);
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on signup button")
	public void user_clicks_on_signup_button() {
		try {
		LOGGER.info("User clicks on signup button");
		SignupPageOR.getInstance().clickSignUp();
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("user clicks on Ok button in alert")
	public void user_clicks_on_ok_button_in_alert() {
		try {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		// close or accept the Alert
		LOGGER.info("Accepting the Alert by clicking on Ok button");
		alert.accept();
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters only username {string}")
	public void user_enters_only_username(String username) {
		try {
		LOGGER.info("User enters username: " + username);
		SignupPageOR.getInstance().enterUsername(username);
		}catch (Exception e) {
		  LOGGER.error(e);
		  CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters only password {string}")
	public void user_enters_only_password(String password) {
		try {
		LOGGER.info("User enters password: " + password);
		SignupPageOR.getInstance().enterPassword(password);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("{string} alert displayed")
	public void alert_displayed(String expectedalert) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		try {
		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			LOGGER.info("Alert not Present");
		} else {
			LOGGER.info("Alert is Present");
			CommonUtils.getInstance().alertMsgValidation(expectedalert);
		}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Close button in SignUp")
	public void user_clicks_on_close_button_in_sign_up() {
		try {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(SignupPageOR.getInstance().getClose()).click(SignupPageOR.getInstance().getClose());
		actions.perform();
		LOGGER.info("user clicks on Close button in signup Page");
		SignupPageOR.getInstance().clickClose();
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Close Icon x in Signup")
	public void user_clicks_on_close_icon_x_in_signup() {
		try {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(SignupPageOR.getInstance().getCloseIcon()));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(SignupPageOR.getInstance().getCloseIcon())
				.click(SignupPageOR.getInstance().getCloseIcon());
		actions.perform();
		LOGGER.info("user clicks on Close icon in signup Page");
		//SignupPageOR.getInstance().clickCloseIcon();
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify close action in Signup")
	public void verify_close_action_in_signup() {
		try {
		LOGGER.info("Verifying close action");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if ((HomePageOR.getInstance().getHomeLink().isDisplayed()) == true) {
			LOGGER.info("Signup Page closed successfully");
		} else {
			LOGGER.info("Signup Page Close Unsuccessful");

		}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

}
