package com.technicaltest.clothesstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.technicaltest.clothesstore.commons.GenericServiceImpl;
import com.technicaltest.clothesstore.dto.DetailShoppingCartDTO;
import com.technicaltest.clothesstore.model.DetailShoppingCart;
import com.technicaltest.clothesstore.service.api.IDetailShoppingCartServiceAPI;

@Service
public class DetailShoppingCartServiceImpl extends GenericServiceImpl<DetailShoppingCart, DetailShoppingCartDTO> implements IDetailShoppingCartServiceAPI{

	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		return firestore.collection("carritoDetalleCompra");
	}

}
