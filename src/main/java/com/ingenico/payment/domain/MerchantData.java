package com.ingenico.payment.domain;

import java.io.Serializable;

public class MerchantData implements Serializable{
	
	 private String utf8;
	 private String authenticityToken; 
	 private String merchantCode;
	 private String merchantSchemeCode;
	 private String salt;
	 private String currency;
	 private String typeOfPayment;
	 private String primaryColor;
	 private String secondaryColor;
	 private String buttonColor1;
	 private String buttonColor2;
	 private String logoURL;
	 private String enableExpressPay;
	 private String separateCardMode;
	 private String enableNewWindowFlow;
	 private String merchantMessage;
	 private String disclaimerMessage;
	 private String paymentMode;
	 private String paymentModeOrder;
	 private String enableInstrumentDeRegistration;
	 private String transactionType;
	 private String hideSavedInstruments;
	 private String saveInstrument;
	 private String displayTransactionMessageOnPopup;
	 private String embedPaymentGatewayOnPage;
	 private String commit;
	 private String controller;
	 private String action;
	 private String enableEmandate;
	 private String hideSIDetails;
	 private String hideSIConfirmation;
	 private String expandSIDetails;
	 private String enableDebitDay;
	 private String showSIResponseMsg;
	 private String showSIConfirmation;
	 private String enableTxnForNonSICards;
	 private String showAllModesWithSI;
	 private String enableSIDetailsAtMerchantEnd;
	 private String amountType;
	 private String frequency;
	 
	
	public MerchantData(String utf8, String authenticityToken, String merchantCode, String merchantSchemeCode,
			String salt, String currency, String typeOfPayment, String primaryColor, String secondaryColor,
			String buttonColor1, String buttonColor2, String logoURL, String enableExpressPay, String separateCardMode,
			String enableNewWindowFlow, String merchantMessage, String disclaimerMessage, String paymentMode,
			String paymentModeOrder, String enableInstrumentDeRegistration, String transactionType,
			String hideSavedInstruments, String saveInstrument, String displayTransactionMessageOnPopup,
			String embedPaymentGatewayOnPage, String commit, String controller, String action, String enableEmandate,
			String hideSIDetails, String hideSIConfirmation, String expandSIDetails, String enableDebitDay,
			String showSIResponseMsg, String showSIConfirmation, String enableTxnForNonSICards,
			String showAllModesWithSI, String enableSIDetailsAtMerchantEnd, String amountType, String frequency) {
		super();
		this.utf8 = utf8;
		this.authenticityToken = authenticityToken;
		this.merchantCode = merchantCode;
		this.merchantSchemeCode = merchantSchemeCode;
		this.salt = salt;
		this.currency = currency;
		this.typeOfPayment = typeOfPayment;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.buttonColor1 = buttonColor1;
		this.buttonColor2 = buttonColor2;
		this.logoURL = logoURL;
		this.enableExpressPay = enableExpressPay;
		this.separateCardMode = separateCardMode;
		this.enableNewWindowFlow = enableNewWindowFlow;
		this.merchantMessage = merchantMessage;
		this.disclaimerMessage = disclaimerMessage;
		this.paymentMode = paymentMode;
		this.paymentModeOrder = paymentModeOrder;
		this.enableInstrumentDeRegistration = enableInstrumentDeRegistration;
		this.transactionType = transactionType;
		this.hideSavedInstruments = hideSavedInstruments;
		this.saveInstrument = saveInstrument;
		this.displayTransactionMessageOnPopup = displayTransactionMessageOnPopup;
		this.embedPaymentGatewayOnPage = embedPaymentGatewayOnPage;
		this.commit = commit;
		this.controller = controller;
		this.action = action;
		this.enableEmandate = enableEmandate;
		this.hideSIDetails = hideSIDetails;
		this.hideSIConfirmation = hideSIConfirmation;
		this.expandSIDetails = expandSIDetails;
		this.enableDebitDay = enableDebitDay;
		this.showSIResponseMsg = showSIResponseMsg;
		this.showSIConfirmation = showSIConfirmation;
		this.enableTxnForNonSICards = enableTxnForNonSICards;
		this.showAllModesWithSI = showAllModesWithSI;
		this.enableSIDetailsAtMerchantEnd = enableSIDetailsAtMerchantEnd;
		this.amountType = amountType;
		this.frequency = frequency;
	}
	public String getUtf8() {
		return utf8;
	}
	public void setUtf8(String utf8) {
		this.utf8 = utf8;
	}
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getMerchantSchemeCode() {
		return merchantSchemeCode;
	}
	public void setMerchantSchemeCode(String merchantSchemeCode) {
		this.merchantSchemeCode = merchantSchemeCode;
	}
	public String getAuthenticityToken() {
		return authenticityToken;
	}
	public void setAuthenticityToken(String authenticityToken) {
		this.authenticityToken = authenticityToken;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTypeOfPayment() {
		return typeOfPayment;
	}
	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}
	public String getPrimaryColor() {
		return primaryColor;
	}
	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}
	public String getSecondaryColor() {
		return secondaryColor;
	}
	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}
	public String getButtonColor1() {
		return buttonColor1;
	}
	public void setButtonColor1(String buttonColor1) {
		this.buttonColor1 = buttonColor1;
	}
	public String getButtonColor2() {
		return buttonColor2;
	}
	public void setButtonColor2(String buttonColor2) {
		this.buttonColor2 = buttonColor2;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public String getEnableExpressPay() {
		return enableExpressPay;
	}
	public void setEnableExpressPay(String enableExpressPay) {
		this.enableExpressPay = enableExpressPay;
	}
	public String getSeparateCardMode() {
		return separateCardMode;
	}
	public void setSeparateCardMode(String separateCardMode) {
		this.separateCardMode = separateCardMode;
	}
	public String getEnableNewWindowFlow() {
		return enableNewWindowFlow;
	}
	public void setEnableNewWindowFlow(String enableNewWindowFlow) {
		this.enableNewWindowFlow = enableNewWindowFlow;
	}
	public String getMerchantMessage() {
		return merchantMessage;
	}
	public void setMerchantMessage(String merchantMessage) {
		this.merchantMessage = merchantMessage;
	}
	public String getDisclaimerMessage() {
		return disclaimerMessage;
	}
	public void setDisclaimerMessage(String disclaimerMessage) {
		this.disclaimerMessage = disclaimerMessage;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentModeOrder() {
		return paymentModeOrder;
	}
	public void setPaymentModeOrder(String paymentModeOrder) {
		this.paymentModeOrder = paymentModeOrder;
	}
	public String getEnableInstrumentDeRegistration() {
		return enableInstrumentDeRegistration;
	}
	public void setEnableInstrumentDeRegistration(String enableInstrumentDeRegistration) {
		this.enableInstrumentDeRegistration = enableInstrumentDeRegistration;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getHideSavedInstruments() {
		return hideSavedInstruments;
	}
	public void setHideSavedInstruments(String hideSavedInstruments) {
		this.hideSavedInstruments = hideSavedInstruments;
	}
	public String getSaveInstrument() {
		return saveInstrument;
	}
	public void setSaveInstrument(String saveInstrument) {
		this.saveInstrument = saveInstrument;
	}
	public String getDisplayTransactionMessageOnPopup() {
		return displayTransactionMessageOnPopup;
	}
	public void setDisplayTransactionMessageOnPopup(String displayTransactionMessageOnPopup) {
		this.displayTransactionMessageOnPopup = displayTransactionMessageOnPopup;
	}
	public String getEmbedPaymentGatewayOnPage() {
		return embedPaymentGatewayOnPage;
	}
	public void setEmbedPaymentGatewayOnPage(String embedPaymentGatewayOnPage) {
		this.embedPaymentGatewayOnPage = embedPaymentGatewayOnPage;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getEnableEmandate() {
		return enableEmandate;
	}
	public void setEnableEmandate(String enableEmandate) {
		this.enableEmandate = enableEmandate;
	}
	public String getHideSIDetails() {
		return hideSIDetails;
	}
	public void setHideSIDetails(String hideSIDetails) {
		this.hideSIDetails = hideSIDetails;
	}
	public String getHideSIConfirmation() {
		return hideSIConfirmation;
	}
	public void setHideSIConfirmation(String hideSIConfirmation) {
		this.hideSIConfirmation = hideSIConfirmation;
	}
	public String getExpandSIDetails() {
		return expandSIDetails;
	}
	public void setExpandSIDetails(String expandSIDetails) {
		this.expandSIDetails = expandSIDetails;
	}
	public String getEnableDebitDay() {
		return enableDebitDay;
	}
	public void setEnableDebitDay(String enableDebitDay) {
		this.enableDebitDay = enableDebitDay;
	}
	public String getShowSIResponseMsg() {
		return showSIResponseMsg;
	}
	public void setShowSIResponseMsg(String showSIResponseMsg) {
		this.showSIResponseMsg = showSIResponseMsg;
	}
	public String getShowSIConfirmation() {
		return showSIConfirmation;
	}
	public void setShowSIConfirmation(String showSIConfirmation) {
		this.showSIConfirmation = showSIConfirmation;
	}
	public String getEnableTxnForNonSICards() {
		return enableTxnForNonSICards;
	}
	public void setEnableTxnForNonSICards(String enableTxnForNonSICards) {
		this.enableTxnForNonSICards = enableTxnForNonSICards;
	}
	public String getShowAllModesWithSI() {
		return showAllModesWithSI;
	}
	public void setShowAllModesWithSI(String showAllModesWithSI) {
		this.showAllModesWithSI = showAllModesWithSI;
	}
	public String getEnableSIDetailsAtMerchantEnd() {
		return enableSIDetailsAtMerchantEnd;
	}
	public void setEnableSIDetailsAtMerchantEnd(String enableSIDetailsAtMerchantEnd) {
		this.enableSIDetailsAtMerchantEnd = enableSIDetailsAtMerchantEnd;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "MerchantData [utf8=" + utf8 + ", authenticityToken=" + authenticityToken + ", merchantCode="
				+ merchantCode + ", merchantSchemeCode=" + merchantSchemeCode + ", salt=" + salt + ", currency="
				+ currency + ", typeOfPayment=" + typeOfPayment + ", primaryColor=" + primaryColor + ", secondaryColor="
				+ secondaryColor + ", buttonColor1=" + buttonColor1 + ", buttonColor2=" + buttonColor2 + ", logoURL="
				+ logoURL + ", enableExpressPay=" + enableExpressPay + ", separateCardMode=" + separateCardMode
				+ ", enableNewWindowFlow=" + enableNewWindowFlow + ", merchantMessage=" + merchantMessage
				+ ", disclaimerMessage=" + disclaimerMessage + ", paymentMode=" + paymentMode + ", paymentModeOrder="
				+ paymentModeOrder + ", enableInstrumentDeRegistration=" + enableInstrumentDeRegistration
				+ ", transactionType=" + transactionType + ", hideSavedInstruments=" + hideSavedInstruments
				+ ", saveInstrument=" + saveInstrument + ", displayTransactionMessageOnPopup="
				+ displayTransactionMessageOnPopup + ", embedPaymentGatewayOnPage=" + embedPaymentGatewayOnPage
				+ ", commit=" + commit + ", controller=" + controller + ", action=" + action + ", enableEmandate="
				+ enableEmandate + ", hideSIDetails=" + hideSIDetails + ", hideSIConfirmation=" + hideSIConfirmation
				+ ", expandSIDetails=" + expandSIDetails + ", enableDebitDay=" + enableDebitDay + ", showSIResponseMsg="
				+ showSIResponseMsg + ", showSIConfirmation=" + showSIConfirmation + ", enableTxnForNonSICards="
				+ enableTxnForNonSICards + ", showAllModesWithSI=" + showAllModesWithSI
				+ ", enableSIDetailsAtMerchantEnd=" + enableSIDetailsAtMerchantEnd + ", amountType=" + amountType
				+ ", frequency=" + frequency + "]";
	}
	 
}
