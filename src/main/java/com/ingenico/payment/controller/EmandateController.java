package com.ingenico.payment.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ingenico.payment.domain.MerchantData;
import com.ingenico.payment.domain.TranscationResponse;
import com.ingenico.payment.service.EmandateService;
import com.ingenico.payment.service.PaymentService;

@Controller
@RequestMapping("/emandate-si")
public class EmandateController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private EmandateService emandateService;

	@GetMapping("/mandate-verification")
	@ResponseBody
	public ModelAndView mandateVerification() {
		return new ModelAndView("MandateVerification");

	}
	

	@PostMapping("/mandate-verification")
	@ResponseBody
	public ModelAndView mandateVerificationHandler(HttpServletRequest request, @RequestParam Map<String, String> configData) {
		JSONObject jsonObject = null;
		try {
			jsonObject = paymentService.fetchDataFromFile();

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);
			JSONObject obj = emandateService.createRequestForMandateVerification(configData, merchantData);
			String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
			String dualVerificationResult = paymentService.fetchApiResponse(liveUrl, obj);
			TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
					TranscationResponse.class);
			ModelAndView modelAndView = new ModelAndView("MandateVerification");
			modelAndView.addObject("response", transcationResponse);
			return modelAndView;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return null;
	}
	
	@GetMapping("/transactionVerification")
	@ResponseBody
	public ModelAndView transactionVerification() {
		return new ModelAndView("TransactionVerification");

	}
	
	
	@PostMapping("/transactionVerification")
	@ResponseBody
	public ModelAndView transactionVerify(HttpServletRequest request, @RequestParam Map<String, String> configData) {
		JSONObject jsonObject = null;
		try {
		jsonObject = paymentService.fetchDataFromFile();

		MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);
		JSONObject obj = emandateService.createRequestForTranscationVerification(configData, merchantData);
		String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
		String response = paymentService.fetchApiResponse(liveUrl, obj);
		TranscationResponse transcationResponse = new Gson().fromJson(response,
				TranscationResponse.class);
		
		String statusCode =transcationResponse.getPaymentMethod().getPaymentTransaction().getStatusMessage();
		String statusMessage = paymentService.setStatusMessageForTranscation(statusCode);
		transcationResponse.getPaymentMethod().getPaymentTransaction().setStatusMessage(statusMessage);
		
		ModelAndView modelAndView = new ModelAndView("TransactionVerification");
		modelAndView.addObject("response", transcationResponse);
		return modelAndView;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	@GetMapping("/stopPayment")
	@ResponseBody
	public ModelAndView getStopPayment() {
		return new ModelAndView("StopPayment");

	}
	
	@PostMapping("/stopPayment")
	@ResponseBody
	public ModelAndView stopPayment(HttpServletRequest request, @RequestParam Map<String, String> configData) {
		JSONObject jsonObject = null;
		try {
		jsonObject = paymentService.fetchDataFromFile();

		MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);
		JSONObject obj = emandateService.createRequestForStopPayment(configData, merchantData);
		String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
		String dualVerificationResult = paymentService.fetchApiResponse(liveUrl, obj);
		TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
				TranscationResponse.class);
		System.out.println("transcationResponse:"+transcationResponse);
		ModelAndView modelAndView = new ModelAndView("StopPayment");
		modelAndView.addObject("response", transcationResponse);
		return modelAndView;
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return null;

	}

	
	@GetMapping("/transaction-scheduling")
	@ResponseBody
	public ModelAndView transactionScheduling() {
		return new ModelAndView("TransactionScheduling");

	}
	
	@PostMapping("/transaction-scheduling")
	@ResponseBody
	public ModelAndView transactionSchedulingHandler(HttpServletRequest request, @RequestParam Map<String, String> configData) {
		JSONObject jsonObject = null;
		try {
			jsonObject = paymentService.fetchDataFromFile();

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);
			JSONObject obj = emandateService.createRequestForTransactionScheduling(configData, merchantData);
			String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
			String dualVerificationResult = paymentService.fetchApiResponse(liveUrl, obj);
			TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
					TranscationResponse.class);
			ModelAndView modelAndView = new ModelAndView("TransactionScheduling");
			modelAndView.addObject("response", transcationResponse);
			return modelAndView;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping("/mandate-deactivation")
	@ResponseBody
	public ModelAndView mandateDeactivation() {
		return new ModelAndView("MandateDeactivation");
	}
	
	@PostMapping("/mandate-deactivation")
	@ResponseBody
	public ModelAndView mandateDeactivationHandler(HttpServletRequest request, @RequestParam Map<String, String> configData) {
		JSONObject jsonObject = null;
		try {
			jsonObject = paymentService.fetchDataFromFile();

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);
			JSONObject obj = emandateService.createRequestForMandateDeactivation(configData, merchantData);
			String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
			String dualVerificationResult = paymentService.fetchApiResponse(liveUrl, obj);
			TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
					TranscationResponse.class);
			ModelAndView modelAndView = new ModelAndView("MandateDeactivation");
			modelAndView.addObject("response", transcationResponse);
			return modelAndView;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
