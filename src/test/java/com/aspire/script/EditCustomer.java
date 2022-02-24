package com.aspire.script;

import com.aspire.object.json.AbstractObJectJson;
import com.aspire.pageobject.EditCustomerPage;
import com.aspire.pageobject.HomePage;
import com.aspire.pageobject.LoginPage;
import common.BaseTest;
import common.ManageEnviroment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class EditCustomer extends BaseTest {
	ManageEnviroment.Enviroment urlEnviroment;
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private EditCustomerPage editCustomerPage;
	AbstractObJectJson data;
	String pathData = "/Data/";
	String userPath = System.getProperty("user.dir");

	@Parameters({ "browser", "environment", "version", "dataJson" })
	@BeforeClass
	public void beforeClass(String browser, String environment, String version, String dataJson) {

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
		log.info("Edit Customer_01 Step 01 - Open Edit Customer Page");
		editCustomerPage = homePage.openEditCustomerPage();

	}

	@Test
	public void TC_01_CustomerIdCanotEmpty() {
		log.info("Edit Customer_01 Step 02 - Press Tab CustomerId Field");
		editCustomerPage.pressTabCustomerIdField();
		log.info("Edit Customer_01 Step 03 - Verify Text Error CustomerID");
		verifyEquals(data.editCustomer().getRequireIdMsg(), editCustomerPage.getTextDynamic("Customer ID is required"));

	}

	@Test
	public void TC_02_CustomerIdCannotBeNumberic() {
		log.info("Edit Customer_01 Step 02 - Enter Nummeric CustomerId Field");
		editCustomerPage.enterNummericCustomerIdField(data.editCustomer().getNummericValueIdCustomer());
		log.info("Edit Customer_01 Step 03 - Verify Text Error CustomerID");
		verifyEquals(data.editCustomer().getMustBeNumbericMsg(),
				editCustomerPage.getTextDynamic("Characters are not allowed"));

	}

	@Test
	public void TC_03_CustomerIdCannotHaveSpecialCharacter() {
		log.info("Edit Customer_01 Step 02 - Enter Special Character CustomerId Field");
		editCustomerPage.enterSpecialCharacterCustomerIdField(data.editCustomer().getSpecialCharacterCustomerId());
		log.info("Edit Customer_01 Step 03 - Verify Text Error CustomerID");
		verifyEquals(data.editCustomer().getCannotSpecialCharacterMsg(),
				editCustomerPage.getTextDynamic("Special characters are not allowed"));
	}

	@Test
	public void TC_04_ValidCustomerId() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Verify Navigate Edit Customer");
		verifyEquals(data.editCustomer().getUrlEditCustomer(), editCustomerPage.getUrlEditCustomer());
	}

	// Testcas 05, 06, 07: Skip

	// @Test
	// public void TC_05_NameCannotEmpty() {
	// editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
	// editCustomerPage.inputIdCustomer(NewCustomer.customerId);
	// editCustomerPage.clickSubmitToEditInfor();
	// editCustomerPage.pressTabNameField();
	// verifyEquals("Customer name must not be blank",
	// editCustomerPage.getTextUsernameErr());
	//
	// }
	//
	// @Parameters({ "nummericValueNameUpdate" })
	// @Test
	// public void TC_06_NameCannotBeNumberic(String nummericValueNameUpdate) {
	// editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
	// editCustomerPage.inputIdCustomer(NewCustomer.customerId);
	// editCustomerPage.clickSubmitToEditInfor();
	// editCustomerPage.enterNummericNameField(nummericValueNameUpdate);
	// verifyEquals("Numbers are not allowed",
	// editCustomerPage.getTextUsernameErr());
	//
	// }
	//
	// @Parameters({ "specialCharacterNameUpdate" })
	// @Test
	// public void TC_07_NameCannotHaveSpecialCharacter(String
	// specialCharacterNameUpdate) {
	// editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
	// editCustomerPage.inputIdCustomer(NewCustomer.customerId);
	// editCustomerPage.clickSubmitToEditInfor();
	// editCustomerPage.enterSpecialCharacterNameField(specialCharacterNameUpdate);
	// verifyEquals(cannotSpecialCharacterMsg,
	// editCustomerPage.getTextUsernameErr());
	//
	// }

	@Test
	public void TC_08_AddressCannotEmpty() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Tab Addres sField");
		editCustomerPage.pressTabAddressField();
		log.info("Edit Customer_01 Step 05 - Verify Text Address Error");
		verifyEquals(data.editCustomer().getAddressCannotEmptyMsg(),
				editCustomerPage.getTextDynamic("Address Field must not be blank"));

	}

	@Test
	public void TC_09_CityCannotEmpty() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Tab City Field");
		editCustomerPage.pressTabCityField();
		log.info("Edit Customer_01 Step 05 - Verify Text City Error");
		verifyEquals(data.editCustomer().getCityCannotEmptyMsg(),
				editCustomerPage.getTextDynamic("City Field must not be blank"));
	}

	@Test
	public void TC_10_CityCannotBeNumberic() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Nummeric City Field");
		editCustomerPage.enterNummericCityField(data.editCustomer().getNummericCityField());
		log.info("Edit Customer_01 Step 05 - Verify Text City Error");
		verifyEquals(data.editCustomer().getCannotBeNumbericMsg(),
				editCustomerPage.getTextDynamic("Numbers are not allowed"));
	}

	@Test
	public void TC_11_CityCannotHaveSpecialCharacter() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Special Character City Field");
		editCustomerPage.enterSpecialCharacterCityField(data.editCustomer().getSpecialCharacterCityUpdate());
		log.info("Edit Customer_01 Step 05 - Verify Text City Error");
		verifyEquals(data.editCustomer().getCannotSpecialCharacterMsg(),
				editCustomerPage.getTextDynamic("Special characters are not allowed"));
	}

	@Test
	public void TC_12_StateCannotEmpty() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Tab State Field");
		editCustomerPage.pressTabStateField();
		log.info("Edit Customer_01 Step 05 - Verify Text State Error");
		verifyEquals(data.editCustomer().getStateCannotEmptyMsg(),
				editCustomerPage.getTextDynamic("State must not be blank"));
	}

	@Test
	public void TC_13_StateCannotBeNumberic() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Nummeric State Field");
		editCustomerPage.enterNummericStateField(data.editCustomer().getNummericStateField());
		log.info("Edit Customer_01 Step 05 - Verify Text State Error");
		verifyEquals(data.editCustomer().getCannotBeNumbericMsg(),
				editCustomerPage.getTextDynamic("Numbers are not allowed"));
	}

	@Test
	public void TC_14_StateCannotHaveSpecialCharacter() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Special Character State Field");
		editCustomerPage.enterSpecialCharacterStateField(data.editCustomer().getSpecialCharacterStateUpdate());
		log.info("Edit Customer_01 Step 05 - Verify Text State Error");
		verifyEquals(data.editCustomer().getCannotSpecialCharacterMsg(),
				editCustomerPage.getTextDynamic("Special characters are not allowed"));
	}

	@Test
	public void TC_15_PinMustBeNumeric() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Char Pin Field");
		editCustomerPage.enterCharPinField(data.editCustomer().getPinNumberic());
		log.info("Edit Customer_01 Step 05 - Verify Text Pin Error");
		verifyEquals(data.editCustomer().getMustBeNumbericMsg(),
				editCustomerPage.getTextDynamic("Characters are not allowed"));
	}

	@Test
	public void TC_16_PinCannotEmpty() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Tab Pin Field");
		editCustomerPage.pressTabPinField();
		log.info("Edit Customer_01 Step 05 - Verify Text Pin Error");
		verifyEquals(data.editCustomer().getPinCannotEmptyMsg(),
				editCustomerPage.getTextDynamic("PIN Code must not be blank"));
	}

	@Test
	public void TC_17_PinMustHave6Digits() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Digit");
		editCustomerPage.enterDigit(data.editCustomer().getDigitUpdate());
		log.info("Edit Customer_01 Step 05 - Verify Text Pin Error");
		verifyEquals(data.editCustomer().getPinMustHave6DigitsMsg(),
				editCustomerPage.getTextDynamic("PIN Code must have 6 Digits"));
	}

	@Test
	public void TC_18_PinCannotHaveSpecialCharacter() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Special Character Pin Field");
		editCustomerPage.enterSpecialCharacterPinField(data.editCustomer().getSpecialCharacterPinUpdate());
		log.info("Edit Customer_01 Step 05 - Verify Text Pin Error");
		verifyEquals(data.editCustomer().getCannotSpecialCharacterMsg(),
				editCustomerPage.getTextDynamic("Special characters are not allowed"));
	}

	@Test
	public void TC_19_TelephoneCannotEmpty() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Tab Telephone Field");
		editCustomerPage.pressTabTelephoneField();
		log.info("Edit Customer_01 Step 05 - Verify Text Telephone Error");
		verifyEquals(data.editCustomer().getTelephoneCannotEmptyMsg(),
				editCustomerPage.getTextDynamic("Mobile no must not be blank"));
	}

	@Test
	public void TC_20_TelephoneCannotHaveSpecialCharacter() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Special Character Telephone Field");
		editCustomerPage.enterSpecialCharacterTelephoneField(data.editCustomer().getSpecialCharacterTelephoneUpdate());
		log.info("Edit Customer_01 Step 05 - Verify Text Telephone Error");
		verifyEquals(data.editCustomer().getCannotSpecialCharacterMsg(),
				editCustomerPage.getTextDynamic("Special characters are not allowed"));
	}

	@Test
	public void TC_21_EmailCannotEmpty() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Tab Email Field");
		editCustomerPage.pressTabEmailField();
		log.info("Edit Customer_01 Step 05 - Verify Text Email Error");
		verifyEquals(data.editCustomer().getEmailCannotEmptyMsg(),
				editCustomerPage.getTextDynamic("Email-ID must not be blank"));
	}

	@Test
	public void TC_22_EmailIncorrectFormat() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Enter Invalid Email");
		editCustomerPage.enterInvalidEmail(data.editCustomer().getInvalidEmail());
		log.info("Edit Customer_01 Step 05 - Verify Text Email Error");
		verifyEquals(data.editCustomer().getEmailIncorrectFormatMsg(),
				editCustomerPage.getTextDynamic("Email-ID is not valid"));
	}

	@Test
	public void TC_23_EmailCannotHaveBlankSpace() {
		log.info("Edit Customer_01 Step 02 - Input IdCustomer");
		editCustomerPage.inputIdCustomer(NewCustomer.customerId);
		log.info("Edit Customer_01 Step 03 - Click Submit To EditInfor");
		editCustomerPage.clickSubmitToEditInfor();
		log.info("Edit Customer_01 Step 04 - Press Space Email Field");
		editCustomerPage.pressSpaceEmailField();
		log.info("Edit Customer_01 Step 05 - Verify Text Email Error");
		verifyEquals(data.editCustomer().getCannotFirstCharacterBlankSpaceMsg(),
				editCustomerPage.getTextDynamic("First character can not have space"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
		log.info("----------CLOSE BROWSER-----------");
	}

}
