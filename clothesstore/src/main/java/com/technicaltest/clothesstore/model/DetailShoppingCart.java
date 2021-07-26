package com.technicaltest.clothesstore.model;

public class DetailShoppingCart {

	private String codeCart;
	private String codeProduct;
	private int  qty;
	private Double subTotal;
	private Double total;
	
	public DetailShoppingCart(String codeCart, String codeProduct, int qty, Double subTotal, Double total) {
		this.codeCart = codeCart;
		this.codeProduct = codeProduct;
		this.qty = qty;
		this.subTotal = subTotal;
		this.total = total;
	}

	public String getCodeCart() {
		return codeCart;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public int getQty() {
		return qty;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public Double getTotal() {
		return total;
	}
	
}
