package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServicce;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public String requestBookList(Model model) {
		System.out.println("requestBookList 입장");
		
		List<Book> list = bookServicce.getAllBookList();
		model.addAttribute("bookList", list);
		
		System.out.println("도서 목록을 model에 저장했습니다.");
		return "books";
	}
}
