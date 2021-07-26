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

import com.technicaltest.clothesstore.dto.ShoppingCartDTO;
import com.technicaltest.clothesstore.model.ShoppingCart;
import com.technicaltest.clothesstore.service.api.IShoppingCartServiceAPI;

@RestController
@RequestMapping(value = "/shoppingCart/api/")
@CrossOrigin("*")
public class ShoppingCartController {

	@Autowired
	private IShoppingCartServiceAPI shoppingCartServiceAPI;

	@GetMapping(value = "/all")
	public List<ShoppingCartDTO> getAll() throws Exception {
		return shoppingCartServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public ShoppingCartDTO find(@PathVariable String id) throws Exception {
		return shoppingCartServiceAPI.get(id);
	}

	@GetMapping(value = "/findByCodeClient/{codeClient}")
	public List<ShoppingCartDTO> findByCode(@PathVariable String code) throws Exception {
		return shoppingCartServiceAPI.getByCode(code);
	}

	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody ShoppingCart shoppingCart, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = shoppingCartServiceAPI.save(shoppingCart);
		} else {
			shoppingCartServiceAPI.save(shoppingCart, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<ShoppingCartDTO> delete(@PathVariable String id) throws Exception {
		ShoppingCartDTO shoppingCart = shoppingCartServiceAPI.get(id);
		if (shoppingCart != null) {
			shoppingCartServiceAPI.delete(id);
		} else {
			return new ResponseEntity<ShoppingCartDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ShoppingCartDTO>(shoppingCart, HttpStatus.OK);
	}
}
