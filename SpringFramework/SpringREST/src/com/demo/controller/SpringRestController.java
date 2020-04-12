package com.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;

@RestController
public class SpringRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Application is up";
	}

	@GetMapping("/servicestatus")
	public String serviceCheck() {
		return "Service is up";
	}

	@GetMapping("/getwithparam")
	public String getwithparam(@RequestParam String value) {
		return "Received param:" + value;
	}

	@PostMapping("/postsimple")
	public String postMethod() {
		return "Able to post";
	}

	@PostMapping("/poststring")
	String newString(@RequestBody String stringData) {
		return "Received String data:" + stringData;
	}

	@PostMapping(path = "/postobject", consumes = MediaType.APPLICATION_JSON_VALUE)
	Employee postObject(@RequestBody Employee newEmp) {
		return newEmp;
	}
}
