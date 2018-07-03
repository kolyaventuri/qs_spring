package com.kolyaventuri.quantifiedself.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@RequestMapping("/")
	public String index() {
		return "Quantified Self Spring";
	}
}
