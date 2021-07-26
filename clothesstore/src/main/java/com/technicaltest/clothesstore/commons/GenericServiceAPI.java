package com.technicaltest.clothesstore.commons;

import java.util.Map;
import java.util.List;

public interface GenericServiceAPI<I,O> {

	String save(I entity,String id) throws Exception;
	
	String save(I entity) throws Exception;
	
	void delete (String id) throws Exception;
	
	O get(String id) throws Exception;
	
	Map<String, Object> getAsMap(String id) throws Exception;
	
	List<O> getAll() throws Exception;

	List<O> getByName(String name) throws Exception;

	List<O> getByCode(String code) throws Exception;
	
}
