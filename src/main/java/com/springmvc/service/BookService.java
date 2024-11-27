package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;

public interface BookService {
	
	//Controller에서 부모타입을 참조하고 있기 때문에 모델에서 사용하는 함수는 모두 오버라이딩이 되는 형식이어야 한다.
	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	Book getBookById(String BookId);
	void setNewBook(Book book);
	void setUpdateBook(Book book);
}
