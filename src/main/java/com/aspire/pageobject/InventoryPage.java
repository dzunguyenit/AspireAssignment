package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BaseElement {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@title='Products']")
    WebElement lbMenuProduct;

    @FindBy(xpath = "//button[@title='Products']/following-sibling::div/a[text()='Products']")
    WebElement lbChildMenuProduct;

    public ProductPage clickMenuProduct() {
        waitVisible(lbMenuProduct);
        click(lbMenuProduct);
        waitVisible(lbChildMenuProduct);
        click(lbChildMenuProduct);
        return PageFactory.initElements(driver, ProductPage.class);
    }

}
