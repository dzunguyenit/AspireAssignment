package com.aspire.object.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment {

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

}
