package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage extends BaseElement {
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
    WebElement EDIT_CUSTOMER_LINK;

    @FindBy(css = "input[name='name']")
    WebElement CUSTOMERNAME_TXT;

    @FindBy(id = "dob")
    WebElement DATEOFBIRTH_TXT;

    @FindBy(xpath = "//textarea[contains(@name,'addr')]")
    WebElement ADDRESS_TXTAREA;

    @FindBy(css = "input[name='city']")
    WebElement CITY_TXT;

    @FindBy(name = "state")
    WebElement STATE_TXT;

    @FindBy(css = "input[name='pinno']")
    WebElement PIN_TXT;

    @FindBy(name = "telephoneno")
    WebElement MOBILENUMBER_TXT;

    @FindBy(name = "emailid")
    WebElement EMAIL_TXT;

    @FindBy(name = "password")
    WebElement PASSWORD_TXT;

    @FindBy(name = "sub")
    WebElement SUBMIT_BTN;

    @FindBy(xpath = "//p[contains(text(),'Customer Registered Successfully!!!')]")
    WebElement REGISTERSUCCESS_LBL;

    @FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
    WebElement CUSTOMERID_LBL;

    @FindBy(css = "input[name='cusid']")
    WebElement CUSTOMERID_TXT;

    @FindBy(css = "input[name='AccSubmit']")
    WebElement SUBMITOEDIT_BTN;

    @FindBy(xpath = "//p[contains(text(),'Customer details updated Successfully!!!')]")
    WebElement UPDATESUCCESS_LBL;

    public void inputCustomerName(String customerName) {
        waitVisible(CUSTOMERNAME_TXT);
        input(CUSTOMERNAME_TXT, customerName);
    }

    public void inputDateOfBirth(String dateOfBirth) {
        waitVisible(DATEOFBIRTH_TXT);
        onlyInput(DATEOFBIRTH_TXT, dateOfBirth);
    }

    public void inputAddress(String address) {
        waitVisible(ADDRESS_TXTAREA);
        input(ADDRESS_TXTAREA, address);
    }

    public void inputCity(String city) {
        waitVisible(CITY_TXT);
        input(CITY_TXT, city);
    }

    public void inputState(String state) {
        waitVisible(STATE_TXT);
        input(STATE_TXT, state);
    }

    public void inputPIN(String pin) {
        waitVisible(PIN_TXT);
        input(PIN_TXT, pin);
    }

    public void inputMobileNumber(String mobileNumber) {
        waitVisible(MOBILENUMBER_TXT);
        input(MOBILENUMBER_TXT, mobileNumber);
    }

    public void inputEmail(String email) {
        waitVisible(EMAIL_TXT);
        input(EMAIL_TXT, email);
    }

    public void inputPassword(String password) {
        waitVisible(PASSWORD_TXT);
        input(PASSWORD_TXT, password);
    }

    public void clickSubmit() {
        waitVisible(SUBMIT_BTN);
        click(SUBMIT_BTN);
    }

    public String getTextMessageCreateCustomerSucces() {
        waitVisible(REGISTERSUCCESS_LBL);
        return getText(REGISTERSUCCESS_LBL);
    }

    public String getTextUserID() {
        waitVisible(CUSTOMERID_LBL);
        return getText(CUSTOMERID_LBL);
    }

    // Field Name
    public void pressTabNameField() {
        waitVisible(CUSTOMERNAME_TXT);
        inputKeys(CUSTOMERNAME_TXT, Keys.TAB);
    }

    public EditCustomerPage openEditCustomerPage() {
        waitVisible(EDIT_CUSTOMER_LINK);
        click(EDIT_CUSTOMER_LINK);
        return PageFactory.initElements(driver, EditCustomerPage.class);
    }

    public String getDynamicMesage(String value) {
        waitVisibleDynamic(value);
        return getTextDynamic(value);
    }

    public void enterNummericNameField(String nummericValue) {
        waitVisible(CUSTOMERNAME_TXT);
        input(CUSTOMERNAME_TXT, nummericValue);
    }

    public void enterSpecialCharacterNameField(String nummericValue) {
        waitVisible(CUSTOMERNAME_TXT);
        input(CUSTOMERNAME_TXT, nummericValue);
    }

    public void pressSpaceNameField() {
        waitVisible(CUSTOMERNAME_TXT);
        inputKeys(CUSTOMERNAME_TXT, Keys.SPACE);
    }

    // Field Address
    public void pressTabAddressField() {
        waitVisible(ADDRESS_TXTAREA);
        inputKeys(ADDRESS_TXTAREA, Keys.TAB);
    }

    public void pressSpaceAddressField() {
        waitVisible(ADDRESS_TXTAREA);
        inputKeys(ADDRESS_TXTAREA, Keys.SPACE);
    }

    // Field City
    public void pressTabCityField() {
        waitVisible(CITY_TXT);
        inputKeys(CITY_TXT, Keys.TAB);
    }

    public void enterNummericCityField(String nummericCity) {
        waitVisible(CITY_TXT);
        input(CITY_TXT, nummericCity);
    }

    public void enterSpecialCharacterCityField(String specialValue) {
        waitVisible(CITY_TXT);
        input(CITY_TXT, specialValue);
    }

    public void pressSpaceCityField() {
        waitVisible(CITY_TXT);
        inputKeys(CITY_TXT, Keys.SPACE);
    }

    // Field State
    public void pressTabStateField() {
        waitVisible(STATE_TXT);
        inputKeys(STATE_TXT, Keys.TAB);
    }

    public void enterNummericStateField(String nummericState) {
        waitVisible(STATE_TXT);
        input(STATE_TXT, nummericState);
    }

    public void enterSpecialCharacterStateField(String specialValue) {
        waitVisible(STATE_TXT);
        input(STATE_TXT, specialValue);
    }

    public void pressSpaceStateField() {
        waitVisible(STATE_TXT);
        inputKeys(STATE_TXT, Keys.SPACE);
    }

    // Field PIN
    public void enterCharPinField(String CharValueState) {
        waitVisible(PIN_TXT);
        input(PIN_TXT, CharValueState);
    }

    public void pressTabPinField() {
        waitVisible(PIN_TXT);
        inputKeys(PIN_TXT, Keys.TAB);
    }

    public void enterDigit(String digit) {
        waitVisible(PIN_TXT);
        input(PIN_TXT, digit);
    }

    public void enterSpecialCharacterPinField(String specialValue) {
        waitVisible(PIN_TXT);
        input(PIN_TXT, specialValue);
    }

    public void pressSpacePinField() {
        waitVisible(PIN_TXT);
        inputKeys(PIN_TXT, Keys.SPACE);
    }

    public void enterBlankSpacePinField(String pinBlankSpace) {
        waitVisible(PIN_TXT);
        input(PIN_TXT, pinBlankSpace);
    }

    // Telephone Field
    public void pressTabTelephoneField() {
        waitVisible(MOBILENUMBER_TXT);
        inputKeys(MOBILENUMBER_TXT, Keys.TAB);
    }

    public void pressSpaceTelePhoneField() {
        waitVisible(MOBILENUMBER_TXT);
        inputKeys(MOBILENUMBER_TXT, Keys.SPACE);
    }

    public void enterSpecialCharacterTelePhoneField(String specialValue) {
        waitVisible(MOBILENUMBER_TXT);
        input(MOBILENUMBER_TXT, specialValue);
    }

    public void enterBlankSpaceTelephoneField(String telephoneBlankSpace) {
        waitVisible(MOBILENUMBER_TXT);
        input(MOBILENUMBER_TXT, telephoneBlankSpace);
    }

    // Email Field
    public void pressEmaileField() {
        waitVisible(EMAIL_TXT);
        inputKeys(EMAIL_TXT, Keys.TAB);
    }

    public void enterIncorrectEmail(String incorrectEmail) {
        waitVisible(EMAIL_TXT);
        input(EMAIL_TXT, incorrectEmail);
    }

    public void pressSpaceEmailField() {
        waitVisible(EMAIL_TXT);
        inputKeys(EMAIL_TXT, Keys.SPACE);
    }

}
