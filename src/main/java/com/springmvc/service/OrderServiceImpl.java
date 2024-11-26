package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.domain.Order;
import com.springmvc.repository.BookRepository;
import com.springmvc.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderRepository orderRepositoy;
	
	@Autowired
	private CartService cartService;

	@Override
	public void confirmOrder(String bookId, long quantity) {
		
		System.out.println("재고를 확인합니다.");
		
		Book bookById = bookRepository.getBookById(bookId);
		
		if(bookById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException("품절입니다. 사용가능한 재고 수 : " + bookById.getUnitsInStock());
		}
		
		System.out.println("해당 제품의 재고가 감소됩니다.");
		bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
		
	}

	@Override
	public Long saveOrder(Order order) {
		System.out.println("주문처리를 진행합니다.");
		
		Long orderId = orderRepositoy.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		
		return orderId;
	}

}
