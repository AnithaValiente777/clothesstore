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
import com.technicaltest.clothesstore.dto.ProductDTO;
import com.technicaltest.clothesstore.model.Product;
import com.technicaltest.clothesstore.service.api.IProductServiceAPI;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product,ProductDTO> implements IProductServiceAPI{

	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		return firestore.collection("producto");
	}
	
	@Override
	public List<ProductDTO> getMoreSearched() throws Exception {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		ApiFuture<QuerySnapshot> query = getCollection().whereGreaterThan("searched", 100).limit(2).get();
		List<QueryDocumentSnapshot> documents = query.get().getDocuments();
		for (QueryDocumentSnapshot doc : documents) {
			ProductDTO object = doc.toObject(clazz);
			PropertyUtils.setProperty(object, "id", doc.getId());
			result.add(object);
		}
		return result;
	}
}
