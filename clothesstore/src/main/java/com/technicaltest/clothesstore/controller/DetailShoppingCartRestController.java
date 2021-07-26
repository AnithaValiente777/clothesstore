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

import com.technicaltest.clothesstore.dto.DetailShoppingCartDTO;
import com.technicaltest.clothesstore.model.DetailShoppingCart;
import com.technicaltest.clothesstore.service.api.IDetailShoppingCartServiceAPI;


@RestController
@RequestMapping(value = "/detailShoppingCart/api/")
@CrossOrigin("*")
public class DetailShoppingCartRestController {

	@Autowired
	private IDetailShoppingCartServiceAPI detailShoppingCartServiceAPI;

	
	@GetMapping(value = "/all")
	public List<DetailShoppingCartDTO> getAll() throws Exception {
		return detailShoppingCartServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public DetailShoppingCartDTO find(@PathVariable String id) throws Exception {
		return detailShoppingCartServiceAPI.get(id);
	}
	
	@GetMapping(value = "/findByCodeCart/{codeCart}")
	public List<DetailShoppingCartDTO> findByCodeCart(@PathVariable String codeCart) throws Exception {
		return detailShoppingCartServiceAPI.getByCode(codeCart);
	}
	
	@GetMapping(value = "/findByCodeProduct/{codeProduct}")
	public List<DetailShoppingCartDTO> findByCodeProduct(@PathVariable String codeProduct) throws Exception {
		return detailShoppingCartServiceAPI.getByCode(codeProduct);
	}

	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody DetailShoppingCart detailShoppingCart, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = detailShoppingCartServiceAPI.save(detailShoppingCart);
		} else {
			detailShoppingCartServiceAPI.save(detailShoppingCart, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<DetailShoppingCartDTO> delete(@PathVariable String id) throws Exception {
		DetailShoppingCartDTO detailShoppingCart = detailShoppingCartServiceAPI.get(id);
		if (detailShoppingCart != null) {
			detailShoppingCartServiceAPI.delete(id);
		} else {
			return new ResponseEntity<DetailShoppingCartDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DetailShoppingCartDTO>(detailShoppingCart, HttpStatus.OK);
	}
	
}
