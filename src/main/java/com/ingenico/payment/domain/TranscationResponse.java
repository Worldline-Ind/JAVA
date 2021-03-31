package com.ingenico.payment.domain;

public class TranscationResponse {
	
	private String merchantCode;
	private String merchantTransactionIdentifier;
	private String merchantTransactionRequestType;
	private String transactionState;
	private String responseType;
	private String merchantAdditionalDetails;
	private String error;
	
	private PaymentMethod paymentMethod;

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMerchantTransactionIdentifier() {
		return merchantTransactionIdentifier;
	}

	public void setMerchantTransactionIdentifier(String merchantTransactionIdentifier) {
		this.merchantTransactionIdentifier = merchantTransactionIdentifier;
	}

	public String getMerchantTransactionRequestType() {
		return merchantTransactionRequestType;
	}

	public void setMerchantTransactionRequestType(String merchantTransactionRequestType) {
		this.merchantTransactionRequestType = merchantTransactionRequestType;
	}

	public String getTransactionState() {
		return transactionState;
	}

	public void setTransactionState(String transactionState) {
		this.transactionState = transactionState;
	}

	public String getMerchantAdditionalDetails() {
		return merchantAdditionalDetails;
	}

	public void setMerchantAdditionalDetails(String merchantAdditionalDetails) {
		this.merchantAdditionalDetails = merchantAdditionalDetails;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	@Override
	public String toString() {
		return "TranscationResponse [merchantCode=" + merchantCode + ", merchantTransactionIdentifier="
				+ merchantTransactionIdentifier + ", merchantTransactionRequestType=" + merchantTransactionRequestType
				+ ", transactionState=" + transactionState + ", merchantAdditionalDetails=" + merchantAdditionalDetails
				+ ", error=" + error + ", paymenthod=" + paymentMethod + "]";
	}
	
     

}
