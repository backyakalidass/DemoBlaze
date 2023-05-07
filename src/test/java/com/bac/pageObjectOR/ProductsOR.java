package com.bac.pageObjectOR;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ProductsOR {
	
private static ProductsOR productInstance;
private static final Logger LOGGER = LogManager.getLogger(ProductsOR.class);
	
	private ProductsOR() {
		
	}
	
	public static ProductsOR getInstance() {
		if(productInstance==null) {
			productInstance = new ProductsOR();
		}
		
		return productInstance;
	}
	
	@FindBy(xpath="//a[contains(text(),'Phones')]")
	private WebElement catPhones;
	@FindBy(xpath="//a[contains(text(),'Laptops')]")
	private WebElement catLaptops;
	@FindBy(xpath="//a[contains(text(),'Monitors')]")
	private WebElement catMonitors;
	@FindBy(xpath="//a[contains(text(),'Sony vaio i5')]")
	private WebElement firstLaptopProduct;
	@FindBy(xpath="//a[contains(text(),'Apple monitor 24')]")
	private WebElement firstMonitorProduct;
	
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]")
	private WebElement firstPhoneProduct;
	@FindBy(xpath="//div[@id='more-information']/strong")
	private WebElement productDescription;
	@FindBy(xpath="//div[@class='item active']/img")
	private WebElement productImage;
	@FindBy(xpath="//h2[@class='name']")
	private WebElement productName;
	@FindBy(xpath="//h3[@class='price-container']")
	private WebElement productPrice;
	
	
	public WebElement getCatPhones() {
		return catPhones;
	}

	public WebElement getCatLaptops() {
		return catLaptops;
	}

	public WebElement getCatMonitors() {
		return catMonitors;
	}

	public WebElement getFirstLaptopProduct() {
		return firstLaptopProduct;
	}
	public WebElement getFirstMonitorProduct() {
		return firstMonitorProduct;
	}

	public WebElement getFirstPhoneProduct() {
		return firstPhoneProduct;
	}

	public WebElement getProductDescription() {
		return productDescription;
	}

	public WebElement getProductImage() {
		return productImage;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}
	
	

public void clickCategoryLaptops() {
	catLaptops.click();	
}

public void clickCategoryMonitors() {
	catMonitors.click();	
}
public void clickCategoryPhones() {
	catPhones.click();	
}

public void clickFirstPhoneProduct() {
	firstPhoneProduct.click();
}

public void clickFirstLaptopProduct() {
	firstLaptopProduct.click();
}
public void clickFirstMonitorProduct() {
	firstMonitorProduct.click();
}

}
