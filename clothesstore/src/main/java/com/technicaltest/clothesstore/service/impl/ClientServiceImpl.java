package com.technicaltest.clothesstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.technicaltest.clothesstore.commons.GenericServiceImpl;
import com.technicaltest.clothesstore.dto.ClientDTO;
import com.technicaltest.clothesstore.model.Client;
import com.technicaltest.clothesstore.service.api.IClientServiceAPI;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, ClientDTO> implements IClientServiceAPI{

	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		return firestore.collection("cliente");
	}

}
