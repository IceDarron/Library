package com.iceDarron.core.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iceDarron.core.distribute.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.iceDarron.core.service.IUserService;
import com.iceDarron.data.po.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	// @ResponseBody
	public String toShowUser(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		logger.info("testLog");
		return "showUser";
	}

	@RequestMapping(value = "/myJsp", method = RequestMethod.GET)
	@ResponseBody
	public String toMyJsp(HttpServletRequest request,
			HttpServletResponse response) { // httpservlet需要抽取到一个页面进行设定参数等
		response.setCharacterEncoding("utf-8");
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		logger.warn("test-myJsp");
		return JSON.toJSONString(userList); // 通过这个返回值来绑定的jsp，原理不清楚，应该是spring-mvc.xml中配置的
	}

	@RequestMapping(value = "/saveMyJsp", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(HttpServletRequest request) {
		Map<String, String[]> params = request.getParameterMap();
		String str = "";
		try {
			str = WebAPI.getBody(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONArray jArray = new JSONArray();
		logger.info("test-saveMyJsp");
		return str;
	}
	
	@RequestMapping(value = "/userAll", method = RequestMethod.GET)
	@ResponseBody
	public String getUserAll(HttpServletRequest request) {
		List<User> userList = this.userService.getUserAll();
		logger.info("test-userAll");
		return JSON.toJSONString(userList);
	}
	
	
	// http://localhost:8081/springMVC/user/showUser?id=1
	
	

}