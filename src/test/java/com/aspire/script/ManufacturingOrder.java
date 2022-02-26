package com.aspire.script;

import com.aspire.pageobject.*;
import common.BaseTest;
import common.ManageEnviroment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ManufacturingOrder extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    InventoryPage inventoryPage;
    ProductPage productPage;
    ManufacturingPage manufacturingPage;

    String pathData = "/data/";
    ManageEnviroment.Enviroment urlEnviroment;

    String randomProductName, randomOrderName;

    @BeforeClass
    public void beforeClass() {

//        Read file Property staging.properties
        ConfigFactory.setProperty("env", "staging");
        urlEnviroment = ConfigFactory.create(ManageEnviroment.Enviroment.class);

        log.info("----------OPEN BROWSER-----------");
        driver = openMultiBrowser(urlEnviroment.browser(), urlEnviroment.url(), urlEnviroment.version());

        loginPage = PageFactory.initElements(driver, LoginPage.class);

        randomProductName = "Auto Product Name " + randomUniqueNumber();
        log.info("----------randomProductName----------- " + randomProductName);

        randomOrderName = "Auto Order Name " + randomUniqueNumber();

        log.info("----------randomProductName----------- " + randomOrderName);
    }

    @Test
    public void tc_01_LogInSuccessfully() {
        loginPage.inputEmail(urlEnviroment.username());
        loginPage.inputPassword(urlEnviroment.password());
        homePage = loginPage.clickLogInButton();
        verifyTrue(homePage.isDisplayedAvatarUser());
        verifyEquals(homePage.getUrlHomePage(), "https://aspireapp.odoo.com/web#cids=1&action=menu");

    }

    @Test
    public void tc_02_CreateProductSuccessfully() {
        inventoryPage = homePage.clickInventoryMenu();
        productPage = inventoryPage.clickMenuProduct();
        productPage.clickCreateProduct();
        productPage.inputProductName(randomProductName);
        productPage.clickUpdateQuantity();
        productPage.clickCreateQuantity();
        productPage.inputQuantity("15");
        productPage.btnSaveRecord();

    }

    @Test
    public void tc_03_CreateManufacturingOrderSuccessfully() {
        homePage = productPage.clickApplicationIcon();
        manufacturingPage = homePage.clickManufacturingMenu();
        manufacturingPage.clickCreateManufacturingOrders();
        manufacturingPage.inputOrderName(randomProductName);
        manufacturingPage.btnSaveRecord();

//        Wait current state until is "draft"
        manufacturingPage.waitCurrentState("draft");
//        Check current state is "draft"
        verifyEquals(manufacturingPage.getCurrentState("data-value"), "draft");
//        Check state "draft" is active by get attribute "aria-checked" is True
        verifyTrue(Boolean.valueOf(manufacturingPage.getCurrentState("aria-checked")));
        manufacturingPage.clickConfirm();

//        Wait current state until is "confirmed"
        manufacturingPage.waitCurrentState("confirmed");
//        Check current state is "confirmed"
        verifyEquals(manufacturingPage.getCurrentState("data-value"), "confirmed");
//        Check state "confirmed" is active by get attribute "aria-checked" is True
        verifyTrue(Boolean.valueOf(manufacturingPage.getCurrentState("aria-checked")));

        manufacturingPage.clickMarkAsDone();

        verifyEquals(manufacturingPage.getConfirmationMessage(), "There are no components to consume. Are you still sure you want to continue?");
        manufacturingPage.clickOk();

        verifyEquals(manufacturingPage.getConfirmationImmediateProductionMessage(), "You have not recorded produced quantities yet, by clicking on apply Odoo will produce all the finished products and consume all components.");
        manufacturingPage.clickApply();

//        Wait current state until is "done"
        manufacturingPage.waitCurrentState("done");
//        Check current state is "done"
        verifyEquals(manufacturingPage.getCurrentState("data-value"), "done");
//        Check state "done" is active by get attribute "aria-checked" is True
        verifyTrue(Boolean.valueOf(manufacturingPage.getCurrentState("aria-checked")));

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
