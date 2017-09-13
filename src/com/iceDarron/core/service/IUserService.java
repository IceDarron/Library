package com.iceDarron.core.service;

import java.util.List;

import com.iceDarron.data.mysql.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public List<User> getUserAll();
}
