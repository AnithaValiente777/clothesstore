package com.technicaltest.clothesstore.model;

public class ShoppingCart {

	private String codeClient;
	private String arrived;
	private String paid;
	private Double subTotal;
	private Double total;
	
	public ShoppingCart(String codeClient, String arrived, String paid, Double subTotal, Double total) {
		this.codeClient = codeClient;
		this.arrived = arrived;
		this.paid = paid;
		this.subTotal = subTotal;
		this.total = total;
	}
	
	public String getCodeClient() {
		return codeClient;
	}

	public String getArrived() {
		return arrived;
	}
	
	public String getPaid() {
		return paid;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public Double getTotal() {
		return total;
	}

	
	
}
