package com.iceDarron.data.mysql.dao;

import java.util.List;

import com.iceDarron.data.mysql.po.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao {
	
	/**
	 * 获取所有book对象数据
	 */
	public List<Book> getBookAll();
	
	/**
	 * 增加book对象数据
	 * @param listBook 修改的数据
	 * @return 返回执行数量
	 */
	public int addBook(List<Book> listBook);
	
	/**
	 * 更新所有book对象数据
	 * @param listBook 修改的数据
	 * @return 返回执行数量
	 */
	public int updateBook(List<Book> listBook);
	
	/**
	 * 删除所有book对象数据
	 * @param listBook 修改的数据
	 * @return 返回执行数量
	 */
	public int deleteBook(List<Book> listBook);
}
