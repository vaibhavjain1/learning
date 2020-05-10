package com.demo.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTemplateDemo {

	private static ObjectMapper objectMapper = new ObjectMapper();

	private static RestTemplate restTemplate = new RestTemplate();
	
	public void postRequest() {
		String apiUrl = "https://ldj8jx34zb.execute-api.ap-south-1.amazonaws.com/default/Eduthrill";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Object req = new Object();

		String requestJson = "";
		try {
			requestJson = objectMapper.writeValueAsString(req);
		} catch (Exception e) {
		}

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String resp = restTemplate.postForObject(apiUrl, entity, String.class);
		
		System.out.println(resp);
	}
	
	public static void main(String[] args) {
		RestTemplateDemo obj = new RestTemplateDemo();
		obj.postRequest();
	}
}
