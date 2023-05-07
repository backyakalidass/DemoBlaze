package com.bac.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonStepDefinition {

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinition.class);

	private static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		scenarioName = scenario.getName();
		LOGGER.info("Instantiating Common Utils class");
		try {
			LOGGER.info("Loading the Properties");
			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Checking whether Driver is null or not");
			if (DriverManager.getDriver() == null) {
				LOGGER.info("Driver is null so Instantiating Driver");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().initWebElements();
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());

		}

	}

	@After
	public static void tearDown(Scenario scenario) {

		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
