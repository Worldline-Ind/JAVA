package com.worldline.payment.service.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.worldline.payment.domain.MerchantData;
import com.worldline.payment.domain.TranscationResponse;
import com.worldline.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Value("${admin.json.data.file}")
	private String jsonFilePath;
	
	
	@Override
	public String saveAdmin(MerchantData adminPageDetails) {
		String errorMsg = null;
		// Creating Object of ObjectMapper define in Jakson Api
		ObjectMapper objectMapper = new ObjectMapper();
		FileWriter file = null;
		try {

			String jsonStr = objectMapper.writeValueAsString(adminPageDetails);

			// Displaying JSON String
			System.out.println(jsonStr);

			file = new FileWriter(jsonFilePath);
			file.write(jsonStr);

		} catch (IOException e) {
			e.printStackTrace();
			errorMsg = e.getMessage();
		} finally {
			if(file!=null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return errorMsg;
	}

	@Override
	public int generateRandomNumber() {
		SecureRandom random = new SecureRandom();

		return random.nextInt(999999999);
	}

	@Override
	public Map<String, String> convertToStringToHashMap(String merchantData) {
		Map<String,String> data = new HashMap<>();
		Pattern p = Pattern.compile("[\\{\\}\\=\\, ]++");
		String[] split = p.split(merchantData);
		for ( int i=1; i+2 <= split.length; i+=2 ){
			data.put( split[i], split[i+1] );
		}
		return data;
	}

	@Override
	public String getHashData(Map<String, String> configData) {
		
		JSONObject merchantobject = fetchDataFromFile();
		MerchantData merchantDataValue = new Gson().fromJson(merchantobject.toString(), MerchantData.class);
		String maxAmount =null;
		if(configData.get("amount")!= null && !configData.get("amount").isEmpty()) {
			maxAmount = String.valueOf(Integer.parseInt(configData.get("amount")) * 2);	
		}
		String debitStartDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String debitEndDate = addYearsToCurrentDate(30);
		String frequency = merchantDataValue.getFrequency();
		String amountType = merchantDataValue.getAmountType();
		if (convertStringToBool(merchantDataValue.getEnableSIDetailsAtMerchantEnd())) {
			debitEndDate = formateDate(configData.get("debitEndDate"));
			debitStartDate = formateDate(configData.get("debitStartDate"));
			maxAmount = configData.get("maxAmount");
			frequency = configData.get("frequency");
			amountType = configData.get("amountType");

		}
		System.out.println( "HashedData" +configData.get("MerchantCode") + "|" + configData.get("transactionID") + "|" + configData.get("amount")
				+ "|" + configData.get("accNo") + "|" + configData.get("custID") + "|" + configData.get("mobNo") + "|"
				+ configData.get("email") + "|" + debitStartDate + "|" + debitEndDate + "|" + maxAmount + "|"
				+ amountType + "|" + frequency + "|" + configData.get("cardNumber") + "|" + configData.get("expMonth")
				+ "|" + configData.get("expYear") + "|" + configData.get("cvvCode") + "|" + configData.get("SALT"));

		return configData.get("MerchantCode") + "|" + configData.get("transactionID") + "|" + configData.get("amount")
				+ "|" + configData.get("accNo") + "|" + configData.get("custID") + "|" + configData.get("mobNo") + "|"
				+ configData.get("email") + "|" + debitStartDate + "|" + debitEndDate + "|" + maxAmount + "|"
				+ amountType + "|" + frequency + "|" + configData.get("cardNumber") + "|" + configData.get("expMonth")
				+ "|" + configData.get("expYear") + "|" + configData.get("cvvCode") + "|" + configData.get("SALT");

	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getHashObject(String hashValue, Map<String, String> configData) {
		
		JSONObject merchantobject = fetchDataFromFile();

		MerchantData merchantDataValue = new Gson().fromJson(merchantobject.toString(), MerchantData.class);
		
		JSONObject obj = new JSONObject();
		
		
		JSONObject consumerDataObj = new JSONObject();
		consumerDataObj.put("deviceId","WEBSH2");
		consumerDataObj.put("token", hashValue);
		consumerDataObj.put("returnUrl", configData.get("ReturnUrl"));
		consumerDataObj.put("paymentMode",merchantDataValue.getPaymentMode());
		
		  String[] paymentArray = merchantDataValue.getPaymentModeOrder().split(",");
		 
		  consumerDataObj.put("paymentModeOrder",paymentArray);
		  
		String checkOut = null;
		if(convertStringToBool(merchantDataValue.getEmbedPaymentGatewayOnPage()))
				checkOut = "#worldline_embeded_popup";
		else
			checkOut = "";				
				
		consumerDataObj.put("checkoutElement", checkOut);
		consumerDataObj.put("merchantLogoUrl",merchantDataValue.getLogoURL());
		consumerDataObj.put("merchantId", configData.get("MerchantCode"));
		
		consumerDataObj.put("merchantMsg", merchantDataValue.getMerchantMessage());
		consumerDataObj.put("disclaimerMsg", merchantDataValue.getDisclaimerMessage());
		consumerDataObj.put("currency", configData.get("currency"));
		consumerDataObj.put("consumerId", configData.get("custID"));
		
		consumerDataObj.put("consumerMobileNo", configData.get("mobNo"));
		consumerDataObj.put("consumerEmailId", configData.get("email"));
		consumerDataObj.put("txnId", configData.get("transactionID"));
		
		
		JSONObject customStyleObj = new JSONObject();
		customStyleObj.put("PRIMARY_COLOR_CODE", merchantDataValue.getPrimaryColor());
		customStyleObj.put("SECONDARY_COLOR_CODE",merchantDataValue.getSecondaryColor() );
		customStyleObj.put("BUTTON_COLOR_CODE_1",merchantDataValue.getButtonColor1() );
		customStyleObj.put("BUTTON_COLOR_CODE_2",merchantDataValue.getButtonColor2());
		
		
		JSONArray itemArray = new JSONArray();
		JSONObject itemDataObj = new JSONObject();
		itemDataObj.put("itemId", configData.get("scheme"));
		itemDataObj.put("amount", configData.get("amount"));
		itemDataObj.put("comAmt", "0");

		itemArray.add(itemDataObj);

		consumerDataObj.put("items", itemArray);
		consumerDataObj.put("customStyle", customStyleObj);
		
		//Adding eMandate fields
		
		consumerDataObj.put("accountHolderName", configData.get("accountName"));
		consumerDataObj.put("accountNo", configData.get("accNo"));
		consumerDataObj.put("accountType", configData.get("accountType"));
		
		consumerDataObj.put("ifscCode", configData.get("ifscCode"));
		
		String debitStartDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		System.out.println("startDate"+debitStartDate);
	    int maxAmount = Integer.parseInt(configData.get("amount"))*2; 
 
	    
		//case when Si at merchant is disabled
		if(!convertStringToBool(merchantDataValue.getEnableSIDetailsAtMerchantEnd())) {
			consumerDataObj.put("maxAmount", maxAmount);
			consumerDataObj.put("debitEndDate", addYearsToCurrentDate(30));
			consumerDataObj.put("debitStartDate", debitStartDate);
		    consumerDataObj.put("amountType", merchantDataValue.getAmountType());			
			consumerDataObj.put("frequency", merchantDataValue.getFrequency());		

		} else {
			
				consumerDataObj.put("debitEndDate", formateDate(configData.get("debitEndDate")));
				consumerDataObj.put("debitStartDate", formateDate(configData.get("debitStartDate")));
				consumerDataObj.put("maxAmount", configData.get("maxAmount"));
				consumerDataObj.put("amountType", configData.get("amountType"));
				consumerDataObj.put("frequency", configData.get("frequency"));
			
		}
		
		obj.put("consumerData", consumerDataObj);
		
		JSONObject featureObj = new JSONObject();
		featureObj.put("showPGResponseMsg", true);
		featureObj.put("enableMerTxnDetails", true);
		featureObj.put("enableAbortResponse", true);
//		featureObj.put("enableSI", convertStringToBool(merchantDataValue.getEnableEmandate()));
		featureObj.put("enableSI", false);
		featureObj.put("enableNewWindowFlow", convertStringToBool(merchantDataValue.getEnableNewWindowFlow()));
		featureObj.put("enableExpressPay", convertStringToBool(merchantDataValue.getEnableExpressPay()));
		featureObj.put("enableInstrumentDeRegistration", convertStringToBool(merchantDataValue.getEnableInstrumentDeRegistration()));
		featureObj.put("hideSavedInstruments", convertStringToBool(merchantDataValue.getHideSavedInstruments()));
		featureObj.put("separateCardMode", convertStringToBool(merchantDataValue.getSeparateCardMode()));
		featureObj.put("payWithSavedInstrument", convertStringToBool(merchantDataValue.getSaveInstrument()));
		
		featureObj.put("enableDebitDay", convertStringToBool(merchantDataValue.getEnableDebitDay()));
		featureObj.put("enableTxnForNonSICards",convertStringToBool(merchantDataValue.getEnableTxnForNonSICards()));
		featureObj.put("expandSIDetails", false);
		featureObj.put("hideSIConfirmation", convertStringToBool(merchantDataValue.getHideSIConfirmation()));
		//this is present
		featureObj.put("hideSIDetails", false);
		
		featureObj.put("showAllModesWithSI", convertStringToBool(merchantDataValue.getShowAllModesWithSI()));
		featureObj.put("showSIConfirmation", convertStringToBool(merchantDataValue.getShowSIConfirmation()));
		featureObj.put("showSIResponseMsg", convertStringToBool(merchantDataValue.getShowSIResponseMsg()));
		
		featureObj.put("siDetailsAtMerchantEnd", convertStringToBool(merchantDataValue.getEnableSIDetailsAtMerchantEnd()));
		
		//add feature to a object
		
		obj.put("features", featureObj);
		
		System.out.println("json object:"+obj);
			
		
		return obj;
	}

	@Override
	public String encryptedHash(String dataToHashed) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");

			byte[] messageDigest = md.digest(dataToHashed.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return hashtext;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	 
	boolean convertStringToBool(String data) {

		return Boolean.valueOf(data);
		

	}

	@Override
	public String fetchApiResponse(String url, JSONObject obj) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);
		return restTemplate.postForObject(url, entity, String.class);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestFortranscation(String[] data, MerchantData merchantData) {

		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());

		obj.put("merchant", identifierObj);
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("dateTime", data[8]);
		deviceIdentifierObj.put("token", data[5]);
		deviceIdentifierObj.put("requestType", "S");

		obj.put("transaction", deviceIdentifierObj);

		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForOfflineVerification(Map<String, String> configData, MerchantData merchantData) {
		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", identifierObj);
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("deviceIdentifier", "S");
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("dateTime", configData.get("date"));
		deviceIdentifierObj.put("identifier", configData.get("merchantRefNo"));
		deviceIdentifierObj.put("requestType", "O");
		obj.put("transaction", deviceIdentifierObj);

		return obj;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForRefund(Map<String, String> configData, MerchantData merchantData) {
		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", identifierObj);
		JSONObject cartObject = new JSONObject();
		obj.put("cart", cartObject);
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("deviceIdentifier", "S");
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("amount", configData.get("amount"));
		deviceIdentifierObj.put("token", configData.get("token"));
		deviceIdentifierObj.put("dateTime", configData.get("date"));
		deviceIdentifierObj.put("requestType", "R");
		obj.put("transaction", deviceIdentifierObj);

		return obj;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TranscationResponse> getResponseListForReconciliation(Map<String, String> configData, MerchantData merchantData) {
		
		String transactionIds = configData.get("merchantRefNo").trim();
		List<String> transactionIdList = Arrays.asList(transactionIds.split(","));
		LocalDate fromDate = LocalDate.parse(configData.get("fromDate"));
		LocalDate toDate = LocalDate.parse(configData.get("toDate"));
		List<TranscationResponse> transactionResponseList = new ArrayList<>();
		for(String transactionId: transactionIdList) {
			List<LocalDate> listOfDates = getDatesBetween(fromDate, toDate);
			for(LocalDate date: listOfDates) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY"); 
				String dateTime = formatter.format(date);
				JSONObject obj = new JSONObject();
				JSONObject identifierObj = new JSONObject();
				identifierObj.put("identifier", merchantData.getMerchantCode());
				obj.put("merchant", identifierObj);
				JSONObject deviceIdentifierObj = new JSONObject();
				deviceIdentifierObj.put("deviceIdentifier", "S");
				deviceIdentifierObj.put("currency", merchantData.getCurrency());
				deviceIdentifierObj.put("dateTime", dateTime);
				deviceIdentifierObj.put("identifier", transactionId);
				deviceIdentifierObj.put("requestType", "O");
				obj.put("transaction", deviceIdentifierObj);
				
				String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
				String dualVerificationResult = fetchApiResponse(liveUrl, obj);
				TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
						TranscationResponse.class);
				if(!transcationResponse.getPaymentMethod().getPaymentTransaction().getErrorMessage().equalsIgnoreCase("Transaction Not Found")&& 
						!transcationResponse.getPaymentMethod().getPaymentTransaction().getStatusCode().equals("9999")) {
					transactionResponseList.add(transcationResponse);
					break;
				}
			}
		}
		return transactionResponseList;
	}
	
	public static List<LocalDate> getDatesBetween(
			  LocalDate startDate, LocalDate endDate) { 
			 
			    long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate); 
			    return IntStream.iterate(0, i -> i + 1)
			      .limit(numOfDaysBetween)
			      .mapToObj(i -> startDate.plusDays(i))
			      .collect(Collectors.toList()); 
			}

			@Override
		public JSONObject fetchDataFromFile(){

			JSONParser parser = new JSONParser();
			FileReader fr = null;
			try {
					fr = new FileReader(jsonFilePath);
				return (JSONObject) parser.parse(fr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
			}
			
			public String addYearsToCurrentDate(int years) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.YEAR, years); // Where n is int
				Date debitEndDate = cal.getTime();

				return new SimpleDateFormat("dd-MM-yyyy").format(debitEndDate);

			}
			
			public String formateDate(String dateToFormated) {	
				try {
					SimpleDateFormat  simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = simpleFormatter.parse(dateToFormated); 
					return new SimpleDateFormat("dd-MM-yyyy").format(date);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			public String setStatusMessageForTranscation(String message) {
				if ("S".equals(message))
					return "Success";
				else if ("I".equals(message))
					return "Initiated ";
				else if ("F".equals(message))
					return "Failure";
				else
					return "A";
			}

		}
