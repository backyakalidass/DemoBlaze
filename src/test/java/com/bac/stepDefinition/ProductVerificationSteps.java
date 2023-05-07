package com.bac.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.bac.pageObjectOR.CartPageOR;
import com.bac.pageObjectOR.ProductsOR;

import com.bac.webdriver_manager.DriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductVerificationSteps {
	private static final Logger LOGGER = LogManager.getLogger(ProductVerificationSteps.class);
	
	@When("user clicks on Laptop Product category")
	public void user_clicks_on_laptop_product_category() {
		try {
			DriverManager.getDriver().navigate().refresh();
			ProductsOR.getInstance().clickCategoryLaptops();
			LOGGER.info("Laptops category option is clicked");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Laptop products should be displayed")
	public void laptop_products_should_be_displayed() {
		try {
			Assert.assertTrue(ProductsOR.getInstance().getFirstLaptopProduct().isDisplayed());
			LOGGER.info("First Laptop Product is displayed");
			// ProductsOR.getInstance().getFirstLaptopProduct().click();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on a product from the products list")
	public void user_clicks_on_a_product_from_the_products_list() {
		try {
			DriverManager.getDriver().navigate().refresh();
			ProductsOR.getInstance().clickFirstLaptopProduct();
			LOGGER.info("First Product is clicked");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Product description page should be loaded")
	public void product_description_page_should_be_loaded() {
		try {
			DriverManager.getDriver().navigate().refresh();
			Assert.assertTrue(ProductsOR.getInstance().getProductDescription().isDisplayed());
			LOGGER.info("Product Description is displayed");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Product image should be displayed")
	public void product_image_should_be_displayed() {
		try {
			// DriverManager.getDriver().navigate().refresh();
			Assert.assertTrue(ProductsOR.getInstance().getProductImage().isDisplayed());
			LOGGER.info("Product Image is displayed");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Product name should be displayed")
	public void product_name_should_be_displayed() {
		try {
			// DriverManager.getDriver().navigate().refresh();
			Assert.assertTrue(ProductsOR.getInstance().getProductName().isDisplayed());
			LOGGER.info("Product name is displayed");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Product price should be displayed")
	public void product_price_should_be_displayed() {
		try {
			// DriverManager.getDriver().navigate().refresh();
			Assert.assertTrue(ProductsOR.getInstance().getProductPrice().isDisplayed());
			LOGGER.info("Product price is displayed");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Add to cart button should be displayed")
	public void add_to_cart_button_should_be_displayed() {
		try {
			// DriverManager.getDriver().navigate().refresh();
			Assert.assertTrue(CartPageOR.getInstance().getAddToCart().isDisplayed());
			LOGGER.info("Add to Cart button is displayed");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on Monitors Product category")
	public void user_clicks_on_monitors_product_category() {
		try {
			DriverManager.getDriver().navigate().refresh();
			ProductsOR.getInstance().clickCategoryMonitors();
			LOGGER.info("Monitors category option is clicked");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Monitor products should be displayed")
	public void monitor_products_should_be_displayed() {
		try {
			Assert.assertTrue(ProductsOR.getInstance().getFirstMonitorProduct().isDisplayed());
			LOGGER.info("First Monitor Product is displayed");
			// ProductsOR.getInstance().getFirstMonitorProduct().click();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@When("user clicks on Phones Product category")
	public void user_clicks_on_phones_product_category() {
		try {
			DriverManager.getDriver().navigate().refresh();
			ProductsOR.getInstance().clickCategoryPhones();
			LOGGER.info("Phones category option is clicked");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	@Then("Phone products should be displayed")
	public void phone_products_should_be_displayed() {
		try {
			Assert.assertTrue(ProductsOR.getInstance().getFirstPhoneProduct().isDisplayed());
			LOGGER.info("First Phone Product is displayed");
			ProductsOR.getInstance().getFirstPhoneProduct().click();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

}
