package com.iceDarron.data.dao;

import java.util.List;

import com.iceDarron.data.po.User;
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
