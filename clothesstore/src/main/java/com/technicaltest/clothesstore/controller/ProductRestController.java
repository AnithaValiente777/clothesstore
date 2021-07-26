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

import com.technicaltest.clothesstore.dto.ProductDTO;
import com.technicaltest.clothesstore.model.Product;
import com.technicaltest.clothesstore.service.api.IProductServiceAPI;


@RestController
@RequestMapping(value = "/product/api/")
@CrossOrigin("*")
public class ProductRestController {

	@Autowired
	private IProductServiceAPI productServiceAPI;

	@GetMapping(value = "/all")
	public List<ProductDTO> getAll() throws Exception {
		return productServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public ProductDTO find(@PathVariable String id) throws Exception {
		return productServiceAPI.get(id);
	}

	@GetMapping(value = "/findByName/{name}")
	public List<ProductDTO> findByName(@PathVariable String name) throws Exception {
		return productServiceAPI.getByName(name);
	}
	
	@GetMapping(value = "/findByCode/{code}")
	public List<ProductDTO> findByCode(@PathVariable String code) throws Exception {
		return productServiceAPI.getByCode(code);
	}
	
	@GetMapping(value = "/findByMoreSearched")
	public List<ProductDTO> findByMoreSearched() throws Exception {
		return productServiceAPI.getMoreSearched();
	}

	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody Product product, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = productServiceAPI.save(product);
		} else {
			productServiceAPI.save(product, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<ProductDTO> delete(@PathVariable String id) throws Exception {
		ProductDTO product = productServiceAPI.get(id);
		if (product != null) {
			productServiceAPI.delete(id);
		} else {
			return new ResponseEntity<ProductDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}
	
}
