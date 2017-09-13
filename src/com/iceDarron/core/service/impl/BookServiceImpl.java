package com.iceDarron.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iceDarron.core.service.IBookService;
import com.iceDarron.data.mysql.dao.IBookDao;
import com.iceDarron.data.mysql.po.Book;

@Service("bookService")
public class BookServiceImpl implements IBookService {

	@Autowired 
	private IBookDao bookDao;
	
	public List<Book> getBookAll() {
		return this.bookDao.getBookAll();
	}

	@Override
	public int addBook(List<Book> listBook) {
		return this.bookDao.addBook(listBook);
	}

	@Override
	public int updateBook(List<Book> listBook) {
		return this.bookDao.updateBook(listBook);
	}

	@Override
	public int deleteBook(List<Book> listBook) {
		return this.bookDao.deleteBook(listBook);
	}
}
