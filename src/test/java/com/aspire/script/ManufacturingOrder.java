package com.aspire.script;

import com.aspire.object.json.AbstractObJectJson;
import com.aspire.pageobject.HomePage;
import com.aspire.pageobject.InventoryPage;
import com.aspire.pageobject.LoginPage;
import com.aspire.pageobject.ProductPage;
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
    AbstractObJectJson data;
    String pathData = "/data/";
    ManageEnviroment.Enviroment urlEnviroment;

    String email = "user@aspireapp.com";
    String password = "@sp1r3app";

    @Parameters({"browser", "environment", "version", "dataJson"})
    @BeforeClass
    public void beforeClass(String browser, String environment, String version, String dataJson) {


        ConfigFactory.setProperty("env", environment);
        urlEnviroment = ConfigFactory.create(ManageEnviroment.Enviroment.class);

        String pathDataJson = System.getProperty("user.dir").concat(pathData).concat(dataJson);
        data = getDataJson(pathDataJson);
        log.info("----------OPEN BROWSER-----------");
        driver = openMultiBrowser(browser, urlEnviroment.url(), version);

        log.info("----------OPEN BROWSER-----------");

        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void tc_01_LogInSuccessfully() {
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        homePage = loginPage.clickLogInButton();
        verifyEquals(homePage.getUrlHomePage(), "https://aspireapp.odoo.com/web#cids=1&action=menu");

    }

    @Test
    public void tc_02_LogInSuccessfully() {
        inventoryPage = homePage.clickInventoryMenu();
        productPage = inventoryPage.clickMenuProduct();
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
