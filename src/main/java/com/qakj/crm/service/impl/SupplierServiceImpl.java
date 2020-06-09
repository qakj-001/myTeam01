package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.SupplierMapper;
import com.qakj.crm.pojo.Supplier;
import com.qakj.crm.pojo.SupplierExample;
import com.qakj.crm.service.SupplierService;
@Transactional
@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private SupplierMapper mapper;
	
	@Override
	public List<Supplier> getall() {
		SupplierExample example=new SupplierExample();
		
		List<Supplier> list = mapper.selectByExample(example);
		
		return list;
	}

	@Override
	public void add(Supplier supplier) {
		  mapper.insertSelective(supplier);
		
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
		
	}

}
