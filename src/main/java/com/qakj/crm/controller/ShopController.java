package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Shop;
import com.qakj.crm.service.ShopService;

@RequestMapping("/shopController")
@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/getAll")
	public Object findAll(){
		List<Shop> list = shopService.selectAll();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		shopService.deleteOneById(id);
		return "删除成功";	
	}
	
	@RequestMapping("/selectOne/{id}")
	public Object supdate(@PathVariable("id") Integer id){
		Shop shop = shopService.getById(id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("data", shop);
		return map;
	}
	
	@RequestMapping("/update")
	public Object update(Shop shop){
		shopService.updateById(shop);
		return "修改成功";
	}
	
	@RequestMapping("/add")
	public String add(Shop shop){
		shopService.add(shop); 
		return "添加成功";
	}
}
