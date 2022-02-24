package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseElement {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'here')]")
	WebElement HERE_LINK;

	@FindBy(css = "input[name='uid']")
	WebElement EMAIL_TXT;

	@FindBy(css = "input[name='password']")
	WebElement PASSWORD_TXT;

	@FindBy(css = "input[name='btnLogin']")
	WebElement LOGIN_BTN;

	public String getLoginPageUrl() {
		return getCurrentUrl();
	}

	public RegisterPage clickHereLink() {
		// if (driver.toString().toLowerCase().contains("internetexplorer")) {
		// try {
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		waitVisible(HERE_LINK);
		click(HERE_LINK);
		return PageFactory.initElements(driver, RegisterPage.class);
	}

	public void inputEmail(String username) {
		waitVisible(EMAIL_TXT);
		highlightElement(EMAIL_TXT);
		input(EMAIL_TXT, username);
	}

	public void inputPassword(String password) {
		waitVisible(PASSWORD_TXT);
		highlightElement(PASSWORD_TXT);
		input(PASSWORD_TXT, password);
	}

	public HomePage clickSubmitButton() {
		waitVisible(LOGIN_BTN);
		highlightElement(LOGIN_BTN);
		click(LOGIN_BTN);
		return PageFactory.initElements(driver, HomePage.class);
	}

}
