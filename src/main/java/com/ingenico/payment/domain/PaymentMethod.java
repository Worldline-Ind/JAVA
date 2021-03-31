package com.ingenico.payment.domain;

import java.util.Map;

public class PaymentMethod {
	
	private String token;
	private String instrumentAliasName; 
	private String instrumentToken; 
	private String bankSelectionCode; 
	
	private Acss aCS;
	private Map<String, String> oTP;
	private PaymentTransaction paymentTransaction;
	private Map<String, String> authentication;
	private Map<String, String> error;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getInstrumentAliasName() {
		return instrumentAliasName;
	}
	public void setInstrumentAliasName(String instrumentAliasName) {
		this.instrumentAliasName = instrumentAliasName;
	}
	public String getInstrumentToken() {
		return instrumentToken;
	}
	public void setInstrumentToken(String instrumentToken) {
		this.instrumentToken = instrumentToken;
	}
	public String getBankSelectionCode() {
		return bankSelectionCode;
	}
	public void setBankSelectionCode(String bankSelectionCode) {
		this.bankSelectionCode = bankSelectionCode;
	}
	
	public Acss getaCS() {
		return aCS;
	}
	public void setaCS(Acss aCS) {
		this.aCS = aCS;
	}
	public Map<String, String> getoTP() {
		return oTP;
	}
	public void setoTP(Map<String, String> oTP) {
		this.oTP = oTP;
	}
	public PaymentTransaction getPaymentTransaction() {
		return paymentTransaction;
	}
	public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
		this.paymentTransaction = paymentTransaction;
	}
	public Map<String, String> getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Map<String, String> authentication) {
		this.authentication = authentication;
	}
	public Map<String, String> getError() {
		return error;
	}
	public void setError(Map<String, String> error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "PaymentMethod [token=" + token + ", instrumentAliasName=" + instrumentAliasName + ", instrumentToken="
				+ instrumentToken + ", bankSelectionCode=" + bankSelectionCode + ", aCS=" + aCS + ", oTP=" + oTP
				+ ", paymentTransaction=" + paymentTransaction + ", authentication=" + authentication + ", error="
				+ error + "]";
	}
	
	
	

}
