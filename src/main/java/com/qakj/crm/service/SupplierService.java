package com.qakj.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.pojo.Supplier;


public interface SupplierService {
	
	List<Supplier> getall();
	
	void add(Supplier supplier);
	
	void delete(int id);
}
