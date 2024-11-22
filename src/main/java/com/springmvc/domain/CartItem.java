package com.springmvc.domain;

import java.util.Objects;

public class CartItem {
	private Book book;
	private int quantity;
	private int totalPrice;
	
	public CartItem() { } //기본생성자
	
	public CartItem(Book book) {
		super();
		this.book = book;
		this.quantity = 1;
		this.totalPrice = book.getUnitPrice();
	}
	

	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
		this.updateTotalPrice();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void updateTotalPrice() {
		totalPrice = this.book.getUnitPrice() * this.quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("book 유효성 검사 진입");
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		
		if(book==null) {
			if(other.book != null) {
				System.out.println("book이 비어있습니다. false반환");
				return false;
			}
			
		} else if (!(book.equals(other.book))) {
			System.out.println("해당 book과 동일하지 않습니다. false반환");
			return false;
		}
		
		
		return true;
	}

	
	
}
