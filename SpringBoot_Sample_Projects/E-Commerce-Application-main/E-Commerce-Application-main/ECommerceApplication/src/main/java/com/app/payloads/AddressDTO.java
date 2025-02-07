package com.app.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	private Long addressId;
	private String street;
	private String buildingName;
	private String city;
	private String state;
	private String country;
	private String pincode;
}
