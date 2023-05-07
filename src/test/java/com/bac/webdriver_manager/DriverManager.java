package com.bac.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bac.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
private static WebDriver driver = null;

public static WebDriver getDriver() {
	return driver;
}

	//launch Browser
	public static void launchBrowser() {
		try {
			switch (Constants.BROWSER.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching: "+Constants.BROWSER);
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching: "+Constants.BROWSER);
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Launching: "+Constants.BROWSER);
				driver = new FirefoxDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching: "+Constants.BROWSER);
				driver = new ChromeDriver();
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

}
}
