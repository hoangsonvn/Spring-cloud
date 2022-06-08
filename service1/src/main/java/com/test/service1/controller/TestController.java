package com.test.service1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class TestController {
	@GetMapping("/hello")
	public String sayHello() {
		return "hello from service 1";
	}
}
