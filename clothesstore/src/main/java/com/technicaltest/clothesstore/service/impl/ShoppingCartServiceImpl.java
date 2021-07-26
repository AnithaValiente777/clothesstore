package com.technicaltest.clothesstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.technicaltest.clothesstore.commons.GenericServiceImpl;
import com.technicaltest.clothesstore.dto.ShoppingCartDTO;
import com.technicaltest.clothesstore.model.ShoppingCart;
import com.technicaltest.clothesstore.service.api.IShoppingCartServiceAPI;

@Service
public class ShoppingCartServiceImpl extends GenericServiceImpl<ShoppingCart, ShoppingCartDTO> implements IShoppingCartServiceAPI{

	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		return firestore.collection("carritoCompra");
	}
}
