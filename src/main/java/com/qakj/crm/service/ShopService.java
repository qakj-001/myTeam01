package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Shop;

public interface ShopService {
	
	List<Shop> selectAll();
	
	void deleteOneById(int id);
	
	Shop getById(int id);
	
	void updateById(Shop shop);
	
	void add(Shop shop);
}
