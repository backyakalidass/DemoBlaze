package com.bac.pageObjectOR;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bac.webdriver_manager.DriverManager;

public class ProductsOR2 {
	
private static ProductsOR2 productInstance;
private static final Logger LOGGER = LogManager.getLogger(ProductsOR2.class);
	
	private ProductsOR2() {
		
	}
	
	public static ProductsOR2 getInstance() {
		if(productInstance==null) {
			productInstance = new ProductsOR2();
		}
		
		return productInstance;
	}
	
public By categoryPhones = By.xpath("//a[contains(text(),'Phones')]");
public By categoryLaptos = By.xpath("//a[contains(text(),'Laptops')]");
public By categoryMonitors = By.xpath("//a[contains(text(),'Monitors')]");
public By firstLaptopProduct = By.xpath("//a[contains(text(),'Sony vaio i5')]");

//public By firstProduct = By.xpath("(//h4[@class='card-title']/a)[1]");
public By firstProduct = By.xpath("//a[contains(text(),'Nokia lumia 1520')]");
public By productDescription = By.xpath("//div[@id='more-information']/strong");
public By productImage = By.xpath("//div[@class='item active']/img");
public By productName = By.xpath("//h2[@class='name']");
public By productPrice = By.xpath("//h3[@class='price-container']");

public void clickCategoryLaptops() {
	DriverManager.getDriver().findElement(categoryLaptos).click();
	
}

public WebElement getfirstLaptopElement() {
	WebElement firstLaptopElement = DriverManager.getDriver().findElement(firstLaptopProduct);
	return firstLaptopElement;
}

public void clickFirstProduct() {
	DriverManager.getDriver().findElement(firstLaptopProduct).click();
}

}
