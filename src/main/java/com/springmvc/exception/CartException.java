package com.springmvc.exception;

public class CartException extends RuntimeException{

	private static final long serialVersionUID = 6457077274469537785L;
	private String cartId;
	
	public CartException(String cartId) {
		this.cartId = cartId;
	}


	public String getCartId() {
		System.out.println("예외발생?");
		return cartId;
	}
	
}
