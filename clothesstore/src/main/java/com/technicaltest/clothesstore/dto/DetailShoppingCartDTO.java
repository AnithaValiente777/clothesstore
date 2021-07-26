package com.technicaltest.clothesstore.dto;

public class DetailShoppingCartDTO {

	private String id;
	private String codeCart;
	private String codeProduct;
	private int  qty;
	private Double subTotal;
	private Double total;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeCart() {
		return codeCart;
	}
	public void setCodeCart(String codeCart) {
		this.codeCart = codeCart;
	}
	public String getCodeProduct() {
		return codeProduct;
	}
	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
