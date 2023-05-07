package com.bac.stepDefinition;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bac.constants.Constants;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.pageObjectOR.LoginPageOR;
import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInSteps {
	private static final Logger LOGGER = LogManager.getLogger(LogInSteps.class);

	@Given("user is entering DemoBlaze url for login")
	public void user_is_entering_demo_blaze_url() {
		try {
		LOGGER.info("Launching DemoBlaze URL");
		LOGGER.info("Current url: " + DriverManager.getDriver().getCurrentUrl());
		DriverManager.getDriver().get(Constants.APP_URL);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Given("user clicks on Login link")
	public void user_clicks_on_Login_link() {
		try {
		HomePageOR.getInstance().clickloginLink();
		LOGGER.info("user clicks on Login Link");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("user enters login {string} and {string}")
	public void user_enters_login_and(String username, String password) {
		try {
		LOGGER.info("user enters login username: " + username);
		LoginPageOR.getInstance().enterUsername(username);
		LOGGER.info("user enters login password: " + password);
		LoginPageOR.getInstance().enterPassword(password);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}

	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
        try {
		LOGGER.info("user clicks on Login button");
		LoginPageOR.getInstance().clickLogin();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify and validate Welcome link displayed with username {string}")
	public void verify_and_validate_welcome_link_displayed_with_username(String username) {
		try {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		if (wait.until(ExpectedConditions.visibilityOf(HomePageOR.getInstance().getWelcomeLink())) == null) {
			LOGGER.info("Welcome Link not Present");
		} else {
			LOGGER.info("Welcome Link is Present");
			CommonUtils.getInstance().welcomeLinkTextValidation(username);
		}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("user clicks on Logout and verify Logout")
	public void user_clicks_on_logout_and_verify_logout() {
		try {
		HomePageOR.getInstance().clicklogOut();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters login password {string}")
	public void user_enters_login_password(String password) {
		try {
		LoginPageOR.getInstance().enterPassword(password);
		LOGGER.info("User enters password: " + password);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters login username {string}")
	public void user_enters_login_username(String username) {
		try {
		LoginPageOR.getInstance().enterUsername(username);
		LOGGER.info("User enters username: " + username);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters valid username {string} and wrong password {string}")
	public void user_enters_valid_username_and_wrong_password(String username, String password) {
		try {
		LOGGER.info("User enters valid username: " + username);
		LoginPageOR.getInstance().enterUsername(username);
		LOGGER.info("User enters wrong password: " + password);
		LoginPageOR.getInstance().enterPassword(password);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user enters wrong username {string} and valid password {string}")
	public void user_enters_wrong_username_and_valid_password(String username, String password) {
		try {
		LOGGER.info("User enters wrong username: " + username);
		LoginPageOR.getInstance().enterUsername(username);
		LOGGER.info("User enters valid password: " + password);
		LoginPageOR.getInstance().enterPassword(password);
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Close button")
	public void user_clicks_on_close_button() {
		try {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(LoginPageOR.getInstance().getClose()).click(LoginPageOR.getInstance().getClose());
		actions.perform();
		LOGGER.info("user clicks on Close button in Login Page");
		LoginPageOR.getInstance().clickClose();
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Close Icon x")
	public void user_clicks_on_close_icon_x()  {
		try {
		//Thread.sleep(5000);
		//DriverManager.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(LoginPageOR.getInstance().getCloseIcon()));
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(LoginPageOR.getInstance().getCloseIcon()).click(LoginPageOR.getInstance().getCloseIcon());
		actions.perform();
		LOGGER.info("user clicks on Close Icon in Login Page");
		LoginPageOR.getInstance().clickCloseIcon();
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify close action")
	public void verify_close_action() {
		try {
		LOGGER.info("Verifying close action");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if ((HomePageOR.getInstance().getSignUpLink().isDisplayed()) == true) {
			LOGGER.info("Login Page closed successfully");
		} else {
			LOGGER.info("Login Page Close Unsuccessful");

		}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

}
