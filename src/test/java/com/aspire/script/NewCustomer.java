package com.aspire.script;

import com.aspire.object.json.AbstractObJectJson;
import com.aspire.pageobject.HomePage;
import com.aspire.pageobject.LoginPage;
import com.aspire.pageobject.NewCustomerPage;
import common.BaseTest;
import common.ManageEnviroment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class NewCustomer extends BaseTest {
	ManageEnviroment.Enviroment urlEnviroment;
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private NewCustomerPage newCustomerPage;
	AbstractObJectJson data;

	String email;
	static String customerId;
	String pathData = "/Data/";
	String userPath = System.getProperty("user.dir");

	@Parameters({ "browser", "environment", "version", "dataJson" })
	@BeforeClass
	public void beforeClass(String browser, String environment, String version, String dataJson) {
		email = "automation" + randomEmail() + "@gmail.com";
		ConfigFactory.setProperty("env", environment);
		urlEnviroment = ConfigFactory.create(ManageEnviroment.Enviroment.class);

		String pathDataJson = userPath.concat(pathData).concat(dataJson);
		data = getDataJson(pathDataJson);
		log.info("----------OPEN BROWSER-----------");
		driver = openMultiBrowser(browser, urlEnviroment.url(), version);
		loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.inputEmail(Register.emailLogin);
		loginPage.inputPassword(Register.passwordLogin);
		homePage = loginPage.clickSubmitButton();

	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("New Customer_01 Step 01 - Open New Customer Page");
		newCustomerPage = homePage.openNewCustomerPage();
	}

	@Test
	public void TC_01_NameCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Button Tab Name Field");
		newCustomerPage.pressTabNameField();
		log.info("New Customer_01 Step 03 - Verify Text Username Error");
		verifyEquals(data.newCustomer().getNameCannotEmptyMsg(),
				newCustomerPage.getDynamicMesage("Customer name must not be blank"));

	}

	@Test
	public void TC_02_NameCannotBeNumberic() {
		log.info("New Customer_01 Step 02 - Enter Nummeric Name Field");
		newCustomerPage.enterNummericNameField(data.newCustomer().getNummericValueName());
		log.info("New Customer_01 Step 03 - Verify Text Username Error");
		verifyEquals(data.newCustomer().getNamemustBeNumbericMsg(),
				newCustomerPage.getTextDynamic("Numbers are not allowed"));

	}

	@Test
	public void TC_03_NameCannotHaveSpecialCharacter() {
		log.info("New Customer_01 Step 02 - Enter Special Character Name Field");
		newCustomerPage.enterSpecialCharacterNameField(data.newCustomer().getSpecialCharacterName());
		log.info("New Customer_01 Step 03 - Verify Text Username Error");
		verifyEquals(data.newCustomer().getCannotSpecialCharacterMsg(),
				newCustomerPage.getTextDynamic("Special characters are not allowed"));

	}

	@Test
	public void TC_04_NameCannotFirstCharacterBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space Character Name Field");
		newCustomerPage.pressSpaceNameField();
		log.info("New Customer_01 Step 03 - Verify Text Username Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(),
				newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_05_AddressCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Button Tab Addres sField");
		newCustomerPage.pressTabAddressField();
		log.info("New Customer_01 Step 03 - Verify Text Address Error");
		verifyEquals(data.newCustomer().getAddressCannotEmptyMsg(),
				newCustomerPage.getTextDynamic("Address Field must not be blank"));

	}

	@Test
	public void TC_06_AddressCannotFirstCharacterBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space Address Field");
		newCustomerPage.pressSpaceAddressField();
		log.info("New Customer_01 Step 03 - Verify Text Address Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(),
				newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_07_CityCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Button Tab City Field");
		newCustomerPage.pressTabCityField();
		log.info("New Customer_01 Step 03 - Verify Text City Error");
		verifyEquals(data.newCustomer().getCityCannotEmptyMsg(),
				newCustomerPage.getTextDynamic("City Field must not be blank"));

	}

	@Test
	public void TC_08_CityCannotBeNumberic() {
		log.info("New Customer_01 Step 02 - Enter Nummeric City Field");
		newCustomerPage.enterNummericCityField(data.newCustomer().getNummericValueCity());
		log.info("New Customer_01 Step 03 - Verify Text City Error");
		verifyEquals(data.newCustomer().getCannotBeNumbericMsg(),
				newCustomerPage.getTextDynamic("Numbers are not allowed"));

	}

	@Test
	public void TC_09_NameCannotHaveSpecialCharacter() {
		log.info("New Customer_01 Step 02 - Enter Special Character City Field");
		newCustomerPage.enterSpecialCharacterCityField(data.newCustomer().getSpecialCharacterCity());
		log.info("New Customer_01 Step 03 - Verify Text City Error");
		verifyEquals(data.newCustomer().getCannotSpecialCharacterMsg(),
				newCustomerPage.getTextDynamic("Special characters are not allowed"));

	}

	@Test
	public void TC_10_CityCannotFirstCharacterBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space Address Field");
		newCustomerPage.pressSpaceAddressField();
		log.info("New Customer_01 Step 03 - Verify Text Address Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(),
				newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_11_StateCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Tab State Field");
		newCustomerPage.pressTabStateField();
		log.info("New Customer_01 Step 03 - Verify Text State Error");
		verifyEquals(data.newCustomer().getStateCannotEmptyMsg(),
				newCustomerPage.getTextDynamic("State must not be blank"));

	}

	@Test
	public void TC_12_StateCannotBeNumberic() {
		log.info("New Customer_01 Step 02 - Enter Nummeric State Field");
		newCustomerPage.enterNummericStateField(data.newCustomer().getNummericValueState());
		log.info("New Customer_01 Step 03 - Verify Text State Error");
		verifyEquals(data.newCustomer().getCannotBeNumbericMsg(),
				newCustomerPage.getTextDynamic("Numbers are not allowed"));

	}

	@Test
	public void TC_13_StateCannotHaveSpecialCharacter() {
		log.info("New Customer_01 Step 02 - Enter Special Character State Field");
		newCustomerPage.enterSpecialCharacterStateField(data.newCustomer().getSpecialCharacterState());
		log.info("New Customer_01 Step 03 - Verify Text State Error");
		verifyEquals(data.newCustomer().getCannotSpecialCharacterMsg(),
				newCustomerPage.getTextDynamic("Special characters are not allowed"));

	}

	@Test
	public void TC_14_StateCannotFirstCharacterBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space State Field");
		newCustomerPage.pressSpaceStateField();
		log.info("New Customer_01 Step 03 - Verify Text State Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(),
				newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_15_PinMustBeNumeric() {
		log.info("New Customer_01 Step 02 - Enter Char Pin Field");
		newCustomerPage.enterCharPinField(data.newCustomer().getCharValueState());
		log.info("New Customer_01 Step 03 - Verify Text Pin Error");
		verifyEquals(data.newCustomer().getMustBeNumbericMsg(),
				newCustomerPage.getTextDynamic("Characters are not allowed"));

	}

	@Test
	public void TC_16_PinCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Tab Pin Field");
		newCustomerPage.pressTabPinField();
		log.info("New Customer_01 Step 03 - Verify Text Pin Error");
		verifyEquals(data.newCustomer().getPinCannotEmptyMsg(),
				newCustomerPage.getTextDynamic("PIN Code must not be blank"));

	}

	@Test
	public void TC_17_PinMustHave6Digits() {
		log.info("New Customer_01 Step 02 - Enter Digit");
		newCustomerPage.enterDigit(data.newCustomer().getDigit());
		log.info("New Customer_01 Step 03 - Verify Text Pin Error");
		verifyEquals(data.newCustomer().getPinMustHave6DigitsMsg(),
				newCustomerPage.getTextDynamic("PIN Code must have 6 Digits"));

	}

	@Test
	public void TC_18_PinCannotHaveSpecialCharacter() {
		log.info("New Customer_01 Step 02 - Enter Special Character Pin Field");
		newCustomerPage.enterSpecialCharacterPinField(data.newCustomer().getSpecialCharacterPin());
		log.info("New Customer_01 Step 03 - Verify Text Pin Error");
		verifyEquals(data.newCustomer().getCannotSpecialCharacterMsg(),
				newCustomerPage.getTextDynamic("Special characters are not allowed"));

	}

	@Test
	public void TC_19_PinCannotFirstCharacterBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space Pin Field");
		newCustomerPage.pressSpacePinField();
		log.info("New Customer_01 Step 03 - Verify Text Pin Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(),
				newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_20_PinCannotHaveBlankSpace() {
		log.info("New Customer_01 Step 02 - Enter Blank Space Pin Field");
		newCustomerPage.enterBlankSpacePinField(data.newCustomer().getPinBlankSpace());
		log.info("New Customer_01 Step 03 - Verify Text Pin Error");
		verifyEquals(data.newCustomer().getMustBeNumbericMsg(),
				newCustomerPage.getTextDynamic("Characters are not allowed"));

	}

	@Test
	public void TC_21_TelephoneCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Tab Telephone Field");
		newCustomerPage.pressTabTelephoneField();
		log.info("New Customer_01 Step 03 - Verify Text Telephone Error");
		verifyEquals(data.newCustomer().getTelephoneCannotEmptyMsg(),
				newCustomerPage.getTextDynamic("Mobile no must not be blank"));

	}

	@Test
	public void TC_22_TelephoneCannotFirstCharacterBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space TelePhone Field");
		newCustomerPage.pressSpaceTelePhoneField();
		log.info("New Customer_01 Step 03 - Verify Text Telephone Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(),
				newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_23_TelephoneCannotHaveBlankSpace() {
		log.info("New Customer_01 Step 02 - Enter Blank Space Telephone Field");
		newCustomerPage.enterBlankSpaceTelephoneField(data.newCustomer().getTelephoneBlankSpace());
		log.info("New Customer_01 Step 03 - Verify Text Telephone Error");
		verifyEquals(data.newCustomer().getMustBeNumbericMsg(),
				newCustomerPage.getTextDynamic("Characters are not allowed"));

	}

	@Test
	public void TC_24_TelephoneCannotHaveSpecialCharacter() {
		log.info("New Customer_01 Step 02 - Enter Special Character TelePhone Field");
		newCustomerPage.enterSpecialCharacterTelePhoneField(data.newCustomer().getSpecialCharacterTelephone());
		log.info("New Customer_01 Step 03 - Verify Text Telephone Error");
		verifyEquals(data.newCustomer().getCannotSpecialCharacterMsg(),
				newCustomerPage.getTextDynamic("Special characters are not allowed"));

	}

	@Test
	public void TC_25_EmailCannotEmpty() {
		log.info("New Customer_01 Step 02 - Press Emaile Field");
		newCustomerPage.pressEmaileField();
		log.info("New Customer_01 Step 03 - Verify Text Email Error");
		verifyEquals(data.newCustomer().getEmailCannotEmptyMsg(),
				newCustomerPage.getTextDynamic("Email-ID must not be blank"));

	}

	@Test
	public void TC_26_EmailIncorrectFormat() {
		log.info("New Customer_01 Step 02 - Enter Incorrect Email");
		newCustomerPage.enterIncorrectEmail(data.newCustomer().getIncorrectEmail());
		log.info("New Customer_01 Step 03 - Verify Text Email Error");
		verifyEquals(data.newCustomer().getEmailIncorrectFormatMsg(),
				newCustomerPage.getTextDynamic("Email-ID is not valid"));

	}

	@Test
	public void TC_27_EmailCannotHaveBlankSpace() {
		log.info("New Customer_01 Step 02 - Press Space Email Field");
		newCustomerPage.pressSpaceEmailField();
		log.info("New Customer_01 Step 03 - Verify Text Email Error");
		verifyEquals(data.newCustomer().getFirstCharacterBlankSpaceMsg(), newCustomerPage.getTextDynamic("First character can not have space"));

	}

	@Test
	public void TC_28_CreateCustomerSuccessfully() {
		newCustomerPage.inputCustomerName(data.editCustomer().getCustomerName());
		newCustomerPage.inputDateOfBirth(data.editCustomer().getDateOfBirth());
		newCustomerPage.inputAddress(data.editCustomer().getAddress());
		newCustomerPage.inputCity(data.editCustomer().getCity());
		newCustomerPage.inputState(data.editCustomer().getState());
		newCustomerPage.inputPIN(data.editCustomer().getPIN());
		newCustomerPage.inputMobileNumber(data.editCustomer().getMobileNumber());
		newCustomerPage.inputEmail(email);
		newCustomerPage.inputPassword(data.editCustomer().getPasswordCustomer());
		newCustomerPage.clickSubmit();
		verifyEquals(data.editCustomer().getRegisterSuccessfullyMsg(),
				newCustomerPage.getTextMessageCreateCustomerSucces());
		customerId = newCustomerPage.getTextUserID();

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
		log.info("----------CLOSE BROWSER-----------");
	}

}
