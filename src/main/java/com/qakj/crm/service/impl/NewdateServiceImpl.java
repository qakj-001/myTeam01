package com.qakj.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.NewdateMapper;
import com.qakj.crm.pojo.Newdate;
import com.qakj.crm.pojo.NewdateExample;
import com.qakj.crm.service.NewdateService;

@Transactional
@Service
public class NewdateServiceImpl implements NewdateService {

	@Autowired
	private NewdateMapper nm;
	
	@Override
	public List<Newdate> getAll() {
		NewdateExample example = new NewdateExample();
		List<Newdate> list = nm.selectByExample(example);
		return list;
	}

	@Override
	public void add(Newdate date) {
		nm.insertSelective(date);
		
	}

	@Override
	public void delete(int id) {
		nm.deleteByPrimaryKey(id);
		
	}

}
