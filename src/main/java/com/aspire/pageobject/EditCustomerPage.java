package com.aspire.pageobject;

import common.BaseElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends BaseElement {

	public EditCustomerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "name")
	WebElement CUSTOMERNAME_TXT;

	@FindBy(id = "dob")
	WebElement DATEOFBIRTH_TXT;

	@FindBy(xpath = "//textarea[contains(@name,'addr')]")
	WebElement ADDRESS_TXTAREA;

	@FindBy(name = "city")
	WebElement CITY_TXT;

	@FindBy(name = "state")
	WebElement STATE_TXT;

	@FindBy(name = "pinno")
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

	@FindBy(name = "cusid")
	WebElement CUSTOMERID_TXT;

	@FindBy(name = "AccSubmit")
	WebElement SUBMITOEDIT_BTN;

	@FindBy(xpath = "//p[contains(text(),'Customer details updated Successfully!!!')]")
	WebElement UPDATESUCCESS_LBL;

	public void inputIdCustomer(String IdCustomer) {
		waitVisible(CUSTOMERID_TXT);
		input(CUSTOMERID_TXT, IdCustomer);
	}

	public void clickSubmitToEditInfor() {
		waitVisible(SUBMITOEDIT_BTN);
		click(SUBMITOEDIT_BTN);
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

	public void clickSubmitToUpdateInfor() {
		waitVisible(SUBMIT_BTN);
		click(SUBMIT_BTN);
	}

	public String getTextMessageEditCustomerSuccess() {
		waitVisible(UPDATESUCCESS_LBL);
		return getText(UPDATESUCCESS_LBL);
	}

	// Edit customer TestCase
	// Field CustomerID
	public void pressTabCustomerIdField() {
		waitVisible(CUSTOMERID_TXT);
		inputKeys(CUSTOMERID_TXT, Keys.TAB);
	}

	public void enterNummericCustomerIdField(String nummericValueIdCustomer) {
		waitVisible(CUSTOMERID_TXT);
		input(CUSTOMERID_TXT, nummericValueIdCustomer);
	}

	public void enterSpecialCharacterCustomerIdField(String specialCharacterCustomerId) {
		waitVisible(CUSTOMERID_TXT);
		input(CUSTOMERID_TXT, specialCharacterCustomerId);
	}

	public String getUrlEditCustomer() {
		return getCurrentUrl();
	}

	// Field Name
	public void pressTabNameField() {
		waitVisible(CUSTOMERNAME_TXT);
		inputKeys(CUSTOMERNAME_TXT, Keys.TAB);
	}

	public void enterNummericNameField(String nummericValueNameUpdate) {
		waitVisible(CUSTOMERNAME_TXT);
		input(CUSTOMERNAME_TXT, nummericValueNameUpdate);
	}

	public void enterSpecialCharacterNameField(String specialCharacterNameUpdate) {
		waitVisible(CUSTOMERNAME_TXT);
		input(CUSTOMERNAME_TXT, specialCharacterNameUpdate);
	}

	// Field Address
	public void pressTabAddressField() {
		waitVisible(ADDRESS_TXTAREA);
		inputKeys(ADDRESS_TXTAREA, Keys.TAB);
	}

	// Field City
	public void pressTabCityField() {
		waitVisible(CITY_TXT);
		inputKeys(CITY_TXT, Keys.TAB);
	}

	public void enterNummericCityField(String nummericCityField) {
		waitVisible(CITY_TXT);
		input(CITY_TXT, nummericCityField);
	}

	public void enterSpecialCharacterCityField(String specialCharacterCityUpdate) {
		waitVisible(CITY_TXT);
		input(CITY_TXT, specialCharacterCityUpdate);
	}

	// Field State
	public void pressTabStateField() {
		waitVisible(STATE_TXT);
		inputKeys(STATE_TXT, Keys.TAB);
	}

	public void enterNummericStateField(String nummericStateField) {
		waitVisible(STATE_TXT);
		input(STATE_TXT, nummericStateField);
	}

	public void enterSpecialCharacterStateField(String specialCharacterStateUpdate) {
		waitVisible(STATE_TXT);
		input(STATE_TXT, specialCharacterStateUpdate);
	}

	// Field PIN
	public void enterCharPinField(String pinNumberic) {
		waitVisible(PIN_TXT);
		input(PIN_TXT, pinNumberic);
	}

	public void pressTabPinField() {
		waitVisible(PIN_TXT);
		inputKeys(PIN_TXT, Keys.TAB);
	}

	public void enterDigit(String digitUpdate) {
		waitVisible(PIN_TXT);
		input(PIN_TXT, digitUpdate);
	}

	public void enterSpecialCharacterPinField(String specialCharacterPinUpdate) {
		waitVisible(PIN_TXT);
		input(PIN_TXT, specialCharacterPinUpdate);
	}

	// Field Telephone
	public void pressTabTelephoneField() {
		waitVisible(MOBILENUMBER_TXT);
		inputKeys(MOBILENUMBER_TXT, Keys.TAB);
	}

	public void enterSpecialCharacterTelephoneField(String specialCharacterTelephoneUpdate) {
		waitVisible(MOBILENUMBER_TXT);
		input(MOBILENUMBER_TXT, specialCharacterTelephoneUpdate);
	}

	// Field Email
	public void pressTabEmailField() {
		waitVisible(EMAIL_TXT);
		inputKeys(EMAIL_TXT, Keys.TAB);
	}

	public void enterInvalidEmail(String invalidEmail) {
		waitVisible(EMAIL_TXT);
		input(EMAIL_TXT, invalidEmail);
	}

	public void pressSpaceEmailField() {
		waitVisible(EMAIL_TXT);
		inputKeys(EMAIL_TXT, Keys.SPACE);
	}

	public String getDynamicMesage(String value) {
		waitVisibleDynamic(value);
		return getTextDynamic(value);
	}
}
