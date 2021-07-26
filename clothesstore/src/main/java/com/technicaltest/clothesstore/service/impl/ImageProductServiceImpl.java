package com.technicaltest.clothesstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.technicaltest.clothesstore.commons.GenericServiceImpl;
import com.technicaltest.clothesstore.dto.ImageProductDTO;
import com.technicaltest.clothesstore.model.ImageProduct;
import com.technicaltest.clothesstore.service.api.IImageProductServiceAPI;

public class ImageProductServiceImpl extends GenericServiceImpl<ImageProduct, ImageProductDTO> implements IImageProductServiceAPI{

	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		return firestore.collection("producto");
	}
	
	@Override
	public List<ImageProductDTO> getByCodeProduct(String codeProduct) throws Exception {
		List<ImageProductDTO> result = new ArrayList<ImageProductDTO>();
		ApiFuture<QuerySnapshot> query = getCollection().whereEqualTo("codeProduct", codeProduct).get();
		List<QueryDocumentSnapshot> documents = query.get().getDocuments();
		for (QueryDocumentSnapshot doc : documents) {
			ImageProductDTO object = doc.toObject(clazz);
			PropertyUtils.setProperty(object, "id", doc.getId());
			result.add(object);
		}
		return result;
	}


}
