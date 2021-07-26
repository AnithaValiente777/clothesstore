package com.technicaltest.clothesstore.model;

public class ImageProduct {

	private String codeProduct;
	private String img;
	
	public ImageProduct(String codeProduct, String img) {
		this.codeProduct = codeProduct;
		this.img = img;
	
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public String getImg() {
		return img;
	}

}
