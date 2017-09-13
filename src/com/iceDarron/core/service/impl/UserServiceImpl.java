package com.iceDarron.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iceDarron.core.service.IUserService;
import com.iceDarron.data.mysql.dao.IUserDao;
import com.iceDarron.data.mysql.po.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired 
	private IUserDao userDao;
	
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> getUserAll() {
		// TODO Auto-generated method stub
		return this.userDao.getUserAll();
	}
	
}
