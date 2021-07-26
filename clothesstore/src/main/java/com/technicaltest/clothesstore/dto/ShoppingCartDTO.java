package com.technicaltest.clothesstore.dto;

public class ShoppingCartDTO {

	private String id;
	private String codeClient;
	private String arrived;
	private String paid;
	private Double subTotal;
	private Double total;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public String getArrived() {
		return arrived;
	}
	public void setArrived(String arrived) {
		this.arrived = arrived;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
}
