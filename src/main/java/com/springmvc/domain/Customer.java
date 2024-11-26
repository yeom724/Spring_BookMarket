package com.springmvc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable{

	private static final long serialVersionUID = -8923129427599533816L;
	
	private String customerId;
	private String name;
	private Address address;
	private String phone;
	
	public Customer() { this.address = new Address(); } //기본생성자
	
	public Customer(String customerId, String name) {
		this();
		this.customerId = customerId;
		this.name = name;
	}
	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result +((customerId == null) ? 0 : customerId.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		
		if(customerId == null) {
			if(other.customerId != null) { return false; }
		} else if(!(customerId.equals(other.customerId))) { return false;}
		
		return true;
	}
	
	
	
	
}
