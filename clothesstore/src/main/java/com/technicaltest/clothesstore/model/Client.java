package com.technicaltest.clothesstore.model;

public class Client {

	private String code;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public Client(String code, String name, String email, String phone, String address) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}


}
