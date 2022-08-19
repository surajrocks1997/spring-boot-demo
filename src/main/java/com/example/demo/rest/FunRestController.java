package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object sayHello() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Object> obj = restTemplate.exchange("https://reqres.in/api/product", HttpMethod.GET, entity,
				Object.class);

		return obj.getBody();
	}

	@GetMapping(value = "/work")
	public String doWork() {
		return "Coach Name and Team Name are: " + coachName + " & " + teamName;
	}
}
