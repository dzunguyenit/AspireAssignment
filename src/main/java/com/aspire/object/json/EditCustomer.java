package com.aspire.object.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditCustomer {

	@SerializedName("customerName")
	@Expose
	private String customerName;
	@SerializedName("dateOfBirth")
	@Expose
	private String dateOfBirth;
	@SerializedName("address")
	@Expose
	private String address;
	@SerializedName("city")
	@Expose
	private String city;
	@SerializedName("state")
	@Expose
	private String state;
	@SerializedName("PIN")
	@Expose
	private String pIN;
	@SerializedName("mobileNumber")
	@Expose
	private String mobileNumber;
	@SerializedName("passwordCustomer")
	@Expose
	private String passwordCustomer;
	@SerializedName("registerSuccessfullyMsg")
	@Expose
	private String registerSuccessfullyMsg;
	@SerializedName("requireIdMsg")
	@Expose
	private String requireIdMsg;
	@SerializedName("nummericValueIdCustomer")
	@Expose
	private String nummericValueIdCustomer;
	@SerializedName("specialCharacterCustomerId")
	@Expose
	private String specialCharacterCustomerId;
	@SerializedName("nummericCityField")
	@Expose
	private String nummericCityField;
	@SerializedName("specialCharacterCityUpdate")
	@Expose
	private String specialCharacterCityUpdate;
	@SerializedName("nummericStateField")
	@Expose
	private String nummericStateField;
	@SerializedName("specialCharacterStateUpdate")
	@Expose
	private String specialCharacterStateUpdate;
	@SerializedName("pinNumberic")
	@Expose
	private String pinNumberic;
	@SerializedName("digitUpdate")
	@Expose
	private String digitUpdate;
	@SerializedName("specialCharacterPinUpdate")
	@Expose
	private String specialCharacterPinUpdate;
	@SerializedName("specialCharacterTelephoneUpdate")
	@Expose
	private String specialCharacterTelephoneUpdate;
	@SerializedName("invalidEmail")
	@Expose
	private String invalidEmail;
	@SerializedName("cannotBeNumbericMsg")
	@Expose
	private String cannotBeNumbericMsg;
	@SerializedName("cannotSpecialCharacterMsg")
	@Expose
	private String cannotSpecialCharacterMsg;
	@SerializedName("urlEditCustomer")
	@Expose
	private String urlEditCustomer;
	@SerializedName("cannotFirstCharacterBlankSpaceMsg")
	@Expose
	private String cannotFirstCharacterBlankSpaceMsg;
	@SerializedName("mustBeNumbericMsg")
	@Expose
	private String mustBeNumbericMsg;
	@SerializedName("cityCannotEmptyMsg")
	@Expose
	private String cityCannotEmptyMsg;
	@SerializedName("addressCannotEmptyMsg")
	@Expose
	private String addressCannotEmptyMsg;
	@SerializedName("stateCannotEmptyMsg")
	@Expose
	private String stateCannotEmptyMsg;
	@SerializedName("pinCannotEmptyMsg")
	@Expose
	private String pinCannotEmptyMsg;
	@SerializedName("pinMustHave6DigitsMsg")
	@Expose
	private String pinMustHave6DigitsMsg;
	@SerializedName("telephoneCannotEmptyMsg")
	@Expose
	private String telephoneCannotEmptyMsg;
	@SerializedName("emailCannotEmptyMsg")
	@Expose
	private String emailCannotEmptyMsg;
	@SerializedName("emailIncorrectFormatMsg")
	@Expose
	private String emailIncorrectFormatMsg;

	public String getCustomerName() {
		return customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPIN() {
		return pIN;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getPasswordCustomer() {
		return passwordCustomer;
	}

	public String getRegisterSuccessfullyMsg() {
		return registerSuccessfullyMsg;
	}

	public String getRequireIdMsg() {
		return requireIdMsg;
	}

	public String getNummericValueIdCustomer() {
		return nummericValueIdCustomer;
	}

	public String getSpecialCharacterCustomerId() {
		return specialCharacterCustomerId;
	}

	public String getNummericCityField() {
		return nummericCityField;
	}

	public String getSpecialCharacterCityUpdate() {
		return specialCharacterCityUpdate;
	}

	public String getNummericStateField() {
		return nummericStateField;
	}

	public String getSpecialCharacterStateUpdate() {
		return specialCharacterStateUpdate;
	}

	public String getPinNumberic() {
		return pinNumberic;
	}

	public String getDigitUpdate() {
		return digitUpdate;
	}

	public String getSpecialCharacterPinUpdate() {
		return specialCharacterPinUpdate;
	}

	public String getSpecialCharacterTelephoneUpdate() {
		return specialCharacterTelephoneUpdate;
	}

	public String getInvalidEmail() {
		return invalidEmail;
	}

	public String getCannotBeNumbericMsg() {
		return cannotBeNumbericMsg;
	}

	public String getCannotSpecialCharacterMsg() {
		return cannotSpecialCharacterMsg;
	}

	public String getUrlEditCustomer() {
		return urlEditCustomer;
	}

	public String getCannotFirstCharacterBlankSpaceMsg() {
		return cannotFirstCharacterBlankSpaceMsg;
	}

	public String getMustBeNumbericMsg() {
		return mustBeNumbericMsg;
	}

	public String getCityCannotEmptyMsg() {
		return cityCannotEmptyMsg;
	}

	public String getAddressCannotEmptyMsg() {
		return addressCannotEmptyMsg;
	}

	public String getStateCannotEmptyMsg() {
		return stateCannotEmptyMsg;
	}

	public String getPinCannotEmptyMsg() {
		return pinCannotEmptyMsg;
	}

	public String getPinMustHave6DigitsMsg() {
		return pinMustHave6DigitsMsg;
	}

	public String getTelephoneCannotEmptyMsg() {
		return telephoneCannotEmptyMsg;
	}

	public String getEmailCannotEmptyMsg() {
		return emailCannotEmptyMsg;
	}

	public String getEmailIncorrectFormatMsg() {
		return emailIncorrectFormatMsg;
	}

}
