package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Customer;
import com.qakj.crm.service.CustomerService;

@RequestMapping("customerController")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService cs;
	
	@RequestMapping("/getCustomers")
	public Object getCustomers(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize,@RequestParam("searchName") String searchName){
		if(searchName == null || "".equals(searchName)){
			searchName = "%%";
		}else{
			searchName = "%"+searchName+"%";
		}
		List<Customer> list = cs.getCustomers(currentPage, pageSize, searchName);
		int count = cs.getCustomerCount(searchName);
		int countPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("data", list);
		map.put("countPage", countPage);
		
		return map;
	}
	
	@RequestMapping("/getDetails")
	public Object getCustomer(@RequestParam("id") Integer id){
		Customer customer = cs.getCustomerById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "200");
		map.put("data",customer);
		return map;
	}
	
	@RequestMapping("/deleteById/{id}")
	public String deleteById(@RequestParam("id") Integer id){
		cs.deleteById(id);
		return null;
	}
	
}
