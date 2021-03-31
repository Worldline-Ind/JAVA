package com.ingenico.payment.domain;

import java.util.Arrays;

public class Acss {
	
	private String bankAcsFormName;
	private String bankAcsHttpMethod;
	private String[] bankAcsParams;
	private String bankAcsUrl;
	public String getBankAcsFormName() {
		return bankAcsFormName;
	}
	public void setBankAcsFormName(String bankAcsFormName) {
		this.bankAcsFormName = bankAcsFormName;
	}
	public String getBankAcsHttpMethod() {
		return bankAcsHttpMethod;
	}
	public void setBankAcsHttpMethod(String bankAcsHttpMethod) {
		this.bankAcsHttpMethod = bankAcsHttpMethod;
	}
	public String[] getBankAcsParams() {
		return bankAcsParams;
	}
	public void setBankAcsParams(String[] bankAcsParams) {
		this.bankAcsParams = bankAcsParams;
	}
	public String getBankAcsUrl() {
		return bankAcsUrl;
	}
	public void setBankAcsUrl(String bankAcsUrl) {
		this.bankAcsUrl = bankAcsUrl;
	}
	@Override
	public String toString() {
		return "Acss [bankAcsFormName=" + bankAcsFormName + ", bankAcsHttpMethod=" + bankAcsHttpMethod
				+ ", bankAcsParams=" + Arrays.toString(bankAcsParams) + ", bankAcsUrl=" + bankAcsUrl + "]";
	}
	
	
	

}
