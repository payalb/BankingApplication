package com.java.dto;

import lombok.Data;

@Data
public class Address implements Cloneable{

	private int id;
	private int houseNumber;
	private String street, city, state;
	private long pincode;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
