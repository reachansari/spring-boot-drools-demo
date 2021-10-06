package com.example.drools.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.drools.demo.model.CurrencyCode;

@RestController
public class CurrencyController {

	@Autowired
	private KieContainer kieContainer;

	@GetMapping("/currencyCode/{code}")
	public ResponseEntity<String> getAreaByPinCode(@PathVariable String code) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(new CurrencyCode(code)); // which object to validate
		kieSession.fireAllRules(); // fire all rules defined into drool file (drl)
		kieSession.dispose();

		return new ResponseEntity<String>(getCurrencyByCode(code), HttpStatus.OK);
	}

	private String getCurrencyByCode(String code) {
		final Map<String, String> areaMap = new HashMap<>();

		areaMap.put("USD", "US Dollar");
		areaMap.put("SGD", "Singapore Dollar");
		areaMap.put("INR", "Indian Rupees");
		areaMap.put("IDR", "Indonesia Rupiah");

		return areaMap.getOrDefault(code, "Currency code not found");
	}
}
