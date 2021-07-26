package com.technicaltest.clothesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicaltest.clothesstore.dto.ClientDTO;
import com.technicaltest.clothesstore.model.Client;
import com.technicaltest.clothesstore.service.api.IClientServiceAPI;

@RestController
@RequestMapping(value = "/client/api/")
@CrossOrigin("*")
public class ClientRestController {

	@Autowired
	private IClientServiceAPI clientServiceAPI;

	@GetMapping(value = "/all")
	public List<ClientDTO> getAll() throws Exception {
		return clientServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public ClientDTO find(@PathVariable String id) throws Exception {
		return clientServiceAPI.get(id);
	}

	@GetMapping(value = "/findByName/{name}")
	public List<ClientDTO> findByName(@PathVariable String name) throws Exception {
		return clientServiceAPI.getByName(name);
	}
	
	@GetMapping(value = "/findByIdentification/{identification}")
	public List<ClientDTO> findByCode(@PathVariable String code) throws Exception {
		return clientServiceAPI.getByCode(code);
	}

	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody Client client, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = clientServiceAPI.save(client);
		} else {
			clientServiceAPI.save(client, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable String id) throws Exception {
		ClientDTO client = clientServiceAPI.get(id);
		if (client != null) {
			clientServiceAPI.delete(id);
		} else {
			return new ResponseEntity<ClientDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ClientDTO>(client, HttpStatus.OK);
	}
}
