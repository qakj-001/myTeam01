package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.User;
import com.qakj.crm.service.UserService;

@RequestMapping("userController")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public Map<String,Object> login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		User user = userService.getUserByUsernameAndPassword(username, password);
		if(user != null){
			session.setAttribute("user", user);
			map.put("code", "200");
			map.put("msg", "登陆成功");
			return map;
		}
		map.put("code", "400");
		map.put("msg", "登陆失败");
		
		return map;
	}
	
	@RequestMapping("/user")
	public Map<String,Object> user(HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Object user = session.getAttribute("user");
		if(user!=null){
			map.put("code", "200");
			map.put("user", user);
			return map;
		}
		map.put("code", "444");
		return map;
	}
	
	@RequestMapping("/logout")
	public Object logout(HttpSession session){
		session.invalidate();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "200");
		return map;
	}
	
	@RequestMapping("/updatePwd")
	public String updatePwd(@PathParam("id") Integer id,@PathParam("password")String password){
		userService.UpdateUserById(id, password);
		return "200";
	}
	
}
