package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Newdate;

public interface NewdateService {

	List<Newdate> getAll();
	
	void add(Newdate date);
	
	void delete(int id);
	
	
}
