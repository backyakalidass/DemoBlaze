package com.bac.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bac.constants.Constants;
import com.bac.pageObjectOR.AboutUsPageOR;
import com.bac.pageObjectOR.CartPageOR;
import com.bac.pageObjectOR.ContactPageOR;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.pageObjectOR.LoginPageOR;
import com.bac.pageObjectOR.PlaceOrderOR;
import com.bac.pageObjectOR.ProductsOR;
import com.bac.pageObjectOR.SignupPageOR;
import com.bac.stepDefinition.CommonStepDefinition;
import com.bac.webdriver_manager.DriverManager;

public class CommonUtils {

	private static final Logger LOGGER = LogManager.getLogger(CommonUtils.class);

	private static CommonUtils commonUtilsInstance;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (commonUtilsInstance == null) {
			commonUtilsInstance = new CommonUtils();
		}
		return commonUtilsInstance;
	}

	public void loadProperties() {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.UserName = properties.getProperty("UserName");
		Constants.Password = properties.getProperty("Password");
		Constants.PLACEORDERFORMNAME = properties.getProperty("PLACEORDERFORMNAME");
		Constants.COUNTRY = properties.getProperty("COUNTRY");
		Constants.CITY = properties.getProperty("CITY");
		Constants.CREDITCARD = properties.getProperty("CREDITCARD");
		Constants.MONTH = properties.getProperty("MONTH");
		Constants.YEAR = properties.getProperty("YEAR");

	}

	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), HomePageOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SignupPageOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), LoginPageOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), ContactPageOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), CartPageOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), AboutUsPageOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), ProductsOR.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), PlaceOrderOR.getInstance());
	}

	public void takeScreenshot() {

		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		// Copy the file to a location and using try catch block to handle exception
		try {
			File destination = new File("C:\\Users\\backy\\eclipse-workspace\\DemoBlaze\\"+CommonStepDefinition.getScenarioName()+".png");
			FileUtils.copyFile(screenshot, destination);
		} catch (IOException e) {
			LOGGER.error(e);

		}

	}

	public void takeScreenshot_withRobotClass() {

	}

	public void alertMsgValidation(String expected) {

		Alert alert = DriverManager.getDriver().switchTo().alert();

		String actual = alert.getText();
		LOGGER.info("Alert Text Message Validation started");
		// Validate the alert
		if (expected.equals(actual)) {
			LOGGER.info("Alert Text Validated successfully " + actual);
		} else {
			LOGGER.info("Alert Text Validated Failed " + actual);
		}
	}

	public void welcomeLinkTextValidation(String username) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String actual = HomePageOR.getInstance().getWelcomeLink().getText();
		String expected = "Welcome " + username;
		if (actual.equalsIgnoreCase(expected)) {
			LOGGER.info("Welcome Link Text Validation Successful. Actual Link Text : " + actual + "  Expected: "
					+ expected);
		} else {
			LOGGER.info("Welcome Link Text Validation unsuccessful. Actual Link Text : " + actual + "  Expected: "
					+ expected);
		}
	}
	
	public void explicitWaitVisibilityofElement(WebElement element,long time) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitVisibilityofElementByLocator(By locator,long time) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
