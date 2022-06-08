package com.test.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class TestController {
	@GetMapping("/hello")
	public String sayHello() {
		return "hello from service 2";
	}
}