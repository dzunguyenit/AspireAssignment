package com.aspire.object.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbstractObJectJson {

	@SerializedName("payment")
	@Expose
	private Payment payment;
	@SerializedName("NewCustomer")
	@Expose
	private NewCustomer newCustomer;
	@SerializedName("EditCustomer")
	@Expose
	private EditCustomer editCustomer;

	public Payment payment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public NewCustomer newCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(NewCustomer newCustomer) {
		this.newCustomer = newCustomer;
	}

	public EditCustomer editCustomer() {
		return editCustomer;
	}

	public void setEditCustomer(EditCustomer editCustomer) {
		this.editCustomer = editCustomer;
	}

}
