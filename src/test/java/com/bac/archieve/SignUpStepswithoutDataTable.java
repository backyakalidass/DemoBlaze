package com.bac.archieve;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bac.constants.Constants;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.pageObjectOR.SignupPageOR;
import com.bac.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepswithoutDataTable {
	private static final Logger LOGGER = LogManager.getLogger(SignUpStepswithoutDataTable.class);
	
	@Given("user is entering DemoBlaze url")
	public void user_is_entering_demo_blaze_url() {
		LOGGER.info("Launching DemoBlaze URL");
	   DriverManager.getDriver().get(Constants.APP_URL);
	}
	@Given("user clicks on SignUp button")
	public void user_clicks_on_sign_up_button() throws InterruptedException {
		//HomePageOR.signUpLink.click();
		LOGGER.info("user clicks on SignUp Link");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	}
	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		LOGGER.info("User enters username");
		//SignupPageOR.username.sendKeys("testBackya");
		LOGGER.info("User enters password");
		//SignupPageOR.password.sendKeys("test@1234");
	    
	}
	@When("user clicks on signup button")
	public void user_clicks_on_signup_button() {
		LOGGER.info("User clicks on signup button");
		//SignupPageOR.signUp.click();
	}
	@Then("signup successful alert displayed")
	public void signup_successful_alert_displayed() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		if(wait.until(ExpectedConditions.alertIsPresent())==null) {
			LOGGER.info("Sign Up Success Alert not Present");
		}else {
			LOGGER.info("Sign Up Success Alert is Present");
	
		Alert alert = DriverManager.getDriver().switchTo().alert();
	
		String actual = alert.getText();
		String expected = "Please enter a valid user name";
		LOGGER.info("Alert Text Message Validation started");
		//Validate the alert
		if(expected.equals(actual)) {
			LOGGER.info("Alert Text Validated successfully "+actual);
			System.out.println("Alert Text Validated successfully. Alert message displayed is :");
			System.out.println(actual);
		}else {
			LOGGER.info("Alert Text Validated Failed "+actual);
			System.out.println("Alert Text Validation Failed. Alert message displayed is :");
			System.out.println(actual);
	    }
		
		
		}
	}
	@Then("user clicks on Ok button")
	public void user_clicks_on_ok_button() {

		//Alert alert = DriverManager.getDriver().switchTo().alert();
		//close or accept the Alert
		LOGGER.info("Accepting the Alert by clicking on Ok button");
		//alert.accept();
	}
}
