package com.idosinchuk.distributedtracing.address.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.idosinchuk.distributedtracing.address.dto.Address;
import com.idosinchuk.distributedtracing.address.entity.AddressEntity;
import com.idosinchuk.distributedtracing.address.repository.AddressRepository;
import com.idosinchuk.distributedtracing.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;

	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Address getAddress(Integer addressId) {

		log.info("Call to addressRepository to obtain Address data by addressId: {}", addressId);
		
		Optional<AddressEntity> addressEntity  = addressRepository.findById(addressId);

		if (addressEntity.isPresent()) {
			return Address.builder().addressId(addressEntity.get().getAddressId()).city(addressEntity.get().getCity()).country(addressEntity.get().getCountry())
					.floor(addressEntity.get().getFloor()).number(addressEntity.get().getNumber())
					.postalCode(addressEntity.get().getPostalCode()).street(addressEntity.get().getStreet()).build();

		}

		return Address.builder().build();
	}
}