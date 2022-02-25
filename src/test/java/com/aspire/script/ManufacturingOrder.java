package com.aspire.script;

import com.aspire.object.json.AbstractObJectJson;
import com.aspire.pageobject.HomePage;
import com.aspire.pageobject.LoginPage;
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
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        homePage = loginPage.clickLogInButton();
    }

    @Test
    public void tc_01_LogInSuccessfully() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        homePage = loginPage.clickLogInButton();
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
