package com.test.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.configclient.config.ClientConfig;

@RestController
public class ConfigClientController {
	
	@Autowired
	private ClientConfig config;
	@Value("${sample.property2}")
private String property2;
	
	@RequestMapping("/config")
	public String printConfig() {
		return config.getProperty1() + "||" + property2;
	}
}
