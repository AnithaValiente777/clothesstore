package com.technicaltest.clothesstore.dto;

public class ProductDTO {

	private String id;
	private String code;
	private String name;
	private String description;
	private Double price;
	private Double discount;
	private String imgfront;
	private String imgBack;
	//private Double priceWithDiscount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getImgfront() {
		return imgfront;
	}
	public void setImgfront(String imgfront) {
		this.imgfront = imgfront;
	}
	public String getImgBack() {
		return imgBack;
	}
	public void setImgBack(String imgBack) {
		this.imgBack = imgBack;
	}
	
	/*public ProductDTO(String code, String name, String description, Double price, Double discount) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}*/
	
	/*public Double getPriceWithDiscount(){
		return priceWithDiscount = (price * discount)/100;
	}*/
}
