package com.iceDarron.core.service;

import java.util.List;

import com.iceDarron.data.po.Book;

/**
 * @Description [用于图书对象的所有CRUD操作接口]
 * @author IceDarron
 * @since 20170726
 */
public interface IBookService {

	// TODO 期望获取所有书籍方法增加分页参数、查询条件，增加更新删除操作需要以批量的形式实现而不是单一操作。
	
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

	/**
	 * 查询符合条件的所有book对象数据
	 * @param book 查询条件
	 * @return 返回booklist
	 */
	public List<Book> getBookByCondition(Book book);

}
