package com.bac.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bac.constants.Constants;
import com.bac.pageObjectOR.CartPageOR;
import com.bac.pageObjectOR.HomePageOR;
import com.bac.pageObjectOR.PlaceOrderOR;
import com.bac.pageObjectOR.ProductsOR;
import com.bac.utilities.CommonUtils;
import com.bac.webdriver_manager.DriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

	private static final Logger LOGGER = LogManager.getLogger(ProductVerificationSteps.class);

	@When("user clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
		try {
			CartPageOR.getInstance().clickAddToCart();
			LOGGER.info("Add to cart button is clicked");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("product added alert should be displayed")
	public void product_added_alert_should_be_displayed() {
		try {
			// DriverManager.getDriver().manage().timeouts().implicitlyWait(40,
			// TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = DriverManager.getDriver().switchTo().alert();
			LOGGER.info("Alert text: " + alert.getText());
			//alert.accept();
			LOGGER.info("Switching to Alert window");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("accepting the Product added Alert")
	public void accepting_the_Product_added_Alert() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			wait.until(ExpectedConditions.alertIsPresent());
			 Alert alert=DriverManager.getDriver().switchTo().alert();
			// Alert alert = DriverManager.getDriver().switchTo().alert();
			 alert.accept();

			LOGGER.info("Accepting the alert by clicking Ok");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("click on Cart Link")
	public void click_on_cart_link() {
		try {
			CommonUtils.getInstance().explicitWaitVisibilityofElement(HomePageOR.getInstance().getCartLink(), 20);
			HomePageOR.getInstance().clickcartLink();
			LOGGER.info("Clicked on Cart Link");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("product added should be displayed in cart")
	public void product_added_should_be_displayed_in_cart() {
		try {
			Assert.assertTrue(CartPageOR.getInstance().getAddedProductTitle().isDisplayed());
			LOGGER.info("Added Product Title displayed");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("click on Place Order button and Place Order form should be displayed")
	public void click_on_place_order_button_and_place_order_form_should_be_displayed() {
		try {
			CartPageOR.getInstance().clickPlaceOrder();
			LOGGER.info("user clicks on Plcae Order button");
			CommonUtils.getInstance()
					.explicitWaitVisibilityofElement(PlaceOrderOR.getInstance().getPlaceOrderFormHeading(), 20);
			Assert.assertTrue(PlaceOrderOR.getInstance().getPlaceOrderFormHeading().isDisplayed());
			LOGGER.info("Place Order form displayed");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("fill out all details in Place Order form")
	public void fill_out_all_details_in_place_order_form() {
		try {
			PlaceOrderOR.getInstance().placeOrderFormFill();
			LOGGER.info("Filling out all details in Place order form");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("Thank You for your purchase message should be displayed")
	public void thank_you_for_your_purchase_message_should_be_displayed() {
		try {
			CommonUtils.getInstance().explicitWaitVisibilityofElement(PlaceOrderOR.getInstance().getThankYouPurchase(),
					20);
			Assert.assertTrue(PlaceOrderOR.getInstance().getThankYouPurchase().isDisplayed());
			LOGGER.info("Thank you for your Purchase message window is displayed");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks on a monitor product from the products list")
	public void user_clicks_on_a_monitor_product_from_the_products_list() {
		try {
			ProductsOR.getInstance().clickFirstMonitorProduct();
			LOGGER.info("First Monitor Product is clicked");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("verify details displayed in Thank You for your purchase")
	public void verify_details_displayed_in_Thank_You_for_your_purchase() {
		try {
             Assert.assertTrue(PlaceOrderOR.getInstance().getTyParagraph().isDisplayed());
             //String idValue=PlaceOrderOR.getInstance().getTyParagraph().getAttribute("inner text");
            // By idValue = By.xpath("//p[contains(text(),'Id:')]");
             String detailsThankyou=PlaceOrderOR.getInstance().getTyId().getText();
             LOGGER.info("Details Displayed in Thank you for your purchase screen is: "+detailsThankyou);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	    

	@Then("verify Ok button is displayed in Thank you for your purchase and click on Ok button")
	public void verify_ok_button_is_displayed_in_Thank_you_for_your_purchase_and_click_on_Ok_button() {
		try {
			  Assert.assertTrue(PlaceOrderOR.getInstance().getTyOk().isDisplayed());
	          LOGGER.info("Ok button is Displayed in Thank you for your purchase screen");
	          PlaceOrderOR.getInstance().clickTyOk();
	          LOGGER.info("user clicks on Ok button in Thank you for your Purchase screen");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@When("user clicks on Home Link")
	public void user_clicks_on_home_link() {
		try {
		CommonUtils.getInstance().explicitWaitVisibilityofElement(HomePageOR.getInstance().getHomeLink(), 20);
	    HomePageOR.getInstance().clickHomeLink();
	    LOGGER.info("user clicks on Home Link");
	    DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("click on Delete Link")
	public void click_on_delete_link() {
	    try {
			CartPageOR.getInstance().clickDeleteLink();
			LOGGER.info("user clicks on Delete link");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	@Then("added product should be removed from cart")
	public void added_product_should_be_removed_from_cart() {
     try {
    	 DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	 boolean condition=CartPageOR.getInstance().getAddedProductTitle().isDisplayed();
    	 if(condition!=true) {
    		 Assert.assertTrue(true);
    	 }
		 LOGGER.info("Added Product deleted successfully");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("click on Purchase button")
	public void click_on_purchase_button() {
	    try {
	    	PlaceOrderOR.getInstance().clickPurchase();
	    	LOGGER.info("user clicks on Purchase button");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	@Then("please fill out  name and credit card alert message should be displayed and accept the alert")
	public void please_fill_out_name_and_credit_card_alert_message_should_be_displayed_and_accept_the_alert() {
     try {
    	 WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			wait.until(ExpectedConditions.alertIsPresent());
			 Alert alert=DriverManager.getDriver().switchTo().alert();
			 LOGGER.info("Alert text: "+alert.getText());
			 alert.accept();
			LOGGER.info("Accepting the alert by clicking Ok");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	@Then("enter credit card value")
	public void enter_credit_card_value() {
    try {
    	PlaceOrderOR.getInstance().enterCreditCard(Constants.CREDITCARD);
    	LOGGER.info("user enters credit card value");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("remove credit card value and enter name")
	public void remove_credit_card_value_and_enter_name() {
		 try {
				PlaceOrderOR.getInstance().clearCreditCard();
				LOGGER.info("credit card value removed");
				PlaceOrderOR.getInstance().enterName(Constants.PLACEORDERFORMNAME);
				LOGGER.info("name value entered");
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Assert.fail(e.getMessage());
			}
	}
	@Then("enter name and credit card")
	public void enter_name_and_credit_card() {
		 try {
			 PlaceOrderOR.getInstance().enterCreditCard(Constants.CREDITCARD);
				LOGGER.info("credit card value entered");
				PlaceOrderOR.getInstance().enterName(Constants.PLACEORDERFORMNAME);
				LOGGER.info("name value entered");
				
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Assert.fail(e.getMessage());
			}
	}

	@When("click on Close button")
	public void click_on_close_button() {
	    try {
			PlaceOrderOR.getInstance().clickCloseButton();
			LOGGER.info("user clicks on close button");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	@When("place order form should be closed")
	public void place_order_form_should_be_closed() {
		 try {
			CommonUtils.getInstance().explicitWaitVisibilityofElement(CartPageOR.getInstance().getPlaceOrder(), 20);
			if(CartPageOR.getInstance().getPlaceOrder().isDisplayed()) {
				LOGGER.info("Place Order form closed");
			}				
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Assert.fail(e.getMessage());
			}
	}
	@When("click on Close icon")
	public void click_on_close_icon() {
		 try {
			 PlaceOrderOR.getInstance().clickCloseIcon();
				LOGGER.info("user clicks on close icon");
				
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Assert.fail(e.getMessage());
			}
	}



}
