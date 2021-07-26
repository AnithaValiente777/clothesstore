package com.technicaltest.clothesstore.service.api;

import java.util.List;

import com.technicaltest.clothesstore.commons.GenericServiceAPI;
import com.technicaltest.clothesstore.dto.DetailShoppingCartDTO;
import com.technicaltest.clothesstore.model.DetailShoppingCart;

public interface IDetailShoppingCartServiceAPI extends GenericServiceAPI<DetailShoppingCart, DetailShoppingCartDTO>{

	List<DetailShoppingCartDTO> getByCodeCart(String codeCart) throws Exception;
	List<DetailShoppingCartDTO> getByCodeProduct(String codeProduct) throws Exception;
}
