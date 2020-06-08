package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Newdate;
import com.qakj.crm.service.NewdateService;

@RequestMapping("/newdateController")
@RestController
public class NewdateController {
	
	@Autowired
	private NewdateService ns;
	
	@RequestMapping("/findAll")
	public Object findAll(){
		List<Newdate> list = ns.getAll();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/add")
	public String add(Newdate date){
		ns.add(date);
		return "添加成功";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		ns.delete(id);
		return "删除成功";
	}
}
