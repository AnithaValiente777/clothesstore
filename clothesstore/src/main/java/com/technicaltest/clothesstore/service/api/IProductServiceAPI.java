package com.technicaltest.clothesstore.service.api;

import java.util.List;

import com.technicaltest.clothesstore.commons.GenericServiceAPI;
import com.technicaltest.clothesstore.dto.ProductDTO;
import com.technicaltest.clothesstore.model.Product;

public interface IProductServiceAPI extends GenericServiceAPI<Product, ProductDTO>{

	List<ProductDTO> getMoreSearched() throws Exception;

}
