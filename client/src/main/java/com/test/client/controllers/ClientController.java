package com.test.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ClientController {
	@Autowired
	private EurekaClient client;
	@Autowired
	private RestTemplateBuilder templateBuilder;

	@RequestMapping("/")
	public String callService() {
		InstanceInfo instance = client.getNextServerFromEureka("service", false);// goi den thang discovery service va truyen len ten service muon goi, o day ten la service
		// tra ve instance, tu instance lay dc dia chi url
		String url = instance.getHomePageUrl();// lay baseurl de goi den thang service

		RestTemplate restTemplate = templateBuilder.build();// goi den endpoint cua cai service instance tra ve, duong dan endpoint trung vs url mac dinh
		ResponseEntity<String> respone = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
		return respone.getBody();
	}
}
