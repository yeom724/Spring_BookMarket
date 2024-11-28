package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	//Spring이 객체를 담을 참조변수를 지정한다.
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		System.out.println("BookService에서 책 목록 보내주는 중...");
		
		return bookRepository.getAllBookList();
	}

	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		System.out.println("서비스에서 요청 처리중...");
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		
		System.out.println("서비스에서 필터 요청 받는중...");
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		
		return booksByFilter;
	}

	@Override
	public Book getBookById(String BookId) {
		// TODO Auto-generated method stub
		
		Book bookById = bookRepository.getBookById(BookId);
		System.out.println("서비스에서 도서 정보 이동중...");
		return bookById;
	}

	@Override
	public void setNewBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println("서비스에서 book 객체 레파지토리로 보내는 중...");
		bookRepository.setNewBook(book);
	}

	@Override
	public void setUpdateBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println("서비스에서 도서 정보 수정사항 전달하는 중...");
		bookRepository.setUpdateBook(book);
		
	}

	@Override
	public void setDeleteBook(String bookId) {
		// TODO Auto-generated method stub
		System.out.println("삭제할 도서 받아오는 중...");
		bookRepository.setDeleteBook(bookId);
		
	}

}
