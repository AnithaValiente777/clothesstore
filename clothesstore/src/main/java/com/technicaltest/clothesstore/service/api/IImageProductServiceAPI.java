package com.technicaltest.clothesstore.service.api;

import java.util.List;

import com.technicaltest.clothesstore.commons.GenericServiceAPI;
import com.technicaltest.clothesstore.dto.ImageProductDTO;
import com.technicaltest.clothesstore.model.ImageProduct;


public interface IImageProductServiceAPI extends GenericServiceAPI<ImageProduct, ImageProductDTO> {
	
	List<ImageProductDTO> getByCodeProduct(String codeProduct) throws Exception;

}
