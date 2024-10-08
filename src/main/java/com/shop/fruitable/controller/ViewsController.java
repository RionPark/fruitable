package com.shop.fruitable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ViewsController {

	@GetMapping("/")
	public String home() {
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public void goPage() {
		log.info("execute goPage()");
	}
}
