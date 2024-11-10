package com.deliveryBoy.deliveryBoy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryBoy.deliveryBoy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController
{

	@Autowired
	private KafkaService kafkaService;

	@PostMapping("/update/{n}")
	public ResponseEntity<?> updateLocation(@PathVariable int n)
	{
		for (int i = 0; i < n; i++)
		{
		this.kafkaService.updateLocation(
				"( " + Math.floor(Math.random() * 100) + " , " + Math.floor(Math.random() * 100) + " )");
		}
		return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
	}
}
