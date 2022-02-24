package com.aspire.object.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewCustomer {

	@SerializedName("nummericValueName")
	@Expose
	private String nummericValueName;
	@SerializedName("specialCharacterName")
	@Expose
	private String specialCharacterName;
	@SerializedName("nummericValueCity")
	@Expose
	private String nummericValueCity;
	@SerializedName("specialCharacterCity")
	@Expose
	private String specialCharacterCity;
	@SerializedName("nummericValueState")
	@Expose
	private String nummericValueState;
	@SerializedName("specialCharacterState")
	@Expose
	private String specialCharacterState;
	@SerializedName("CharValueState")
	@Expose
	private String charValueState;
	@SerializedName("digit")
	@Expose
	private String digit;
	@SerializedName("specialCharacterPin")
	@Expose
	private String specialCharacterPin;
	@SerializedName("pinBlankSpace")
	@Expose
	private String pinBlankSpace;
	@SerializedName("specialCharacterTelephone")
	@Expose
	private String specialCharacterTelephone;
	@SerializedName("telephoneBlankSpace")
	@Expose
	private String telephoneBlankSpace;
	@SerializedName("incorrectEmail")
	@Expose
	private String incorrectEmail;
	@SerializedName("nameCannotEmptyMsg")
	@Expose
	private String nameCannotEmptyMsg;
	@SerializedName("cannotBeNumbericMsg")
	@Expose
	private String cannotBeNumbericMsg;
	@SerializedName("cannotSpecialCharacterMsg")
	@Expose
	private String cannotSpecialCharacterMsg;
	@SerializedName("firstCharacterBlankSpaceMsg")
	@Expose
	private String firstCharacterBlankSpaceMsg;
	@SerializedName("mustBeNumbericMsg")
	@Expose
	private String mustBeNumbericMsg;
	@SerializedName("namemustBeNumbericMsg")
	@Expose
	private String namemustBeNumbericMsg;
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

	public String getNummericValueName() {
		return nummericValueName;
	}

	public String getSpecialCharacterName() {
		return specialCharacterName;
	}

	public String getNummericValueCity() {
		return nummericValueCity;
	}

	public String getSpecialCharacterCity() {
		return specialCharacterCity;
	}

	public String getNummericValueState() {
		return nummericValueState;
	}

	public String getSpecialCharacterState() {
		return specialCharacterState;
	}

	public String getCharValueState() {
		return charValueState;
	}

	public String getDigit() {
		return digit;
	}

	public String getSpecialCharacterPin() {
		return specialCharacterPin;
	}

	public String getPinBlankSpace() {
		return pinBlankSpace;
	}

	public String getSpecialCharacterTelephone() {
		return specialCharacterTelephone;
	}

	public String getTelephoneBlankSpace() {
		return telephoneBlankSpace;
	}

	public String getIncorrectEmail() {
		return incorrectEmail;
	}

	public String getNameCannotEmptyMsg() {
		return nameCannotEmptyMsg;
	}

	public String getCannotBeNumbericMsg() {
		return cannotBeNumbericMsg;
	}

	public String getCannotSpecialCharacterMsg() {
		return cannotSpecialCharacterMsg;
	}

	public String getFirstCharacterBlankSpaceMsg() {
		return firstCharacterBlankSpaceMsg;
	}

	public String getMustBeNumbericMsg() {
		return mustBeNumbericMsg;
	}

	public String getNamemustBeNumbericMsg() {
		return namemustBeNumbericMsg;
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
