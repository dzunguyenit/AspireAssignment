package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseElement {

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[text()='Inventory']")
    WebElement lbInventory;

    @FindBy(xpath = "//button[@title='Create record']")
    WebElement btnCreateProduct;

    @FindBy(css = "input[name=name]")
    WebElement txtProductName;

    @FindBy(css = "button[name=action_update_quantity_on_hand]")
    WebElement lbUpdateQuantity;

    @FindBy(xpath = "//button[@data-original-title='Create record']")
    WebElement btnCreateQuantity;

    @FindBy(css = "input[name=inventory_quantity]")
    WebElement txtQuantity;

    @FindBy(xpath = "//button[@title='Save record']")
    WebElement btnSaveRecord;

    @FindBy(css = "a[title='Home menu']")
    WebElement iconApplication;



    public String getUrlHomePage() {
        sleep(2);
        return getCurrentUrl();
    }

    public InventoryPage clickInventoryMenu() {
        waitVisible(lbInventory);
        click(lbInventory);
        return PageFactory.initElements(driver, InventoryPage.class);
    }

    public void clickCreateProduct() {
        waitVisible(btnCreateProduct);
        click(btnCreateProduct);
    }

    public void clickCreateQuantity() {
        waitVisible(btnCreateQuantity);
        click(btnCreateQuantity);
    }

    public void inputProductName(String productName) {
        waitVisible(txtProductName);
        input(txtProductName, productName);
    }

    public void inputQuantity(String quantity) {
        waitVisible(txtQuantity);
        input(txtQuantity, quantity);
    }

    public void btnSaveRecord() {
        waitVisible(btnSaveRecord);
        click(btnSaveRecord);
    }

    public void clickUpdateQuantity() {
        waitVisible(lbUpdateQuantity);
        click(lbUpdateQuantity);
    }

    public HomePage clickApplicationIcon() {
        waitVisible(iconApplication);
        click(iconApplication);
        return PageFactory.initElements(driver, HomePage.class);
    }

}
