package com.aspire.script;

import Utils.PropertiesUtil;
import com.aspire.pageobject.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import common.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

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

    ExtentReports extent;
    ExtentTest logger;


    @BeforeClass
    public void beforeClass() {

        ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/ManufacturingOrder.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

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

//        SCENARIO: tc_01_LogInSuccessfully:
//        1: Go to aspire login page: https://aspireapp.odoo.com/
//        2: Log In with a username and password: user@aspireapp.com/@sp1r3app
//        3: Verify HomePage is open with url: https://aspireapp.odoo.com/web#cids=1&action=menu
//        and avatar user is displayed
        logger = extent.createTest("tc_01_LogInSuccessfully");
        loginPage.inputEmail(urlEnviroment.username());
        loginPage.inputPassword(urlEnviroment.password());
        homePage = loginPage.clickLogInButton();
        verifyTrue(homePage.isDisplayedAvatarUser());
        verifyEquals(homePage.getUrlHomePage(), "https://aspireapp.odoo.com/web#cids=1&action=menu");

    }

    @Test
    public void tc_02_CreateProductWithoutName() {

//        SCENARIO: tc_02_CreateProductWithoutName:
//        Precondition: Log In Successfully
//        1. Click Inventory icon
//        2. Click Menu Products -> Products -> Go to Product Page
//        3. Click Create button
//        4. Click Save button
//        5. Verify error notification is displayed: "Invalid fields: Name"

        logger = extent.createTest("tc_02_CreateProductWithoutName");
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

//        SCENARIO: tc_03_CreateProductSuccessfully:
//        Precondition: Log In Successfully
//        1. Input random valid Product Name
//        2. Click tab Quantity: Update quantity > 10( data = 15)
//        3. Click Save button
        logger = extent.createTest("tc_03_CreateProductSuccessfully");
        productPage.inputProductName(randomProductName);
        productPage.clickUpdateQuantity();
        productPage.clickCreateQuantity();
        productPage.inputQuantity("15");
        productPage.btnSaveRecord();
    }

    @Test
    public void tc_04_CreateManufacturingOrderWithoutName() {

//        SCENARIO: tc_04_CreateManufacturingOrderWithoutName:
//        Precondition: Log In Successfully and Create Manufacturing Order item
//        for the created Product on Scenerio: tc_03_CreateProductSuccessfully
//
//        1. Back to HomePage by clicking Application Icon
//        2. Click Manufacturing Menu
//        3. Click Create button
//        4. Click button Save Record
//        5. Verify error notification is displayed: "Invalid fields:"
//        6. Verify content notification is displayed:
//        Product
//        Product Unit of Measure

        logger = extent.createTest("tc_04_CreateManufacturingOrderWithoutName");
        homePage = productPage.clickApplicationIcon();
        manufacturingPage = homePage.clickManufacturingMenu();
        manufacturingPage.clickCreateManufacturingOrders();
        manufacturingPage.btnSaveRecord();
        // Don't input name -> show popup "Invalid fields:"
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

//        SCENARIO: tc_05_CreateManufacturingOrderSuccessfully:
//        Precondition: Log In Successfully and Create Manufacturing Order item
//        for the created Product on Scenerio: tc_03_CreateProductSuccessfully
//
//        1. Input product name for the created Product on Scenario: tc_03_CreateProductSuccessfully
//        2. Get value of: quantity, scheduled date and responsible user -> Expected Result
//        3. Click Save
//        4. Status change -> draft -> Verify status draft is active
//        5. Click confirm -> Status change -> confirmed -> Verify status confirmed is active
//        5. Click Mark As Done -> Verify popup is displayed "There are no components to consume. Are you still sure you want to continue?"
//        6. Click Ok -> Verify popup is displayed "You have not recorded produced quantities yet, by clicking on apply Odoo will produce all the finished products and consume all components."
//        7. Click Apply -> Status change -> done -> Verify status done is active
//        8. Verify the new Manufacturing Order is created with corrected information includes: Product Name, Quantity, scheduledDate, responsibleUser

        logger = extent.createTest("tc_05_CreateManufacturingOrderSuccessfully");
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

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String temp = getScreenshot(driver);
            try {
                logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        extent.flush();

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
