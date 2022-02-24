package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseElement {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'here')]")
	WebElement HERE_LINK;

	@FindBy(name = "uid")
	WebElement EMAIL_TXT;

	@FindBy(name = "password")
	WebElement PASSWORD_TXT;

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement EDIT_CUSTOMER_LINK;

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement NEWCUSTOMER_CUSTOMER_LINK;

	public String getLoginPageUrl() {
		return getCurrentUrl();
	}

	public RegisterPage clickHereLink() {
		waitVisible(HERE_LINK);
		click(HERE_LINK);
		return PageFactory.initElements(driver, RegisterPage.class);
	}

	public void inputEmail(String username) {
		waitVisible(EMAIL_TXT);
		input(EMAIL_TXT, username);
	}

	public void inputPassword(String password) {
		waitVisible(PASSWORD_TXT);
		input(PASSWORD_TXT, password);
	}

	public EditCustomerPage openEditCustomerPage() {
		waitVisible(EDIT_CUSTOMER_LINK);
		click(EDIT_CUSTOMER_LINK);
		return PageFactory.initElements(driver, EditCustomerPage.class);
	}

	public NewCustomerPage openNewCustomerPage() {
		waitVisible(NEWCUSTOMER_CUSTOMER_LINK);
		click(NEWCUSTOMER_CUSTOMER_LINK);
		return PageFactory.initElements(driver, NewCustomerPage.class);
	}

}
