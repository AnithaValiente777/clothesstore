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

import com.technicaltest.clothesstore.dto.ImageProductDTO;
import com.technicaltest.clothesstore.model.ImageProduct;
import com.technicaltest.clothesstore.service.api.IImageProductServiceAPI;

@RestController
@RequestMapping(value = "/imageProduct/api/")
@CrossOrigin("*")
public class ImageProductRestController {
	
	@Autowired
	private IImageProductServiceAPI imageProductServiceAPI;


	@GetMapping(value = "/find/{id}")
	public ImageProductDTO find(@PathVariable String id) throws Exception {
		return imageProductServiceAPI.get(id);
	}

	@GetMapping(value = "/findByCodeProduct/{name}")
	public List<ImageProductDTO> findByCodeProduct(@PathVariable String name) throws Exception {
		return imageProductServiceAPI.getByCodeProduct(name);
	}
	
	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody ImageProduct imageProduct, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = imageProductServiceAPI.save(imageProduct);
		} else {
			imageProductServiceAPI.save(imageProduct, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<ImageProductDTO> delete(@PathVariable String id) throws Exception {
		ImageProductDTO imageProduct = imageProductServiceAPI.get(id);
		if (imageProduct != null) {
			imageProductServiceAPI.delete(id);
		} else {
			return new ResponseEntity<ImageProductDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ImageProductDTO>(imageProduct, HttpStatus.OK);
	}
}
