package com.worldline.payment.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldline.payment.domain.MerchantData;
import com.worldline.payment.service.EmandateService;
import com.worldline.payment.service.PaymentService;

@Service
public class EmandateServiceImpl implements EmandateService {
	

	@Autowired
	private PaymentService paymentService;

	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForMandateVerification(Map<String, String> configData, MerchantData merchantData) {
		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", identifierObj);
		
		JSONObject paymentObject = new JSONObject();
		JSONObject instructionObj = new JSONObject();
		paymentObject.put("instruction", instructionObj);
		obj.put("payment", paymentObject);
		
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("deviceIdentifier", "S");
		deviceIdentifierObj.put("type", configData.get("type"));
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("identifier", configData.get("merchantTransactionId"));
		
		LocalDate date = LocalDate.parse(configData.get("transactionDate"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY"); 
		String dateTime = formatter.format(date);
		
		deviceIdentifierObj.put("dateTime", dateTime);
		deviceIdentifierObj.put("subType", "002");
		deviceIdentifierObj.put("requestType", "TSI");
		obj.put("transaction", deviceIdentifierObj);
		
		JSONObject consumerObj = new JSONObject();
		consumerObj.put("identifier", configData.get("consumerTransactionId"));
		obj.put("consumer", consumerObj);

		return obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public JSONObject createRequestForTransactionScheduling(Map<String, String> configData, MerchantData merchantData) {

		JSONObject obj = new JSONObject();

		JSONObject merchantObj = new JSONObject();
		merchantObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", merchantObj);
		
		JSONObject paymentObject = new JSONObject();
		JSONObject instrumentObj = new JSONObject();
		instrumentObj.put("identifier", merchantData.getMerchantSchemeCode());
		
		JSONObject instructionObj = new JSONObject();
		
		LocalDate endDate = LocalDate.parse(configData.get("transactionDate"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYYYY"); 
		String endDateTime = formatter.format(endDate);
		
		instructionObj.put("amount", configData.get("amount"));
		instructionObj.put("endDateTime", endDateTime);
		instructionObj.put("identifier", configData.get("mandateRegistrationId"));
		
		paymentObject.put("instrument", instrumentObj);
		paymentObject.put("instruction", instructionObj);
		obj.put("payment", paymentObject);
		
		JSONObject transactionObj = new JSONObject();
		transactionObj.put("deviceIdentifier", "S");
		transactionObj.put("type", configData.get("transactionType"));
		transactionObj.put("currency", merchantData.getCurrency());
		
		int transcationId = paymentService.generateRandomNumber();
		
		transactionObj.put("identifier", transcationId);
		transactionObj.put("dateTime", configData.get("transactionDate"));
		transactionObj.put("subType", "003");
		transactionObj.put("requestType", "TSI");
		obj.put("transaction", transactionObj);
		
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForTranscationVerification(Map<String, String> configData,
			MerchantData merchantData) {
		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", identifierObj);
		
		JSONObject paymentObject = new JSONObject();
		JSONObject instructionObj = new JSONObject();
		paymentObject.put("instruction", instructionObj);
		obj.put("payment", paymentObject);
		
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("deviceIdentifier", "S");
		deviceIdentifierObj.put("type", "002");
		deviceIdentifierObj.put("currency", merchantData.getCurrency());	
		deviceIdentifierObj.put("identifier", configData.get("merchantTransactionID"));
		deviceIdentifierObj.put("dateTime", configData.get("transactionDate"));
		deviceIdentifierObj.put("subType", "004");
		deviceIdentifierObj.put("requestType", "TSI");
		obj.put("transaction", deviceIdentifierObj);
		
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForStopPayment(Map<String, String> configData, MerchantData merchantData) {
		
		JSONObject obj = new JSONObject();
		
		JSONObject merchantObj = new JSONObject();
		merchantObj.put("webhookEndpointURL", "");
		merchantObj.put("responseType", "");
		merchantObj.put("responseEndpointURL", "");
		merchantObj.put("description", "");
		merchantObj.put("identifier", merchantData.getMerchantCode());
		merchantObj.put("webhookType", "");
		
		obj.put("merchant", merchantObj);
		
		
		JSONObject cartObj = new JSONObject();
		cartObj.put("reference", "");
		cartObj.put("identifier", "");
		cartObj.put("description", "");
		cartObj.put("Amount", "");
		
		
		//Creating a json array
	     JSONArray array = new JSONArray();
	     
	     JSONObject itemObj = new JSONObject();
	     itemObj.put("description", "");
	     itemObj.put("providerIdentifier", "");
	     itemObj.put("surchargeOrDiscountAmount", "");
	     itemObj.put("amount", "");
	     itemObj.put("comAmt", "");
	     itemObj.put("sKU", "");
	     itemObj.put("reference", "");
	     itemObj.put("identifier", "");
	     
	     array.add(itemObj);
	     
	     cartObj.put("item",array);
	     
	     obj.put("cart", cartObj);
	     
	     JSONObject paymentObj = new JSONObject();
	     
	     JSONObject paymentMethodObj = new JSONObject();
	     paymentMethodObj.put("token", "");
	     paymentMethodObj.put("type", "");
	     
	     paymentObj.put("method", paymentMethodObj);
	     
	     
	     JSONObject paymentInstrumentObj = new JSONObject();
	     paymentInstrumentObj.put("provider", "");
	     paymentInstrumentObj.put("iFSC", "");
	     paymentInstrumentObj.put("bIC", "");
	     paymentInstrumentObj.put("type", "");
	     paymentInstrumentObj.put("action", "");
	     paymentInstrumentObj.put("mICR", "");
	     paymentInstrumentObj.put("verificationCode", "");
	     paymentInstrumentObj.put("iBAN", "");
	     paymentInstrumentObj.put("processor", "");
	     paymentInstrumentObj.put("alias", "");
	     paymentInstrumentObj.put("identifier", "");
	     paymentInstrumentObj.put("token", "");
	     paymentInstrumentObj.put("subType", "");
	     paymentInstrumentObj.put("issuer", "");
	     paymentInstrumentObj.put("acquirer", "");
	         
	     
	     JSONObject instrumentExpiryObj = new JSONObject();
	     
	     instrumentExpiryObj.put("year", "");
	     instrumentExpiryObj.put("month", "");
	     instrumentExpiryObj.put("dateTime", "");
	   
	     paymentInstrumentObj.put("expiry", instrumentExpiryObj);


	     JSONObject instrumentHolderObj = new JSONObject();
	     
	     instrumentHolderObj.put("name", "");
	     JSONObject addressObj = new JSONObject();
	     addressObj.put("country", "");
	     addressObj.put("street", "");
	     addressObj.put("state", "");
	     addressObj.put("city", "");
	     addressObj.put("zipCode", "");
	     addressObj.put("county", "");
	     
	     instrumentHolderObj.put("address", addressObj);
	     
	     paymentInstrumentObj.put("holder", instrumentHolderObj);

	     
	     
	     JSONObject instrumentIssuanceObj = new JSONObject();
	     
	     instrumentIssuanceObj.put("year", "");
	     instrumentIssuanceObj.put("month", "");
	     instrumentIssuanceObj.put("dateTime", "");
	     
	     paymentInstrumentObj.put("issuance", instrumentIssuanceObj);
	    
	     
	     
	     JSONObject instrumentAuthenticationObj = new JSONObject();
	     
	     instrumentAuthenticationObj.put("token", "");
	     instrumentAuthenticationObj.put("type", "");
	     instrumentAuthenticationObj.put("subType", "");
	     
	     paymentInstrumentObj.put("authentication", instrumentAuthenticationObj);
	     
	     paymentObj.put("instrument", paymentInstrumentObj);
	     
	     
	     JSONObject paymentInstructionObj = new JSONObject();
	     
	     paymentInstructionObj.put("occurrence", "");
	     paymentInstructionObj.put("amount", "");
	     paymentInstructionObj.put("frequency", "");
	     paymentInstructionObj.put("type", "");
	     paymentInstructionObj.put("description", "");
	     paymentInstructionObj.put("action", "");
	     paymentInstructionObj.put("limit", "");
	     paymentInstructionObj.put("endDateTime", "");
	     paymentInstructionObj.put("identifier", "");
	     paymentInstructionObj.put("reference", "");
	     paymentInstructionObj.put("startDateTime", "");
	     paymentInstructionObj.put("validity", "");
	     
	     paymentObj.put("instruction", paymentInstructionObj);
	     
	     obj.put("payment", paymentObj);
	    
	     
	     JSONObject transcationObj = new JSONObject();
	     transcationObj.put("deviceIdentifier", "S");
	     transcationObj.put("smsSending", "");
	     transcationObj.put("amount", "");
	     transcationObj.put("forced3DSCall ", "");
	     transcationObj.put("endDateTime", "");
	     transcationObj.put("type", "001");
	     transcationObj.put("description", "");
	     transcationObj.put("currency", merchantData.getCurrency());
	     transcationObj.put("limit", "");
	     transcationObj.put("isRegistration", "");
	     transcationObj.put("identifier",paymentService.generateRandomNumber() );
	    
	     transcationObj.put("dateTime", "");
	     transcationObj.put("token", configData.get("tpslTransactionID"));
	     transcationObj.put("securityToken", "");
	     transcationObj.put("subType", "006");
	     transcationObj.put("requestType", "TSI");
	     transcationObj.put("reference", "");
	     transcationObj.put("merchantInitiated", "");
	     transcationObj.put("merchantRefNo", "");
	     
	     obj.put("transaction", transcationObj);
	     
	    
	     JSONObject consumerObj = new JSONObject();
	     consumerObj.put("mobileNumber", "");
	     consumerObj.put("emailID", "");
	     consumerObj.put("identifier", "");
	     consumerObj.put("accountNo", "");
	    
	     obj.put("consumer", consumerObj);
		
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForMandateDeactivation(Map<String, String> configData, MerchantData merchantData) {
		
		JSONObject obj = new JSONObject();
		
		JSONObject merchantObj = new JSONObject();
		merchantObj.put("webhookEndpointURL", "");
		merchantObj.put("responseType", "");
		merchantObj.put("responseEndpointURL", "");
		merchantObj.put("description", "");
		merchantObj.put("identifier", merchantData.getMerchantCode());
		merchantObj.put("webhookType", "");
		
		obj.put("merchant", merchantObj);
		
		JSONObject cartObj = new JSONObject();
		cartObj.put("reference", "");
		cartObj.put("identifier", "");
		cartObj.put("description", "");
		cartObj.put("Amount", "");
		
		//Creating a json array
	     JSONArray array = new JSONArray();
	     
	     JSONObject itemObj = new JSONObject();
	     itemObj.put("description", "");
	     itemObj.put("providerIdentifier", "");
	     itemObj.put("surchargeOrDiscountAmount", "");
	     itemObj.put("amount", "");
	     itemObj.put("comAmt", "");
	     itemObj.put("sKU", "");
	     itemObj.put("reference", "");
	     itemObj.put("identifier", "");
	     
	     array.add(itemObj);
	     cartObj.put("item",array);
	     obj.put("cart", cartObj);
	     
	     JSONObject paymentObj = new JSONObject();
	     
	     JSONObject paymentMethodObj = new JSONObject();
	     paymentMethodObj.put("token", "");
	     paymentMethodObj.put("type", "");
	     
	     paymentObj.put("method", paymentMethodObj);
	     
	     JSONObject paymentInstrumentObj = new JSONObject();
	     paymentInstrumentObj.put("provider", "");
	     paymentInstrumentObj.put("iFSC", "");
	     paymentInstrumentObj.put("bIC", "");
	     paymentInstrumentObj.put("type", "");
	     paymentInstrumentObj.put("action", "");
	     paymentInstrumentObj.put("mICR", "");
	     paymentInstrumentObj.put("verificationCode", "");
	     paymentInstrumentObj.put("iBAN", "");
	     paymentInstrumentObj.put("processor", "");
	     paymentInstrumentObj.put("alias", "");
	     paymentInstrumentObj.put("identifier", "");
	     paymentInstrumentObj.put("token", "");
	     paymentInstrumentObj.put("subType", "");
	     paymentInstrumentObj.put("issuer", "");
	     paymentInstrumentObj.put("acquirer", "");
	     
	     JSONObject instrumentExpiryObj = new JSONObject();
	     
	     instrumentExpiryObj.put("year", "");
	     instrumentExpiryObj.put("month", "");
	     instrumentExpiryObj.put("dateTime", "");
	   
	     paymentInstrumentObj.put("expiry", instrumentExpiryObj);
	     
	     JSONObject instrumentHolderObj = new JSONObject();
	     
	     instrumentHolderObj.put("name", "");
	     JSONObject addressObj = new JSONObject();
	     addressObj.put("country", "");
	     addressObj.put("street", "");
	     addressObj.put("state", "");
	     addressObj.put("city", "");
	     addressObj.put("zipCode", "");
	     addressObj.put("county", "");
	     
	     instrumentHolderObj.put("address", addressObj);
	     
	     paymentInstrumentObj.put("holder", instrumentHolderObj);
	     
	     JSONObject instrumentIssuanceObj = new JSONObject();
	     
	     instrumentIssuanceObj.put("year", "");
	     instrumentIssuanceObj.put("month", "");
	     instrumentIssuanceObj.put("dateTime", "");
	     
	     paymentInstrumentObj.put("issuance", instrumentIssuanceObj);
	    
	     
	     
	     JSONObject instrumentAuthenticationObj = new JSONObject();
	     
	     instrumentAuthenticationObj.put("token", "");
	     instrumentAuthenticationObj.put("type", "");
	     instrumentAuthenticationObj.put("subType", "");
	     
	     paymentInstrumentObj.put("authentication", instrumentAuthenticationObj);
	     
	     paymentObj.put("instrument", paymentInstrumentObj);
	     
	     
	     JSONObject paymentInstructionObj = new JSONObject();
	     
	     paymentInstructionObj.put("occurrence", "");
	     paymentInstructionObj.put("amount", "");
	     paymentInstructionObj.put("frequency", "");
	     paymentInstructionObj.put("type", "");
	     paymentInstructionObj.put("description", "");
	     paymentInstructionObj.put("action", "");
	     paymentInstructionObj.put("limit", "");
	     paymentInstructionObj.put("endDateTime", "");
	     paymentInstructionObj.put("identifier", "");
	     paymentInstructionObj.put("reference", "");
	     paymentInstructionObj.put("startDateTime", "");
	     paymentInstructionObj.put("validity", "");
	     
	     paymentObj.put("instruction", paymentInstructionObj);
	     
	     obj.put("payment", paymentObj);
	    
	     
	     JSONObject transcationObj = new JSONObject();
	     transcationObj.put("deviceIdentifier", "S");
	     transcationObj.put("smsSending", "");
	     transcationObj.put("amount", "");
	     transcationObj.put("forced3DSCall ", "");
	     transcationObj.put("endDateTime", "");
	     transcationObj.put("type", "001");
	     transcationObj.put("description", "");
	     transcationObj.put("currency", merchantData.getCurrency());
	     transcationObj.put("limit", "");
	     transcationObj.put("isRegistration", "");
	     transcationObj.put("identifier",paymentService.generateRandomNumber());
	    
	     transcationObj.put("dateTime", "");
	     transcationObj.put("token", configData.get("mandateRegistrationID"));
	     transcationObj.put("securityToken", "");
	     transcationObj.put("subType", "005");
	     transcationObj.put("requestType", "TSI");
	     transcationObj.put("reference", "");
	     transcationObj.put("merchantInitiated", "");
	     transcationObj.put("merchantRefNo", "");
	     
	     obj.put("transaction", transcationObj);
	     
	    
	     JSONObject consumerObj = new JSONObject();
	     consumerObj.put("mobileNumber", "");
	     consumerObj.put("emailID", "");
	     consumerObj.put("identifier", "");
	     consumerObj.put("accountNo", "");
	    
	     obj.put("consumer", consumerObj);
	     
		return obj;
	}

}
