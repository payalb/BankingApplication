package com.java.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Customer implements Cloneable{
	
	private static int idGenerator;
	private int id;
	private String firstName, lastName;
	private long phoneNumber;
	private String emailId;
	private Address address;
	{
		idGenerator++;
		id= idGenerator;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
