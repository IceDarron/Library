package com.iceDarron.test;

import javax.annotation.Resource;

import com.iceDarron.core.service.IUserService;

public class TestMyself {

	@Resource
	private IUserService userService = null;

	public static void main(String[] args) {
		TestMyself tm = new TestMyself();
		tm.init();
	}

	public void init() {
		System.out.println(userService.getUserById(1));
	}
}
