package com.sud.digbiz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbnLookupApplicationTests {

	public static final String GUID = "88896e1b-3285-457e-b525-006354cbd197";
	public static final String ABN = "74172177893";

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void lookupAbn() {
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(
					"https://abr.business.gov.au/json/AbnDetails.aspx?abn={ABNACN}&guid={GUID}", String.class, ABN,
					GUID);
			String responseStr = response.getBody().replaceAll("callback\\(", "").replaceAll("\\)", "");
			System.out.println("res:" + responseStr);
			JSONObject json = (JSONObject) new JSONParser().parse(responseStr);
			System.out.println("Comapnyname=" + json.get("EntityTypeName"));
			System.out.println("ABN=" + json.get("Abn"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
