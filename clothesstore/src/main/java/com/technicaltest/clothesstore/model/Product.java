package com.technicaltest.clothesstore.model;

public class Product {
	
	private String code;
	private String name;
	private String description;
	private Double price;
	private Double discount;
	private String imgfront;
	private String imgBack;
	
	public Product(String code, String name, String description, Double price, Double discount) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
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
	
}
