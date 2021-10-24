package com.myLesson.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	private static final String HOST  = "http://localhost:";
	private static final String GET_MAPPING = "/service/profile";
	@Autowired
	TestRestTemplate restTemplate;
	public static GenericContainer<?> applicationDEV = new GenericContainer<>("devapp").
			withExposedPorts(8080);
	public static GenericContainer<?> applicationPROD = new GenericContainer<>("prodapp").
			withExposedPorts(8081);

	@BeforeAll
	public static void setUp() {
		applicationDEV.start();
		applicationPROD.start();

	}

	@Test
	void contextLoads() {
		ResponseEntity<String> devApp = restTemplate.getForEntity(HOST + applicationDEV.getMappedPort(8080)+ GET_MAPPING, String.class);
		Assertions.assertEquals("Current profile is dev", devApp.getBody());
		ResponseEntity<String> prodApp = restTemplate.getForEntity(HOST + applicationPROD.getMappedPort(8081) + GET_MAPPING, String.class);
		Assertions.assertEquals("Current profile is production", prodApp.getBody());

	}

}