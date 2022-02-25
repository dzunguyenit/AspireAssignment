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

    @FindBy(css = "#login")
    WebElement txtEmail;

    @FindBy(css = "#password")
    WebElement txtPassword;

    @FindBy(css = "[type=submit]")
    WebElement btnLogIn;

    public void inputEmail(String email) {
        waitVisible(txtEmail);
        input(txtEmail, email);
    }

    public void inputPassword(String password) {
        waitVisible(txtPassword);
        input(txtPassword, password);
    }

    public HomePage clickLogInButton() {
        waitVisible(btnLogIn);
        click(btnLogIn);
        return PageFactory.initElements(driver, HomePage.class);
    }

}
