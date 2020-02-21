package com.zry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zry.pojo.Books;
import com.zry.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	@Qualifier("bookServiceImpl")
	private BookService bookService;

	@RequestMapping("/allBook")
	public String list(Model model) {
		List<Books> list = bookService.queryAllBook();
		model.addAttribute("list", list);
		return "allbook";
	}

	@RequestMapping("/toAddBook")
	public String toAddPaper() {
		return "addBook";
	}

	@RequestMapping("/addBook")
	public String addPaper(Books books) {
		System.out.println(books);
		bookService.addBook(books);
		return "redirect:/book/allBook";
	}

	@RequestMapping("/toUpdateBook/{bookId}")
	public String toUpdateBook(@PathVariable("bookId") int id, Model model) {
//        System.out.println(id);
		Books books = bookService.queryBookById(id);
		System.out.println(books);
		model.addAttribute("book", books);
		return "updateBook";
	}

	@RequestMapping("/updateBook")
	public String updateBook(Model model, Books book) {
		System.out.println(book);
		bookService.updateBook(book);
		Books books = bookService.queryBookById(book.getBookID());
		model.addAttribute("books", books);
		return "redirect:/book/allBook";
	}

	@RequestMapping("/del/{bookId}")
	public String deleteBook(@PathVariable("bookId") int id) {
		bookService.deleteBookById(id);
		return "redirect:/book/allBook";
	}
}
