package com.bac.stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.pageObjectOR.LoginPageOR;
import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeAfterLoginSteps {
	private static final Logger LOGGER = LogManager.getLogger(HomeAfterLoginSteps.class);

	@Given("user successfully logeed in with valid {string} and {string}")
	public void user_successfully_logeed_in_with_valid_and(String username, String password) {
		try {
			LoginPageOR.getInstance().login(username, password);
			LOGGER.info("user successfully logged in");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@When("verify categories list options")
	public void verify_categories_list_options() {
		try {

			List<WebElement> options = DriverManager.getDriver().findElements(By.xpath("//a[@id='itemc']"));
			int optionsCount = options.size();
			System.out.println("No of Category Options: " + optionsCount);
			LOGGER.info("No of Category Options: " + optionsCount);
			LOGGER.info("Category Options");
			int passCount = 0;
			for (WebElement element : options) {
				if (element.getText().equalsIgnoreCase("Phones")) {
					passCount++;
					LOGGER.info(element.getText());
				} else if (element.getText().equalsIgnoreCase("Laptops")) {
					passCount++;
					LOGGER.info(element.getText());
				} else if (element.getText().equalsIgnoreCase("Monitors")) {
					passCount++;
					LOGGER.info(element.getText());
				} else {
					passCount--;
					LOGGER.info("Incorrect category option displayed " + element.getText());
				}
			}
			if (passCount == 3) {
				LOGGER.info("Category options verification successful ");
			} else {
				LOGGER.info("Category options verification unsuccessful ");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify previous and next buttons available")
	public void verify_previous_and_next_buttons_available() {
		try {
			WebElement nextButton = DriverManager.getDriver().findElement(HomePageOR.nextLoc);
			WebElement previousButton = DriverManager.getDriver().findElement(HomePageOR.previousLoc);
			if (nextButton.isDisplayed()) {
				LOGGER.info("Next button is displayed");
			}
			if (previousButton.isDisplayed()) {
				LOGGER.info("Previous button is displayed");
			}

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@When("verify number of product display in first page")
	public void verify_number_of_product_display_in_first_page() {
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> element = DriverManager.getDriver()
					.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
			int noOfElementsDisplayed = element.size();
			LOGGER.info("Number of elements displayed on home page: " + noOfElementsDisplayed);
			if (noOfElementsDisplayed == 9) {
				LOGGER.info("Verification of number of products displayed in first page is success");
			} else {
				LOGGER.info("Verification of number of products displayed in first page is unsuccessful");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("click on next button")
	public void click_on_next_button() {
		try {
			// PageFactory.initElements(DriverManager.getDriver(),
			// HomePageOR.getInstance());
			DriverManager.getDriver().navigate().refresh();
			WebElement nextButton = DriverManager.getDriver().findElement(HomePageOR.nextLoc);
			Actions actions = new Actions(DriverManager.getDriver());
			actions.moveToElement(nextButton).click(nextButton);
			actions.build().perform();
			HomePageOR.getInstance().clickNext();
			LOGGER.info("user clicks on next button");
			// DriverManager.getDriver().manage().timeouts().implicitlyWait(40,
			// TimeUnit.SECONDS);

		} catch (StaleElementReferenceException e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
//			WebElement nextButton = DriverManager.getDriver().findElement(HomePageOR.nextLoc);
//			JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
//	         executor.executeScript("arguments[0].click();", nextButton);
//	    	Actions actions = new Actions(DriverManager.getDriver());
//   	    actions.moveToElement(nextButton).click(nextButton);
//	    	actions.build().perform();
//	    	HomePageOR.getInstance().clickNext();
//	    	LOGGER.info("user clicks on next button with Stale Element exception handling");
//	    	DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	@Then("verify number of products in second page")
	public void verify_number_of_products_in_second_page() {
		try {
			// DriverManager.getDriver().navigate().refresh();
			// DriverManager.getDriver().manage().timeouts().implicitlyWait(30,
			// TimeUnit.SECONDS);
			CommonUtils.getInstance()
					.explicitWaitVisibilityofElement(HomePageOR.getInstance().getSecondPageFirstProduct(), 30);
			List<WebElement> secondpagelist = DriverManager.getDriver()
					.findElements(By.xpath("//div[@class='card-block']"));
			int noOfElementssecondpage = secondpagelist.size();
			LOGGER.info("Number of elements displayed on second page: " + noOfElementssecondpage);
			if (noOfElementssecondpage == 6) {
				LOGGER.info("Verification of number of products displayed in second page is success");
			} else {
				LOGGER.info("Verification of number of products displayed in second page is unsuccessful");
			}

		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("click on previous button")
	public void click_on_previous_button() {
		try {
			// PageFactory.initElements(DriverManager.getDriver(),
			// HomePageOR.getInstance());
			WebElement previousButton = DriverManager.getDriver().findElement(HomePageOR.previousLoc);
			Actions actions = new Actions(DriverManager.getDriver());
			actions.moveToElement(previousButton).click(previousButton);
			actions.build().perform();
			HomePageOR.getInstance().clickPrevious();
			LOGGER.info("user clicks on previous button");
			// PageFactory.initElements(DriverManager.getDriver(),
			// HomePageOR.getInstance());
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (StaleElementReferenceException e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
//			WebElement previousButton = DriverManager.getDriver().findElement(HomePageOR.previousLoc);
//	    	Actions actions = new Actions(DriverManager.getDriver());
//	    	actions.moveToElement(previousButton).click(previousButton);
//	    	actions.build().perform();
//	    	HomePageOR.getInstance().clickPrevious();
//	    	LOGGER.info("user clicks on previous button with Stale element reference exception handling block");
		}
	}

}
