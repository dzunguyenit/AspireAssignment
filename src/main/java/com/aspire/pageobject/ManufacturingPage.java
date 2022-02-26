package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManufacturingPage extends BaseElement {

    public ManufacturingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-original-title='Create record']")
    WebElement btnCreateManufacturingOrders;

    @FindBy(xpath = "//div[@name='product_id']//input")
    WebElement txtOrderName;

    @FindBy(xpath = "//button[@title='Save record']")
    WebElement btnSaveRecord;

    @FindBy(xpath = "//button[@title='Current state']")
    WebElement lbCurrentState;

    @FindBy(css = "button[name=action_confirm]")
    WebElement btnConfirm;

    @FindBy(xpath = "//button[@name='button_mark_done' and @class='btn btn-primary']")
    WebElement btnMarkAsDone;

    @FindBy(css = "[role='alert']")
    WebElement lbConfirmation;

    @FindBy(css = "div.o_form_editable .o_inner_group")
    WebElement lbConfirmationImmediateProduction;

    @FindBy(xpath = "//span[text()='Ok']")
    WebElement btnOk;

    @FindBy(xpath = "//span[text()='Apply']")
    WebElement btnApply;

    @FindBy(css = ".o_notification_manager .o_notification_content")
    WebElement lbNotificationContent;

    @FindBy(css = ".o_notification_title")
    WebElement lbNotificationTitle;

    @FindBy(xpath = "//input[@name='product_qty' and not(@title)]")
    WebElement txtQuantity;

    @FindBy(css = "[name='product_id'][id*='o_field_input'] span")
    WebElement lbProductName;

    @FindBy(css = "[name=qty_producing]")
    WebElement lbQuantity;

    @FindBy(css = "span[name=date_planned_start]")
    WebElement lbDatePlanStart;

    @FindBy(css = "[name=user_id] span")
    WebElement lbResponsible;


    public void clickCreateManufacturingOrders() {
        waitVisible(btnCreateManufacturingOrders);
        click(btnCreateManufacturingOrders);
    }

    public void inputOrderName(String orderName) {
        click(txtOrderName);
        onlyInput(txtOrderName, orderName);
        sleep(1);
    }

    public void btnSaveRecord() {
        waitVisible(btnSaveRecord);
        click(btnSaveRecord);
    }

    public String getCurrentState(String attribute) {
        waitVisible(lbCurrentState);
        return getAtribute(lbCurrentState, attribute);
    }

    public void waitCurrentState(String state) {
        sleep(3);
        String dynamicLocator = String.format("//button[@title='Current state' and @data-value='%s']", state);
        waitVisible(dynamicLocator);
    }

    public void clickConfirm() {
        waitVisible(btnConfirm);
        click(btnConfirm);
    }

    public void clickMarkAsDone() {
        waitVisible(btnMarkAsDone);
        click(btnMarkAsDone);
    }

    public String getConfirmationMessage() {
        waitVisible(lbConfirmation);
        return getText(lbConfirmation);
    }

    public String getConfirmationImmediateProductionMessage() {
        waitVisible(lbConfirmationImmediateProduction);
        return getText(lbConfirmationImmediateProduction);
    }

    public void clickOk() {
        waitVisible(btnOk);
        click(btnOk);
    }

    public void clickApply() {
        waitVisible(btnApply);
        click(btnApply);
    }

    public String getNotificationContent() {
        waitVisible(lbNotificationContent);
        return getText(lbNotificationContent);
    }

    public String getNotificationTitle() {
        waitVisible(lbNotificationTitle);
        return getText(lbNotificationTitle);
    }

    public String getScheduledDate() {
        sleep(1);
        return executeJavascriptToBrowser("return $('input.datetimepicker-input').val()");
    }

    public String getResponsibleUser() {
        sleep(1);
        return executeJavascriptToBrowser("return $('[name=\"user_id\"] input').val()");
    }


    public void inputQuantity(String quantity) {
//        waitVisible(txtQuantity);
        input(txtQuantity, quantity);
    }

    public String getQuantity() {
        waitVisible(lbQuantity);
        return getText(lbQuantity);
    }

    public String getProductName() {
        waitVisible(lbProductName);
        return getText(lbProductName);
    }

    public String getScheduledTime() {
        waitVisible(lbDatePlanStart);
        return getText(lbDatePlanStart);
    }

    public String getResponsible() {
        waitVisible(lbResponsible);
        return getText(lbResponsible);
    }
}