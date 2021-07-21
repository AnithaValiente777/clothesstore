package com.technicaltest.clothesstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.technicaltest.clothesstore.commons.GenericServiceImpl;
import com.technicaltest.clothesstore.dto.ProductDTO;
import com.technicaltest.clothesstore.model.Product;
import com.technicaltest.clothesstore.service.api.ProductServiceAPI;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product,ProductDTO> implements ProductServiceAPI{

	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		return firestore.collection("productos");
	}

}
