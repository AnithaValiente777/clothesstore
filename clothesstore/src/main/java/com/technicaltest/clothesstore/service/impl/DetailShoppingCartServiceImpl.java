package com.technicaltest.clothesstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
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

	@Override
	public List<DetailShoppingCartDTO> getByCodeCart(String codeCart) throws Exception {
		List<DetailShoppingCartDTO> result = new ArrayList<DetailShoppingCartDTO>();
		ApiFuture<QuerySnapshot> query = getCollection().whereEqualTo("codeCart", codeCart).get();
		List<QueryDocumentSnapshot> documents = query.get().getDocuments();
		for (QueryDocumentSnapshot doc : documents) {
			DetailShoppingCartDTO object = doc.toObject(clazz);
			PropertyUtils.setProperty(object, "id", doc.getId());
			result.add(object);
		}
		return result;
	}
	
	@Override
	public List<DetailShoppingCartDTO> getByCodeProduct(String codeProduct) throws Exception {
		List<DetailShoppingCartDTO> result = new ArrayList<DetailShoppingCartDTO>();
		ApiFuture<QuerySnapshot> query = getCollection().whereEqualTo("codeProduct", codeProduct).get();
		List<QueryDocumentSnapshot> documents = query.get().getDocuments();
		for (QueryDocumentSnapshot doc : documents) {
			DetailShoppingCartDTO object = doc.toObject(clazz);
			PropertyUtils.setProperty(object, "id", doc.getId());
			result.add(object);
		}
		return result;
	}

}
