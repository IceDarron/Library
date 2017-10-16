package com.iceDarron.data.mysql.dao;

import java.util.List;

import com.iceDarron.data.mysql.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	List<User> getUserAll();
}
