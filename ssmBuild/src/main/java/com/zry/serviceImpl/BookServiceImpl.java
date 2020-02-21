package com.zry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zry.dao.BookMapper;
import com.zry.pojo.Books;
import com.zry.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	// 调用dao层的操作，设置一个set接口，方便Spring管理
	@Autowired
	@Qualifier("bookMapper")
	private BookMapper bookMapper;

	public void setBookMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public int addBook(Books book) {
		return bookMapper.addBook(book);
	}

	public int deleteBookById(int id) {
		return bookMapper.deleteBookById(id);
	}

	public int updateBook(Books books) {
		return bookMapper.updateBook(books);
	}

	public Books queryBookById(int id) {
		return bookMapper.queryBookById(id);
	}

	public List<Books> queryAllBook() {
		return bookMapper.queryAllBook();
	}

}
