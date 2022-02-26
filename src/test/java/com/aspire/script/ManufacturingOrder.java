package com.aspire.script;

import Utils.PropertiesUtil;
import com.aspire.pageobject.*;
import common.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManufacturingOrder extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    InventoryPage inventoryPage;
    ProductPage productPage;
    ManufacturingPage manufacturingPage;

    String pathData = "/data/";
    PropertiesUtil.Enviroment urlEnviroment;

    String randomProductName, randomOrderName;

    @BeforeClass
    public void beforeClass() {

//        Read file Property staging.properties
        ConfigFactory.setProperty("env", "staging");
        urlEnviroment = ConfigFactory.create(PropertiesUtil.Enviroment.class);

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
    public void tc_02_CreateProductWithoutName() {
        inventoryPage = homePage.clickInventoryMenu();
        productPage = inventoryPage.clickMenuProduct();
        productPage.clickCreateProduct();
        productPage.btnSaveRecord();
        // Don't input name -> show popup "Invalid fields: Name"
        verifyEquals(productPage.getNotificationTitle(), "Invalid fields:");
        verifyEquals(productPage.getNotificationContent(), "Name");
    }

    @Test
    public void tc_03_CreateProductSuccessfully() {
        productPage.inputProductName(randomProductName);
        productPage.clickUpdateQuantity();
        productPage.clickCreateQuantity();
        productPage.inputQuantity("15");
        productPage.btnSaveRecord();
    }

    @Test
    public void tc_04_CreateManufacturingOrderWithoutName() {
        homePage = productPage.clickApplicationIcon();
        manufacturingPage = homePage.clickManufacturingMenu();
        manufacturingPage.clickCreateManufacturingOrders();
        manufacturingPage.btnSaveRecord();
        // Don't input name -> show popup "Invalid fields: Name"
        verifyEquals(productPage.getNotificationTitle(), "Invalid fields:");

//        Get String "Product" from the total content "Product\nProduct Unit of Measure"
        String contentNotification = productPage.getNotificationContent();

//        Get String "Product" from the total content "Product\nProduct Unit of Measure"
        String productNotification = contentNotification.substring(0, 7);
        verifyEquals(productNotification, "Product");

//        Get String "Product Unit of Measure" from the total content "ProductProduct Unit of Measure"
        String productUnitNotification = contentNotification.substring(7, contentNotification.length());
        verifyEquals(productUnitNotification, "\nProduct Unit of Measure");
    }

    @Test
    public void tc_05_CreateManufacturingOrderSuccessfully() {
        manufacturingPage.inputOrderName(randomProductName);

        String quantity = "1.00";
        String scheduledDate = manufacturingPage.getScheduledDate();
        String responsibleUser = manufacturingPage.getResponsibleUser();

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

//        Validate the new Manufacturing Order is created with corrected information.
//        Verify Manufacturing Order Infomation includes: Product Name, Quantity, scheduledDate, responsibleUser

        String productName = manufacturingPage.getProductName();
        String quantityProduct = manufacturingPage.getQuantity();
        String scheduleTimeFinal = manufacturingPage.getScheduledTime();
        String responsibleUserFinal = manufacturingPage.getResponsible();

        verifyEquals(productName, randomProductName);
        verifyEquals(quantityProduct, quantity);
        verifyEquals(scheduleTimeFinal, scheduledDate);
        verifyEquals(responsibleUserFinal, responsibleUser);

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
