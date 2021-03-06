package com.idosinchuk.distributedtracing.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.idosinchuk.distributedtracing.address.dto.Address;
import com.idosinchuk.distributedtracing.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping(value = "/addresses/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddress(@PathVariable Integer addressId) {
		
		log.info("Hello from Address Service with userId: {}", addressId);
		Address response = addressService.getAddress(addressId);
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}