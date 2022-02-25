package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void clickCreateManufacturingOrders() {
        waitVisible(btnCreateManufacturingOrders);
        click(btnCreateManufacturingOrders);
    }

    public void inputOrderName(String orderName) {
        click(txtOrderName);
        onlyInput(txtOrderName, orderName);
    }

    public void btnSaveRecord() {
        waitVisible(btnSaveRecord);
        click(btnSaveRecord);
    }

    public String getCurrentState(String attribute) {
        waitVisible(lbCurrentState);
        return getAtribute(lbCurrentState, attribute);
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
}