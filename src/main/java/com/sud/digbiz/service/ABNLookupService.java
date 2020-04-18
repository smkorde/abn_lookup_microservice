package com.sud.digbiz.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sud.digbiz.bean.ABNLookupBean;
import com.sud.digibiz.util.AbnAcnUtils;

@RestController
public class ABNLookupService {

	public static final String GUID = "88896e1b-3285-457e-b525-006354cbd197";

	@Inject
	private RestTemplate restTemplate;

	@GET
	@RequestMapping("/AbnAcnlookup")
	@Produces(MediaType.ALL_VALUE)
	public ABNLookupBean lookupAbnAcn(@RequestParam(value = "ABNACN") String ABNACN) {
		ABNLookupBean abnLookupBean = new ABNLookupBean();
		try {
			if (AbnAcnUtils.isValidABN(ABNACN)) {
				ResponseEntity<String> response = restTemplate.getForEntity(
						"https://abr.business.gov.au/json/AbnDetails.aspx?abn={ABNACN}&guid={GUID}", String.class,
						ABNACN, GUID);
				String responseStr = response.getBody().replaceAll("callback\\(", "").replaceAll("\\)", "");
				JSONObject json = (JSONObject) new JSONParser().parse(responseStr);
				abnLookupBean.setAbn(json.get("Abn").toString());
				abnLookupBean.setEntityName(json.get("EntityTypeName").toString());
			} else {
				abnLookupBean.setExceptionMessage("Invalid ABN");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return abnLookupBean;
	}

}
