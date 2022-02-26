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

    @FindBy(xpath = "//div[text()='Inventory']")
    WebElement lbInventory;

    @FindBy(xpath = "//div[text()='Manufacturing']")
    WebElement lbManufacturing;

    @FindBy(css = "img.o_user_avatar")
    WebElement lbUserAvatar;

    public String getUrlHomePage() {
        return getCurrentUrl();
    }

    public InventoryPage clickInventoryMenu() {
        waitVisible(lbInventory);
        click(lbInventory);
        return PageFactory.initElements(driver, InventoryPage.class);
    }
    public ManufacturingPage clickManufacturingMenu() {
        waitVisible(lbManufacturing);
        click(lbManufacturing);
        return PageFactory.initElements(driver, ManufacturingPage.class);
    }

    public boolean isDisplayedAvatarUser() {
        waitVisible(lbUserAvatar);
        return isDisplayed(lbUserAvatar);
    }
}
