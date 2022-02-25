package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void inputEmail(String username) {
        waitVisible(EMAIL_TXT);
        input(EMAIL_TXT, username);
    }

    public void inputPassword(String password) {
        waitVisible(PASSWORD_TXT);
        input(PASSWORD_TXT, password);
    }

}
