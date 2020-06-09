package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Supplier;
import com.qakj.crm.service.SupplierService;
@RequestMapping("/supplierController")
@RestController
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	@RequestMapping("/all")
	public Object all(){
		
		List<Supplier> list = service.getall();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", "200");
		map.put("supplier", list);
		
		return map;
	}
	
	@RequestMapping("/add")
	public String add(Supplier supplier){
		service.add(supplier);
		
		return "添加成功";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		service.delete(id);

		return "删除成功";
		
	}
	
	
}
