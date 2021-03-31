package com.ingenico.payment.service;

import java.util.Map;

import org.json.simple.JSONObject;

import com.ingenico.payment.domain.MerchantData;

public interface EmandateService {

	JSONObject createRequestForMandateVerification(Map<String, String> configData, MerchantData merchantData);
	
	JSONObject createRequestForTranscationVerification(Map<String, String> configData, MerchantData merchantData);
	
	JSONObject createRequestForStopPayment(Map<String, String> configData, MerchantData merchantData);

	JSONObject createRequestForTransactionScheduling(Map<String, String> configData, MerchantData merchantData);

	JSONObject createRequestForMandateDeactivation(Map<String, String> configData, MerchantData merchantData);

}
