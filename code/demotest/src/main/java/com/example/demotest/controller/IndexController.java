package com.example.demotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(value = "test_html")
	public String testHtml() {
		System.out.println("execute");
		return "test.html";
	}
	
	@RequestMapping(value = "/test", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String test() {
		return "test";
	}
	
}
