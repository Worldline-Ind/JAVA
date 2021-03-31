package com.ingenico.payment.domain;

import java.util.Map;

public class PaymentTransaction {
	
	private String amount; 
	private String balanceAmount; 
	private String bankReferenceIdentifier; 
	private String errorMessage; 
	private String identifier; 
	private String refundIdentifier;
	private String statusCode;
	private String statusMessage; 
	private String dateTime;
	private Map<String, String> instruction;
        
	private String reference; 
	private String accountNo;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getBankReferenceIdentifier() {
		return bankReferenceIdentifier;
	}
	public void setBankReferenceIdentifier(String bankReferenceIdentifier) {
		this.bankReferenceIdentifier = bankReferenceIdentifier;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getRefundIdentifier() {
		return refundIdentifier;
	}
	public void setRefundIdentifier(String refundIdentifier) {
		this.refundIdentifier = refundIdentifier;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Map<String, String> getInstruction() {
		return instruction;
	}
	public void setInstruction(Map<String, String> instruction) {
		this.instruction = instruction;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "PaymentTransaction [amount=" + amount + ", balanceAmount=" + balanceAmount
				+ ", bankReferenceIdentifier=" + bankReferenceIdentifier + ", errorMessage=" + errorMessage
				+ ", identifier=" + identifier + ", refundIdentifier=" + refundIdentifier + ", statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + ", instruction=" + instruction + ", reference=" + reference
				+ ", accountNo=" + accountNo + "]";
	} 
	
	
	


}
