package com.technicaltest.clothesstore.model;

public class Product {
	
	private String code;
	private String name;
	private String description;
	private Double price;
	private Double discount;
	private int searched;
	private String imgfront;
	private String imgBack;
	private Double priceWithDiscount;
	
	public Product(String code, String name, String description, Double price, Double discount, int searched) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.searched = searched;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public Double getprice(){
		return price;
	}
	
	public Double getDiscount(){
		return discount;
	}
	
	public String getImgfront() {
		return imgfront = "products/imgf"+code+".png";
	}
	
	public String getImgBack() {
		return imgBack = "products/imgb"+code+".png";
	}
	
	public Double getPriceWithDiscount() {
		return priceWithDiscount = price -(price * (discount*100));
	}
}
