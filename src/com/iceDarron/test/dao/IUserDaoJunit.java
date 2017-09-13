package com.iceDarron.test.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.iceDarron.data.mysql.dao.IUserDao;


public class IUserDaoJunit {
	
	@Autowired 
	private IUserDao userDao;
	
	public void testSelectByPrimaryKey() {
		userDao.selectByPrimaryKey(1);
	}
}
