package com.qakj.crm.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.ShopMapper;
import com.qakj.crm.pojo.Shop;
import com.qakj.crm.pojo.ShopExample;
import com.qakj.crm.service.ShopService;

@Transactional
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopmapper;
	
	@Override
	public List<Shop> selectAll() {
		ShopExample example = new ShopExample();
		List<Shop> list = shopmapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteOneById(int id) {
		shopmapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateById(Shop shop) {
		shopmapper.updateByPrimaryKeySelective(shop);
	}

	@Override
	public void add(Shop shop) {
		shopmapper.insertSelective(shop);
		
	}

	@Override
	public Shop getById(int id) {
		Shop shop = shopmapper.selectByPrimaryKey(id);
		return shop;
	}

}
