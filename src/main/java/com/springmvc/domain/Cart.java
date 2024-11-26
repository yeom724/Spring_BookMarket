package com.springmvc.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart implements Serializable{
	
	private static final long serialVersionUID = -8285727197850448534L;
	
	private String cartId;
	private Map<String, CartItem> cartItems;
	private int grandTotal;
	
	public Cart() {
		cartItems = new HashMap<String, CartItem>();
		grandTotal = 0;
	}
	
	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}
	
	public void addCartItem(CartItem item) {
		//도서목록 중 선택한 도서를 장바구니에 등록하는 함수
		
		String bookId = item.getBook().getBookId();
		System.out.println("등록하기 위한 도서 ID 가져오는 중... " + bookId);
		//Book객체를 가지고 있기 때문에 Book함수 사용 가능
		
		if(cartItems.containsKey(bookId)) {
			System.out.println("장바구니에 동일한 도서 발견!");
			
			CartItem cartItem = cartItems.get(bookId); //Map으로 저장된 리스트에서 해당 도서만 가져오기 (key값이 도서아이디)
			cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
			System.out.println("장바구니 현재 개수 : " + cartItem.getQuantity());
			System.out.println("추가될 도서 개수 : " + item.getQuantity());
			cartItems.put(bookId, cartItem);
		} else {
			System.out.println("새로운 도서를 장바구니에 담습니다.");
			cartItems.put(bookId, item);
		}
		
		updateGrandTotal();
		System.out.println("총액을 갱신합니다.");
		
	}
	
	public void removeCartItem(CartItem item) {
		System.out.println("장바구니의 도서를 삭제합니다.");
		
		String bookId = item.getBook().getBookId();
		cartItems.remove(bookId);
		
		System.out.println("삭제를 완료했습니다.");
		
		updateGrandTotal();
	}
	

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void updateGrandTotal() {
		grandTotal = 0;
		
		for(CartItem item : cartItems.values()) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("cartId유효성 검사 진입");
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		
		
		if(cartId==null) {
			if(other.cartId != null) {
				System.out.println("book이 비어있습니다. false반환");
				return false;
			}
			
		} else if (!(cartId.equals(other.cartId))) {
			System.out.println("해당 book과 동일하지 않습니다. false반환");
			return false;
		}
		return true;
	}
	
	
}
