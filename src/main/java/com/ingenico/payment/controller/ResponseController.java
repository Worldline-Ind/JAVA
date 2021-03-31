package com.ingenico.payment.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ingenico.payment.domain.MerchantData;
import com.ingenico.payment.domain.TranscationResponse;
import com.ingenico.payment.service.PaymentService;

@Controller
public class ResponseController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	
	@PostMapping("/response/response-handler")
	public ModelAndView onlineTransactionHandler(HttpServletRequest request, @RequestParam Map<String,String> requestData) {
		
		JSONObject jsonObject = null;
		try {
			jsonObject = paymentService.fetchDataFromFile();
			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);

			ModelAndView modelAndView = new ModelAndView("ReponseHandler");
			String[] data = requestData.get("msg").split("\\|");
			String[] onlineTransctionMsg = requestData.get("msg").split("\\|");

			if ("0300".equals(data[0])) {

				JSONObject obj = paymentService.createRequestFortranscation(data, merchantData);

				String url = "https://www.paynimo.com/api/paynimoV2.req";
				String dualVerificationResult = paymentService.fetchApiResponse(url, obj);

				TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
						TranscationResponse.class);

				modelAndView.addObject("dualVerification", transcationResponse);
				modelAndView.addObject("configData", requestData);

			}
			modelAndView.addObject("onlineTransction", onlineTransctionMsg);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
