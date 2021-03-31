package com.ingenico.payment.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.ingenico.payment.domain.MerchantData;
import com.ingenico.payment.domain.TranscationResponse;

public interface PaymentService {
	
	String saveAdmin(MerchantData merchantData);
	
	int generateRandomNumber();
	
	Map <String,String> convertToStringToHashMap(String merchantData);
	
	String getHashData(Map<String,String> configData);
	
	String encryptedHash(String dataToHashed);
	
	JSONObject getHashObject(String hashValue,Map<String,String> configData);
	
	String fetchApiResponse(String url,JSONObject obj);
	
	JSONObject createRequestFortranscation(String[]data,MerchantData merchantData);
	
	JSONObject createRequestForOfflineVerification(Map<String,String> configData,MerchantData merchantData);

	JSONObject createRequestForRefund(Map<String, String> configData, MerchantData merchantData);

	List<TranscationResponse> getResponseListForReconciliation(Map<String, String> configData, MerchantData merchantData);
	
	JSONObject fetchDataFromFile();
	
	String setStatusMessageForTranscation(String message);

}
